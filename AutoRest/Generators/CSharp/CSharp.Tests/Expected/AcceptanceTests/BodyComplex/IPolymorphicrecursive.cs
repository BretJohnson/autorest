// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace Fixtures.AcceptanceTestsBodyComplex
{
    using System;
    using System.Collections.Generic;
    using System.Net.Http;
    using System.Threading;
    using System.Threading.Tasks;
    using Microsoft.Rest;
    using Models;

    /// <summary>
    /// Polymorphicrecursive operations.
    /// </summary>
    public partial interface IPolymorphicrecursive
    {
        /// <summary>
        /// Get complex types that are polymorphic and have recursive
        /// references
        /// </summary>
        /// <param name='customHeaders'>
        /// The headers that will be added to request.
        /// </param>
        /// <param name='cancellationToken'>
        /// The cancellation token.
        /// </param>
        Task<HttpOperationResponse<Fish>> GetValidWithHttpMessagesAsync(Dictionary<string, List<string>> customHeaders = null, CancellationToken cancellationToken = default(CancellationToken));
        /// <summary>
        /// Put complex types that are polymorphic and have recursive
        /// references
        /// </summary>
        /// <param name='complexBody'>
        /// Please put a salmon that looks like this:
        /// {
        /// "dtype": "salmon",
        /// "species": "king",
        /// "length": 1,
        /// "age": 1,
        /// "location": "alaska",
        /// "iswild": true,
        /// "siblings": [
        /// {
        /// "dtype": "shark",
        /// "species": "predator",
        /// "length": 20,
        /// "age": 6,
        /// "siblings": [
        /// {
        /// "dtype": "salmon",
        /// "species": "coho",
        /// "length": 2,
        /// "age": 2,
        /// "location": "atlantic",
        /// "iswild": true,
        /// "siblings": [
        /// {
        /// "dtype": "shark",
        /// "species": "predator",
        /// "length": 20,
        /// "age": 6
        /// },
        /// {
        /// "dtype": "sawshark",
        /// "species": "dangerous",
        /// "length": 10,
        /// "age": 105
        /// }
        /// ]
        /// },
        /// {
        /// "dtype": "sawshark",
        /// "species": "dangerous",
        /// "length": 10,
        /// "age": 105
        /// }
        /// ]
        /// },
        /// {
        /// "dtype": "sawshark",
        /// "species": "dangerous",
        /// "length": 10,
        /// "age": 105
        /// }
        /// ]
        /// }
        /// </param>
        /// <param name='customHeaders'>
        /// The headers that will be added to request.
        /// </param>
        /// <param name='cancellationToken'>
        /// The cancellation token.
        /// </param>
        Task<HttpOperationResponse> PutValidWithHttpMessagesAsync(Fish complexBody, Dictionary<string, List<string>> customHeaders = null, CancellationToken cancellationToken = default(CancellationToken));
    }
}
