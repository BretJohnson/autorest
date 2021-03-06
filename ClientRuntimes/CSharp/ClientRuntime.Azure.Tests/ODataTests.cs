﻿// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for license information.

using System;
using System.Linq;
using Microsoft.Rest.Azure.OData;
using Newtonsoft.Json;
using Xunit;

namespace Microsoft.Rest.ClientRuntime.Azure.Test
{
    public class ODataTests
    {
        [Fact]
        public void DefaultODataQueryTest()
        {
            var date = DateTime.SpecifyKind(new DateTime(2013, 11, 5), DateTimeKind.Utc);
            var date2 = DateTime.SpecifyKind(new DateTime(2004, 11, 5), DateTimeKind.Utc);

            var result = FilterString.Generate<Param1>(p => p.Foo == "foo" || p.Val < 20 || p.Foo == "bar" && p.Val == null &&
                p.Date > date2 &&
                p.Date < date && p.Values.Contains("x"));
            string time1 = Uri.EscapeDataString("2004-11-05T00:00:00Z");
            string time2 = Uri.EscapeDataString("2013-11-05T00:00:00Z");
            string expected = string.Format("foo eq 'foo' or Val lt 20 or foo eq 'bar' and Val eq null and d gt '{0}' " +
                "and d lt '{1}' and vals/any(c: c eq 'x')", time1, time2);
            Assert.Equal(expected, result);
        }

        [Fact]
        public void ParenthesisAreIgnoredInExpression()
        {
            var result = FilterString.Generate<Param1>(p => p.Foo == "bar" && (p.Foo == "foo" || p.Val < 20));
            Assert.Equal("foo eq 'bar' and foo eq 'foo' or Val lt 20", result);
        }

        [Fact]
        public void NotEqualsIsSupported()
        {
            var result = FilterString.Generate<Param1>(p => p.Val != 20);
            Assert.Equal("Val ne 20", result);
        }

        [Fact]
        public void ConditionalOperatorNotSupported()
        {
            Assert.Throws<NotSupportedException>(
                () => FilterString.Generate<Param1>(p => p.Val == (p.Boolean ? 20 : 30)));
        }

        [Fact]
        public void NotEqualsUnaryExpressionIsNotSupported()
        {
            Assert.Throws<NotSupportedException>(() => FilterString.Generate<Param1>(p => !p.Boolean));
            Assert.Throws<NotSupportedException>(() => FilterString.Generate<Param1>(p => !(p.Boolean)));
        }

        [Fact]
        public void ComplexUnaryOperatorsAreNotSupported()
        {
            Assert.Throws<NotSupportedException>(() => FilterString.Generate<Param1>(p => !(p.Boolean || p.Foo == "foo")));
        }

        [Fact]
        public void BooleansAreSupported()
        {
            var result = FilterString.Generate<Param1>(p => p.Boolean == true);
            Assert.Equal("Boolean eq true", result);
            result = FilterString.Generate<Param1>(p => p.Boolean);
            Assert.Equal("Boolean eq true", result);
            result = FilterString.Generate<Param1>(p => p.Boolean && p.Foo == "foo");
            Assert.Equal("Boolean eq true and foo eq 'foo'", result);
        }

        [Fact]
        public void VerifyDeepPropertiesInODataFilter()
        {
            var param = new InputParam2
            {
                Param = new InputParam1
                {
                    Value = "foo"
                }
            };
            var result = FilterString.Generate<Param1>(p => p.Foo == param.Param.Value);
            Assert.Equal("foo eq 'foo'", result);
        }

        [Fact]
        public void StartsWithWorksInODataFilter()
        {
            var param = new InputParam2
            {
                Param = new InputParam1
                {
                    Value = "foo"
                }
            };
            var result = FilterString.Generate<Param1>(p => p.Foo.StartsWith(param.Param.Value));
            Assert.Equal("startswith(foo, 'foo')", result);
        }

        [Fact]
        public void EndsWithWorksInODataFilter()
        {
            var param = new InputParam2
            {
                Param = new InputParam1
                {
                    Value = "foo"
                }
            };
            var result = FilterString.Generate<Param1>(p => p.Foo.EndsWith(param.Param.Value));
            Assert.Equal("endswith(foo, 'foo')", result);
        }

        [Fact]
        public void UnsupportedMethodThrowsNotSupportedException()
        {
			new InputParam2
            {
                Param = new InputParam1
                {
                    Value = "foo"
                }
            };
            Assert.Throws<NotSupportedException>(
                () => FilterString.Generate<Param1>(p => p.Foo.Replace(" ", "") == "abc"));
        }

        [Fact]
        public void StringContainsWorksInODataFilter()
        {
            var param = new InputParam2
            {
                Param = new InputParam1
                {
                    Value = "foo"
                }
            };
            var result = FilterString.Generate<Param1>(p => p.Foo.Contains(param.Param.Value));
            Assert.Equal("foo/any(c: c eq 'foo')", result);
        }

        [Fact]
        public void ArrayContainsWorksInODataFilter()
        {
            var result = FilterString.Generate<Param1>(p => p.Values.Contains("x"));
            Assert.Equal("vals/any(c: c eq 'x')", result);
        }

        [Fact]
        public void DefaultDateTimeProducesProperStringInODataFilter()
        {
            var result = FilterString.Generate<Param1>(p => p.Date2 == new DateTime(2012, 5, 1, 11, 5, 1, DateTimeKind.Utc));
            Assert.Equal("Date2 eq '" + Uri.EscapeDataString("2012-05-01T11:05:01Z") + "'", result);
        }

        [Fact]
        public void DateTimeIsConvertedToUtc()
        {
            var localDate = new DateTime(2012, 5, 1, 11, 5, 1, DateTimeKind.Local);
            var utcDate = localDate.ToUniversalTime();
            var result = FilterString.Generate<Param1>(p => p.Date2 == localDate);
            Assert.Equal("Date2 eq '" + Uri.EscapeDataString(utcDate.ToString("yyyy-MM-ddTHH:mm:ssZ")) + "'", result);
        }

        [Fact]
        public void EncodingTheParameters()
        {
            var param = new Param1
            {
                Foo = "Microsoft.Web/sites"
            };
            var result = FilterString.Generate<Param1>(p => p.Foo == param.Foo);
            Assert.Equal("foo eq 'Microsoft.Web%2Fsites'", result);
        }
    }

    public class Param1
    {
        [JsonProperty("foo")]
        public string Foo { get; set; }
        public int? Val { get; set; }
        public bool Boolean { get; set; }
        [JsonProperty("d")]
        public DateTime Date { get; set; }
        public DateTime Date2 { get; set; }
        [JsonProperty("vals")]
        public string[] Values { get; set; }
    }

    public class InputParam1
    {
        public string Value { get; set; }
    }

    public class InputParam2
    {
        public InputParam1 Param { get; set; }
    }
}
