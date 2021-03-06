/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.http;

import com.microsoft.rest.ServiceClient;
import com.squareup.okhttp.OkHttpClient;
import retrofit.Retrofit;

/**
 * Initializes a new instance of the AutoRestHttpInfrastructureTestService class.
 */
public class AutoRestHttpInfrastructureTestServiceImpl extends ServiceClient implements AutoRestHttpInfrastructureTestService {
    private String baseUri;

    /**
     * Gets the URI used as the base for all cloud service requests.
     * @return The BaseUri value.
     */
    public String getBaseUri() {
        return this.baseUri;
    }

    private HttpFailure httpFailure;

    /**
     * Gets the HttpFailure object to access its operations.
     * @return the httpFailure value.
     */
    public HttpFailure getHttpFailure() {
        return this.httpFailure;
    }

    private HttpSuccess httpSuccess;

    /**
     * Gets the HttpSuccess object to access its operations.
     * @return the httpSuccess value.
     */
    public HttpSuccess getHttpSuccess() {
        return this.httpSuccess;
    }

    private HttpRedirects httpRedirects;

    /**
     * Gets the HttpRedirects object to access its operations.
     * @return the httpRedirects value.
     */
    public HttpRedirects getHttpRedirects() {
        return this.httpRedirects;
    }

    private HttpClientFailure httpClientFailure;

    /**
     * Gets the HttpClientFailure object to access its operations.
     * @return the httpClientFailure value.
     */
    public HttpClientFailure getHttpClientFailure() {
        return this.httpClientFailure;
    }

    private HttpServerFailure httpServerFailure;

    /**
     * Gets the HttpServerFailure object to access its operations.
     * @return the httpServerFailure value.
     */
    public HttpServerFailure getHttpServerFailure() {
        return this.httpServerFailure;
    }

    private HttpRetry httpRetry;

    /**
     * Gets the HttpRetry object to access its operations.
     * @return the httpRetry value.
     */
    public HttpRetry getHttpRetry() {
        return this.httpRetry;
    }

    private MultipleResponses multipleResponses;

    /**
     * Gets the MultipleResponses object to access its operations.
     * @return the multipleResponses value.
     */
    public MultipleResponses getMultipleResponses() {
        return this.multipleResponses;
    }

    /**
     * Initializes an instance of AutoRestHttpInfrastructureTestService client.
     */
    public AutoRestHttpInfrastructureTestServiceImpl() {
        this("http://localhost");
    }

    /**
     * Initializes an instance of AutoRestHttpInfrastructureTestService client.
     *
     * @param baseUri the base URI of the host
     */
    public AutoRestHttpInfrastructureTestServiceImpl(String baseUri) {
        super();
        this.baseUri = baseUri;
        initialize();
    }

    /**
     * Initializes an instance of AutoRestHttpInfrastructureTestService client.
     *
     * @param baseUri the base URI of the host
     * @param client the {@link OkHttpClient} client to use for REST calls
     * @param retrofitBuilder the builder for building up a {@link Retrofit}
     */
    public AutoRestHttpInfrastructureTestServiceImpl(String baseUri, OkHttpClient client, Retrofit.Builder retrofitBuilder) {
        super(client, retrofitBuilder);
        this.baseUri = baseUri;
        initialize();
    }

    private void initialize() {
        Retrofit retrofit = retrofitBuilder.baseUrl(baseUri).build();
        this.httpFailure = new HttpFailureImpl(retrofit, this);
        this.httpSuccess = new HttpSuccessImpl(retrofit, this);
        this.httpRedirects = new HttpRedirectsImpl(retrofit, this);
        this.httpClientFailure = new HttpClientFailureImpl(retrofit, this);
        this.httpServerFailure = new HttpServerFailureImpl(retrofit, this);
        this.httpRetry = new HttpRetryImpl(retrofit, this);
        this.multipleResponses = new MultipleResponsesImpl(retrofit, this);
    }
}
