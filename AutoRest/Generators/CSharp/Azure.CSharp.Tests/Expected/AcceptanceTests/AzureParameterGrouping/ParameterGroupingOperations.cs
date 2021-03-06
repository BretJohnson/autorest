// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace Fixtures.Azure.AcceptanceTestsAzureParameterGrouping
{
    using System;
    using System.Linq;
    using System.Collections.Generic;
    using System.Net;
    using System.Net.Http;
    using System.Net.Http.Headers;
    using System.Text;
    using System.Text.RegularExpressions;
    using System.Threading;
    using System.Threading.Tasks;
    using Microsoft.Rest;
    using Newtonsoft.Json;
    using Microsoft.Rest.Azure;
    using Models;

    /// <summary>
    /// ParameterGroupingOperations operations.
    /// </summary>
    internal partial class ParameterGroupingOperations : IServiceOperations<AutoRestParameterGroupingTestService>, IParameterGroupingOperations
    {
        /// <summary>
        /// Initializes a new instance of the ParameterGroupingOperations class.
        /// </summary>
        /// <param name='client'>
        /// Reference to the service client.
        /// </param>
        internal ParameterGroupingOperations(AutoRestParameterGroupingTestService client)
        {
            if (client == null) 
            {
                throw new ArgumentNullException("client");
            }
            this.Client = client;
        }

        /// <summary>
        /// Gets a reference to the AutoRestParameterGroupingTestService
        /// </summary>
        public AutoRestParameterGroupingTestService Client { get; private set; }

        /// <summary>
        /// Post a bunch of required parameters grouped
        /// </summary>
        /// <param name='parameterGroupingPostRequiredParameters'>
        /// Additional parameters for the operation
        /// </param>
        /// <param name='customHeaders'>
        /// Headers that will be added to request.
        /// </param>
        /// <param name='cancellationToken'>
        /// The cancellation token.
        /// </param>
        public async Task<AzureOperationResponse> PostRequiredWithHttpMessagesAsync(ParameterGroupingPostRequiredParameters parameterGroupingPostRequiredParameters, Dictionary<string, List<string>> customHeaders = null, CancellationToken cancellationToken = default(CancellationToken))
        {
            var body = (parameterGroupingPostRequiredParameters == null ? default(int?) : parameterGroupingPostRequiredParameters.Body);
            var customHeader = (parameterGroupingPostRequiredParameters == null ? default(string) : parameterGroupingPostRequiredParameters.CustomHeader);
            var query = (parameterGroupingPostRequiredParameters == null ? default(int?) : parameterGroupingPostRequiredParameters.Query);
            var path = (parameterGroupingPostRequiredParameters == null ? default(string) : parameterGroupingPostRequiredParameters.Path);
            if (body == null)
            {
                throw new ValidationException(ValidationRules.CannotBeNull, "body");
            }
            if (path == null)
            {
                throw new ValidationException(ValidationRules.CannotBeNull, "path");
            }
            // Tracing
            bool shouldTrace = ServiceClientTracing.IsEnabled;
            string invocationId = null;
            if (shouldTrace)
            {
                invocationId = ServiceClientTracing.NextInvocationId.ToString();
                Dictionary<string, object> tracingParameters = new Dictionary<string, object>();
                tracingParameters.Add("body", body);
                tracingParameters.Add("customHeader", customHeader);
                tracingParameters.Add("query", query);
                tracingParameters.Add("path", path);
                tracingParameters.Add("cancellationToken", cancellationToken);
                ServiceClientTracing.Enter(invocationId, this, "PostRequired", tracingParameters);
            }
            // Construct URL
            var baseUrl = this.Client.BaseUri.AbsoluteUri;
            var url = new Uri(new Uri(baseUrl + (baseUrl.EndsWith("/") ? "" : "/")), "parameterGrouping/postRequired/{path}").ToString();
            url = url.Replace("{path}", Uri.EscapeDataString(path));
            List<string> queryParameters = new List<string>();
            if (query != null)
            {
                queryParameters.Add(string.Format("query={0}", Uri.EscapeDataString(JsonConvert.SerializeObject(query, this.Client.SerializationSettings).Trim('"'))));
            }
            if (queryParameters.Count > 0)
            {
                url += "?" + string.Join("&", queryParameters);
            }
            // Create HTTP transport objects
            HttpRequestMessage httpRequest = new HttpRequestMessage();
            httpRequest.Method = new HttpMethod("POST");
            httpRequest.RequestUri = new Uri(url);
            // Set Headers
            httpRequest.Headers.TryAddWithoutValidation("x-ms-client-request-id", Guid.NewGuid().ToString());
            if (this.Client.AcceptLanguage != null)
            {
                if (httpRequest.Headers.Contains("accept-language"))
                {
                    httpRequest.Headers.Remove("accept-language");
                }
                httpRequest.Headers.TryAddWithoutValidation("accept-language", this.Client.AcceptLanguage);
            }
            if (customHeader != null)
            {
                if (httpRequest.Headers.Contains("customHeader"))
                {
                    httpRequest.Headers.Remove("customHeader");
                }
                httpRequest.Headers.TryAddWithoutValidation("customHeader", customHeader);
            }
            if (customHeaders != null)
            {
                foreach(var header in customHeaders)
                {
                    if (httpRequest.Headers.Contains(header.Key))
                    {
                        httpRequest.Headers.Remove(header.Key);
                    }
                    httpRequest.Headers.TryAddWithoutValidation(header.Key, header.Value);
                }
            }

            // Set Credentials
            if (this.Client.Credentials != null)
            {
                cancellationToken.ThrowIfCancellationRequested();
                await this.Client.Credentials.ProcessHttpRequestAsync(httpRequest, cancellationToken).ConfigureAwait(false);
            }
            // Serialize Request
            string requestContent = JsonConvert.SerializeObject(body, this.Client.SerializationSettings);
            httpRequest.Content = new StringContent(requestContent, Encoding.UTF8);
            httpRequest.Content.Headers.ContentType = MediaTypeHeaderValue.Parse("application/json; charset=utf-8");
            // Send Request
            if (shouldTrace)
            {
                ServiceClientTracing.SendRequest(invocationId, httpRequest);
            }
            cancellationToken.ThrowIfCancellationRequested();
            HttpResponseMessage httpResponse = await this.Client.HttpClient.SendAsync(httpRequest, cancellationToken).ConfigureAwait(false);
            if (shouldTrace)
            {
                ServiceClientTracing.ReceiveResponse(invocationId, httpResponse);
            }
            HttpStatusCode statusCode = httpResponse.StatusCode;
            cancellationToken.ThrowIfCancellationRequested();
            if (!(statusCode == (HttpStatusCode)Enum.Parse(typeof(HttpStatusCode), "OK")))
            {
                var ex = new HttpOperationException(string.Format("Operation returned an invalid status code '{0}'", statusCode));
                string responseContent = await httpResponse.Content.ReadAsStringAsync().ConfigureAwait(false);
                Error errorBody = JsonConvert.DeserializeObject<Error>(responseContent, this.Client.DeserializationSettings);
                if (errorBody != null)
                {
                    ex.Body = errorBody;
                }
                ex.Request = httpRequest;
                ex.Response = httpResponse;
                if (shouldTrace)
                {
                    ServiceClientTracing.Error(invocationId, ex);
                }
                throw ex;
            }
            // Create Result
            var result = new AzureOperationResponse();
            result.Request = httpRequest;
            result.Response = httpResponse;
            if (httpResponse.Headers.Contains("x-ms-request-id"))
            {
                result.RequestId = httpResponse.Headers.GetValues("x-ms-request-id").FirstOrDefault();
            }
            if (shouldTrace)
            {
                ServiceClientTracing.Exit(invocationId, result);
            }
            return result;
        }

        /// <summary>
        /// Post a bunch of optional parameters grouped
        /// </summary>
        /// <param name='parameterGroupingPostOptionalParameters'>
        /// Additional parameters for the operation
        /// </param>
        /// <param name='customHeaders'>
        /// Headers that will be added to request.
        /// </param>
        /// <param name='cancellationToken'>
        /// The cancellation token.
        /// </param>
        public async Task<AzureOperationResponse> PostOptionalWithHttpMessagesAsync(ParameterGroupingPostOptionalParameters parameterGroupingPostOptionalParameters = default(ParameterGroupingPostOptionalParameters), Dictionary<string, List<string>> customHeaders = null, CancellationToken cancellationToken = default(CancellationToken))
        {
            var customHeader = (parameterGroupingPostOptionalParameters == null ? default(string) : parameterGroupingPostOptionalParameters.CustomHeader);
            var query = (parameterGroupingPostOptionalParameters == null ? default(int?) : parameterGroupingPostOptionalParameters.Query);
            // Tracing
            bool shouldTrace = ServiceClientTracing.IsEnabled;
            string invocationId = null;
            if (shouldTrace)
            {
                invocationId = ServiceClientTracing.NextInvocationId.ToString();
                Dictionary<string, object> tracingParameters = new Dictionary<string, object>();
                tracingParameters.Add("customHeader", customHeader);
                tracingParameters.Add("query", query);
                tracingParameters.Add("cancellationToken", cancellationToken);
                ServiceClientTracing.Enter(invocationId, this, "PostOptional", tracingParameters);
            }
            // Construct URL
            var baseUrl = this.Client.BaseUri.AbsoluteUri;
            var url = new Uri(new Uri(baseUrl + (baseUrl.EndsWith("/") ? "" : "/")), "parameterGrouping/postOptional").ToString();
            List<string> queryParameters = new List<string>();
            if (query != null)
            {
                queryParameters.Add(string.Format("query={0}", Uri.EscapeDataString(JsonConvert.SerializeObject(query, this.Client.SerializationSettings).Trim('"'))));
            }
            if (queryParameters.Count > 0)
            {
                url += "?" + string.Join("&", queryParameters);
            }
            // Create HTTP transport objects
            HttpRequestMessage httpRequest = new HttpRequestMessage();
            httpRequest.Method = new HttpMethod("POST");
            httpRequest.RequestUri = new Uri(url);
            // Set Headers
            httpRequest.Headers.TryAddWithoutValidation("x-ms-client-request-id", Guid.NewGuid().ToString());
            if (this.Client.AcceptLanguage != null)
            {
                if (httpRequest.Headers.Contains("accept-language"))
                {
                    httpRequest.Headers.Remove("accept-language");
                }
                httpRequest.Headers.TryAddWithoutValidation("accept-language", this.Client.AcceptLanguage);
            }
            if (customHeader != null)
            {
                if (httpRequest.Headers.Contains("customHeader"))
                {
                    httpRequest.Headers.Remove("customHeader");
                }
                httpRequest.Headers.TryAddWithoutValidation("customHeader", customHeader);
            }
            if (customHeaders != null)
            {
                foreach(var header in customHeaders)
                {
                    if (httpRequest.Headers.Contains(header.Key))
                    {
                        httpRequest.Headers.Remove(header.Key);
                    }
                    httpRequest.Headers.TryAddWithoutValidation(header.Key, header.Value);
                }
            }

            // Set Credentials
            if (this.Client.Credentials != null)
            {
                cancellationToken.ThrowIfCancellationRequested();
                await this.Client.Credentials.ProcessHttpRequestAsync(httpRequest, cancellationToken).ConfigureAwait(false);
            }
            // Send Request
            if (shouldTrace)
            {
                ServiceClientTracing.SendRequest(invocationId, httpRequest);
            }
            cancellationToken.ThrowIfCancellationRequested();
            HttpResponseMessage httpResponse = await this.Client.HttpClient.SendAsync(httpRequest, cancellationToken).ConfigureAwait(false);
            if (shouldTrace)
            {
                ServiceClientTracing.ReceiveResponse(invocationId, httpResponse);
            }
            HttpStatusCode statusCode = httpResponse.StatusCode;
            cancellationToken.ThrowIfCancellationRequested();
            if (!(statusCode == (HttpStatusCode)Enum.Parse(typeof(HttpStatusCode), "OK")))
            {
                var ex = new HttpOperationException(string.Format("Operation returned an invalid status code '{0}'", statusCode));
                string responseContent = await httpResponse.Content.ReadAsStringAsync().ConfigureAwait(false);
                Error errorBody = JsonConvert.DeserializeObject<Error>(responseContent, this.Client.DeserializationSettings);
                if (errorBody != null)
                {
                    ex.Body = errorBody;
                }
                ex.Request = httpRequest;
                ex.Response = httpResponse;
                if (shouldTrace)
                {
                    ServiceClientTracing.Error(invocationId, ex);
                }
                throw ex;
            }
            // Create Result
            var result = new AzureOperationResponse();
            result.Request = httpRequest;
            result.Response = httpResponse;
            if (httpResponse.Headers.Contains("x-ms-request-id"))
            {
                result.RequestId = httpResponse.Headers.GetValues("x-ms-request-id").FirstOrDefault();
            }
            if (shouldTrace)
            {
                ServiceClientTracing.Exit(invocationId, result);
            }
            return result;
        }

        /// <summary>
        /// Post parameters from multiple different parameter groups
        /// </summary>
        /// <param name='firstParameterGroup'>
        /// Additional parameters for the operation
        /// </param>
        /// <param name='secondParameterGroup'>
        /// Additional parameters for the operation
        /// </param>
        /// <param name='customHeaders'>
        /// Headers that will be added to request.
        /// </param>
        /// <param name='cancellationToken'>
        /// The cancellation token.
        /// </param>
        public async Task<AzureOperationResponse> PostMultipleParameterGroupsWithHttpMessagesAsync(FirstParameterGroup firstParameterGroup = default(FirstParameterGroup), SecondParameterGroup secondParameterGroup = default(SecondParameterGroup), Dictionary<string, List<string>> customHeaders = null, CancellationToken cancellationToken = default(CancellationToken))
        {
            var headerOne = (firstParameterGroup == null ? default(string) : firstParameterGroup.HeaderOne);
            var queryOne = (firstParameterGroup == null ? default(int?) : firstParameterGroup.QueryOne);
            var headerTwo = (secondParameterGroup == null ? default(string) : secondParameterGroup.HeaderTwo);
            var queryTwo = (secondParameterGroup == null ? default(int?) : secondParameterGroup.QueryTwo);
            // Tracing
            bool shouldTrace = ServiceClientTracing.IsEnabled;
            string invocationId = null;
            if (shouldTrace)
            {
                invocationId = ServiceClientTracing.NextInvocationId.ToString();
                Dictionary<string, object> tracingParameters = new Dictionary<string, object>();
                tracingParameters.Add("headerOne", headerOne);
                tracingParameters.Add("queryOne", queryOne);
                tracingParameters.Add("headerTwo", headerTwo);
                tracingParameters.Add("queryTwo", queryTwo);
                tracingParameters.Add("cancellationToken", cancellationToken);
                ServiceClientTracing.Enter(invocationId, this, "PostMultipleParameterGroups", tracingParameters);
            }
            // Construct URL
            var baseUrl = this.Client.BaseUri.AbsoluteUri;
            var url = new Uri(new Uri(baseUrl + (baseUrl.EndsWith("/") ? "" : "/")), "parameterGrouping/postMultipleParameterGroups").ToString();
            List<string> queryParameters = new List<string>();
            if (queryOne != null)
            {
                queryParameters.Add(string.Format("query-one={0}", Uri.EscapeDataString(JsonConvert.SerializeObject(queryOne, this.Client.SerializationSettings).Trim('"'))));
            }
            if (queryTwo != null)
            {
                queryParameters.Add(string.Format("query-two={0}", Uri.EscapeDataString(JsonConvert.SerializeObject(queryTwo, this.Client.SerializationSettings).Trim('"'))));
            }
            if (queryParameters.Count > 0)
            {
                url += "?" + string.Join("&", queryParameters);
            }
            // Create HTTP transport objects
            HttpRequestMessage httpRequest = new HttpRequestMessage();
            httpRequest.Method = new HttpMethod("POST");
            httpRequest.RequestUri = new Uri(url);
            // Set Headers
            httpRequest.Headers.TryAddWithoutValidation("x-ms-client-request-id", Guid.NewGuid().ToString());
            if (this.Client.AcceptLanguage != null)
            {
                if (httpRequest.Headers.Contains("accept-language"))
                {
                    httpRequest.Headers.Remove("accept-language");
                }
                httpRequest.Headers.TryAddWithoutValidation("accept-language", this.Client.AcceptLanguage);
            }
            if (headerOne != null)
            {
                if (httpRequest.Headers.Contains("header-one"))
                {
                    httpRequest.Headers.Remove("header-one");
                }
                httpRequest.Headers.TryAddWithoutValidation("header-one", headerOne);
            }
            if (headerTwo != null)
            {
                if (httpRequest.Headers.Contains("header-two"))
                {
                    httpRequest.Headers.Remove("header-two");
                }
                httpRequest.Headers.TryAddWithoutValidation("header-two", headerTwo);
            }
            if (customHeaders != null)
            {
                foreach(var header in customHeaders)
                {
                    if (httpRequest.Headers.Contains(header.Key))
                    {
                        httpRequest.Headers.Remove(header.Key);
                    }
                    httpRequest.Headers.TryAddWithoutValidation(header.Key, header.Value);
                }
            }

            // Set Credentials
            if (this.Client.Credentials != null)
            {
                cancellationToken.ThrowIfCancellationRequested();
                await this.Client.Credentials.ProcessHttpRequestAsync(httpRequest, cancellationToken).ConfigureAwait(false);
            }
            // Send Request
            if (shouldTrace)
            {
                ServiceClientTracing.SendRequest(invocationId, httpRequest);
            }
            cancellationToken.ThrowIfCancellationRequested();
            HttpResponseMessage httpResponse = await this.Client.HttpClient.SendAsync(httpRequest, cancellationToken).ConfigureAwait(false);
            if (shouldTrace)
            {
                ServiceClientTracing.ReceiveResponse(invocationId, httpResponse);
            }
            HttpStatusCode statusCode = httpResponse.StatusCode;
            cancellationToken.ThrowIfCancellationRequested();
            if (!(statusCode == (HttpStatusCode)Enum.Parse(typeof(HttpStatusCode), "OK")))
            {
                var ex = new HttpOperationException(string.Format("Operation returned an invalid status code '{0}'", statusCode));
                string responseContent = await httpResponse.Content.ReadAsStringAsync().ConfigureAwait(false);
                Error errorBody = JsonConvert.DeserializeObject<Error>(responseContent, this.Client.DeserializationSettings);
                if (errorBody != null)
                {
                    ex.Body = errorBody;
                }
                ex.Request = httpRequest;
                ex.Response = httpResponse;
                if (shouldTrace)
                {
                    ServiceClientTracing.Error(invocationId, ex);
                }
                throw ex;
            }
            // Create Result
            var result = new AzureOperationResponse();
            result.Request = httpRequest;
            result.Response = httpResponse;
            if (httpResponse.Headers.Contains("x-ms-request-id"))
            {
                result.RequestId = httpResponse.Headers.GetValues("x-ms-request-id").FirstOrDefault();
            }
            if (shouldTrace)
            {
                ServiceClientTracing.Exit(invocationId, result);
            }
            return result;
        }

    }
}
