/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.resourceflattening;

import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.ServiceClient;
import com.squareup.okhttp.OkHttpClient;
import retrofit.Retrofit;
import java.math.BigDecimal;
import com.google.common.reflect.TypeToken;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseBuilder;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.ServiceResponseEmptyCallback;
import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.Response;
import java.util.List;
import java.util.Map;
import fixtures.resourceflattening.models.ResourceCollection;
import fixtures.resourceflattening.models.Error;
import fixtures.resourceflattening.models.CloudError;
import fixtures.resourceflattening.models.Resource;
import fixtures.resourceflattening.models.FlattenedProduct;

/**
 * Initializes a new instance of the AutoRestResourceFlatteningTestService class.
 */
public class AutoRestResourceFlatteningTestServiceImpl extends ServiceClient implements AutoRestResourceFlatteningTestService {
    private AutoRestResourceFlatteningTestServiceService service;
    private String baseUri;

    /**
     * Gets the URI used as the base for all cloud service requests.
     * @return The BaseUri value.
     */
    public String getBaseUri() {
        return this.baseUri;
    }

    private ServiceClientCredentials credentials;

    /**
     * Gets The management credentials for Azure.
     *
     * @return the credentials value.
     */
    public ServiceClientCredentials getCredentials() {
        return this.credentials;
    }

    private String acceptLanguage;

    /**
     * Gets Gets or sets the preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String getAcceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets Gets or sets the preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     */
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    private int longRunningOperationRetryTimeout;

    /**
     * Gets The retry timeout for Long Running Operations.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int getLongRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets The retry timeout for Long Running Operations.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     */
    public void setLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
    }

    /**
     * Initializes an instance of AutoRestResourceFlatteningTestService client.
     */
    public AutoRestResourceFlatteningTestServiceImpl() {
        this("http://localhost");
    }

    /**
     * Initializes an instance of AutoRestResourceFlatteningTestService client.
     *
     * @param baseUri the base URI of the host
     */
    public AutoRestResourceFlatteningTestServiceImpl(String baseUri) {
        super();
        this.baseUri = baseUri;
        initialize();
    }

    /**
     * Initializes an instance of AutoRestResourceFlatteningTestService client.
     *
     * @param baseUri the base URI of the host
     * @param client the {@link OkHttpClient} client to use for REST calls
     * @param retrofitBuilder the builder for building up a {@link Retrofit}
     */
    public AutoRestResourceFlatteningTestServiceImpl(String baseUri, OkHttpClient client, Retrofit.Builder retrofitBuilder) {
        super(client, retrofitBuilder);
        this.baseUri = baseUri;
        initialize();
    }

    private void initialize() {
        if (this.credentials != null)
        {
            this.credentials.applyCredentialsFilter(this.client);
        }
        Retrofit retrofit = retrofitBuilder.baseUrl(baseUri).build();
        service = retrofit.create(AutoRestResourceFlatteningTestServiceService.class);
    }

    /**
     * Put External Resource as an Array
     *
     * @param resourceArray External Resource as an Array to put
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public void putArray(List<Resource> resourceArray) throws ServiceException {
        try {
            Call<ResponseBody> call = service.putArray(resourceArray, this.getAcceptLanguage());
            ServiceResponse<Void> response = putArrayDelegate(call.execute(), null);
            response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * Put External Resource as an Array
     *
     * @param resourceArray External Resource as an Array to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> putArrayAsync(List<Resource> resourceArray, final ServiceCallback<Void> serviceCallback) {
        Call<ResponseBody> call = service.putArray(resourceArray, this.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(putArrayDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> putArrayDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Void>()
                .register(200, new TypeToken<Void>(){}.getType())
                .registerError(new TypeToken<Error>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * Get External Resource as an Array
     *
     * @return the List&lt;FlattenedProduct&gt; object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public List<FlattenedProduct> getArray() throws ServiceException {
        try {
            Call<ResponseBody> call = service.getArray(this.getAcceptLanguage());
            ServiceResponse<List<FlattenedProduct>> response = getArrayDelegate(call.execute(), null);
            return response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * Get External Resource as an Array
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> getArrayAsync(final ServiceCallback<List<FlattenedProduct>> serviceCallback) {
        Call<ResponseBody> call = service.getArray(this.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<List<FlattenedProduct>>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(getArrayDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<List<FlattenedProduct>> getArrayDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<List<FlattenedProduct>>()
                .register(200, new TypeToken<List<FlattenedProduct>>(){}.getType())
                .registerError(new TypeToken<Error>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * Put External Resource as a Dictionary
     *
     * @param resourceDictionary External Resource as a Dictionary to put
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public void putDictionary(Map<String, FlattenedProduct> resourceDictionary) throws ServiceException {
        try {
            Call<ResponseBody> call = service.putDictionary(resourceDictionary, this.getAcceptLanguage());
            ServiceResponse<Void> response = putDictionaryDelegate(call.execute(), null);
            response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * Put External Resource as a Dictionary
     *
     * @param resourceDictionary External Resource as a Dictionary to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> putDictionaryAsync(Map<String, FlattenedProduct> resourceDictionary, final ServiceCallback<Void> serviceCallback) {
        Call<ResponseBody> call = service.putDictionary(resourceDictionary, this.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(putDictionaryDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> putDictionaryDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Void>()
                .register(200, new TypeToken<Void>(){}.getType())
                .registerError(new TypeToken<Error>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * Get External Resource as a Dictionary
     *
     * @return the Map&lt;String, FlattenedProduct&gt; object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public Map<String, FlattenedProduct> getDictionary() throws ServiceException {
        try {
            Call<ResponseBody> call = service.getDictionary(this.getAcceptLanguage());
            ServiceResponse<Map<String, FlattenedProduct>> response = getDictionaryDelegate(call.execute(), null);
            return response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * Get External Resource as a Dictionary
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> getDictionaryAsync(final ServiceCallback<Map<String, FlattenedProduct>> serviceCallback) {
        Call<ResponseBody> call = service.getDictionary(this.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Map<String, FlattenedProduct>>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(getDictionaryDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Map<String, FlattenedProduct>> getDictionaryDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Map<String, FlattenedProduct>>()
                .register(200, new TypeToken<Map<String, FlattenedProduct>>(){}.getType())
                .registerError(new TypeToken<Error>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * Put External Resource as a ResourceCollection
     *
     * @param resourceComplexObject External Resource as a ResourceCollection to put
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public void putResourceCollection(ResourceCollection resourceComplexObject) throws ServiceException {
        try {
            Call<ResponseBody> call = service.putResourceCollection(resourceComplexObject, this.getAcceptLanguage());
            ServiceResponse<Void> response = putResourceCollectionDelegate(call.execute(), null);
            response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * Put External Resource as a ResourceCollection
     *
     * @param resourceComplexObject External Resource as a ResourceCollection to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> putResourceCollectionAsync(ResourceCollection resourceComplexObject, final ServiceCallback<Void> serviceCallback) {
        Call<ResponseBody> call = service.putResourceCollection(resourceComplexObject, this.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(putResourceCollectionDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> putResourceCollectionDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Void>()
                .register(200, new TypeToken<Void>(){}.getType())
                .registerError(new TypeToken<Error>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * Get External Resource as a ResourceCollection
     *
     * @return the ResourceCollection object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public ResourceCollection getResourceCollection() throws ServiceException {
        try {
            Call<ResponseBody> call = service.getResourceCollection(this.getAcceptLanguage());
            ServiceResponse<ResourceCollection> response = getResourceCollectionDelegate(call.execute(), null);
            return response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * Get External Resource as a ResourceCollection
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> getResourceCollectionAsync(final ServiceCallback<ResourceCollection> serviceCallback) {
        Call<ResponseBody> call = service.getResourceCollection(this.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<ResourceCollection>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(getResourceCollectionDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<ResourceCollection> getResourceCollectionDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<ResourceCollection>()
                .register(200, new TypeToken<ResourceCollection>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

}
