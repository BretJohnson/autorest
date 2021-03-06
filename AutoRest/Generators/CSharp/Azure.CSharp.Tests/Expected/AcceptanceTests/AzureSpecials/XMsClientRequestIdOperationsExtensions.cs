// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace Fixtures.Azure.AcceptanceTestsAzureSpecials
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Threading;
    using System.Threading.Tasks;
    using Microsoft.Rest;
    using Microsoft.Rest.Azure;
    using Models;

    public static partial class XMsClientRequestIdOperationsExtensions
    {
            /// <summary>
            /// Get method that overwrites x-ms-client-request header with value
            /// 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0.
            /// </summary>
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
            public static void Get(this IXMsClientRequestIdOperations operations)
            {
                Task.Factory.StartNew(s => ((IXMsClientRequestIdOperations)s).GetAsync(), operations, CancellationToken.None, TaskCreationOptions.None, TaskScheduler.Default).Unwrap().GetAwaiter().GetResult();
            }

            /// <summary>
            /// Get method that overwrites x-ms-client-request header with value
            /// 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0.
            /// </summary>
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
            /// <param name='cancellationToken'>
            /// The cancellation token.
            /// </param>
            public static async Task GetAsync( this IXMsClientRequestIdOperations operations, CancellationToken cancellationToken = default(CancellationToken))
            {
                await operations.GetWithHttpMessagesAsync(null, cancellationToken).ConfigureAwait(false);
            }

            /// <summary>
            /// Get method that overwrites x-ms-client-request header with value
            /// 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0.
            /// </summary>
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
            /// <param name='xMsClientRequestId'>
            /// This should appear as a method parameter, use value
            /// '9C4D50EE-2D56-4CD3-8152-34347DC9F2B0'
            /// </param>
            public static void ParamGet(this IXMsClientRequestIdOperations operations, string xMsClientRequestId)
            {
                Task.Factory.StartNew(s => ((IXMsClientRequestIdOperations)s).ParamGetAsync(xMsClientRequestId), operations, CancellationToken.None, TaskCreationOptions.None, TaskScheduler.Default).Unwrap().GetAwaiter().GetResult();
            }

            /// <summary>
            /// Get method that overwrites x-ms-client-request header with value
            /// 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0.
            /// </summary>
            /// <param name='operations'>
            /// The operations group for this extension method.
            /// </param>
            /// <param name='xMsClientRequestId'>
            /// This should appear as a method parameter, use value
            /// '9C4D50EE-2D56-4CD3-8152-34347DC9F2B0'
            /// </param>
            /// <param name='cancellationToken'>
            /// The cancellation token.
            /// </param>
            public static async Task ParamGetAsync( this IXMsClientRequestIdOperations operations, string xMsClientRequestId, CancellationToken cancellationToken = default(CancellationToken))
            {
                await operations.ParamGetWithHttpMessagesAsync(xMsClientRequestId, null, cancellationToken).ConfigureAwait(false);
            }

    }
}
