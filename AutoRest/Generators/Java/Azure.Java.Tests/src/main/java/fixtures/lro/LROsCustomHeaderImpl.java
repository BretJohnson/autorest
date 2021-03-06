/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.12.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.lro;

import com.google.common.reflect.TypeToken;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseBuilder;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.ServiceResponseEmptyCallback;
import com.squareup.okhttp.ResponseBody;
import retrofit.Retrofit;
import retrofit.Call;
import retrofit.Response;
import fixtures.lro.models.Product;
import fixtures.lro.models.CloudError;

public class LROsCustomHeaderImpl implements LROsCustomHeader {
    private LROsCustomHeaderService service;
    AutoRestLongRunningOperationTestService client;

    public LROsCustomHeaderImpl(Retrofit retrofit, AutoRestLongRunningOperationTestService client) {
        this.service = retrofit.create(LROsCustomHeaderService.class);
        this.client = client;
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 200 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @return the Product object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public Product putAsyncRetrySucceeded(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.putAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
            ServiceResponse<Product> response = putAsyncRetrySucceededDelegate(call.execute(), null);
            return response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 200 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> putAsyncRetrySucceededAsync(Product product, final ServiceCallback<Product> serviceCallback) {
        Call<ResponseBody> call = service.putAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Product>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(putAsyncRetrySucceededDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Product> putAsyncRetrySucceededDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Product>()
                .register(200, new TypeToken<Product>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 200 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @return the Product object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public Product beginPutAsyncRetrySucceeded(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.beginPutAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
            ServiceResponse<Product> response = beginPutAsyncRetrySucceededDelegate(call.execute(), null);
            return response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 200 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> beginPutAsyncRetrySucceededAsync(Product product, final ServiceCallback<Product> serviceCallback) {
        Call<ResponseBody> call = service.beginPutAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Product>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(beginPutAsyncRetrySucceededDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Product> beginPutAsyncRetrySucceededDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Product>()
                .register(200, new TypeToken<Product>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 201 to the initial request, with an entity that contains ProvisioningState=’Creating’.  Polls return this value until the last poll returns a ‘200’ with ProvisioningState=’Succeeded’
     *
     * @param product Product to put
     * @return the Product object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public Product put201CreatingSucceeded200(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.put201CreatingSucceeded200(product, this.client.getAcceptLanguage());
            ServiceResponse<Product> response = put201CreatingSucceeded200Delegate(call.execute(), null);
            return response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 201 to the initial request, with an entity that contains ProvisioningState=’Creating’.  Polls return this value until the last poll returns a ‘200’ with ProvisioningState=’Succeeded’
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> put201CreatingSucceeded200Async(Product product, final ServiceCallback<Product> serviceCallback) {
        Call<ResponseBody> call = service.put201CreatingSucceeded200(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Product>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(put201CreatingSucceeded200Delegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Product> put201CreatingSucceeded200Delegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Product>()
                .register(200, new TypeToken<Product>(){}.getType())
                .register(201, new TypeToken<Product>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 201 to the initial request, with an entity that contains ProvisioningState=’Creating’.  Polls return this value until the last poll returns a ‘200’ with ProvisioningState=’Succeeded’
     *
     * @param product Product to put
     * @return the Product object if successful.
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public Product beginPut201CreatingSucceeded200(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.beginPut201CreatingSucceeded200(product, this.client.getAcceptLanguage());
            ServiceResponse<Product> response = beginPut201CreatingSucceeded200Delegate(call.execute(), null);
            return response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running put request, service returns a 201 to the initial request, with an entity that contains ProvisioningState=’Creating’.  Polls return this value until the last poll returns a ‘200’ with ProvisioningState=’Succeeded’
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> beginPut201CreatingSucceeded200Async(Product product, final ServiceCallback<Product> serviceCallback) {
        Call<ResponseBody> call = service.beginPut201CreatingSucceeded200(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Product>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(beginPut201CreatingSucceeded200Delegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Product> beginPut201CreatingSucceeded200Delegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Product>()
                .register(200, new TypeToken<Product>(){}.getType())
                .register(201, new TypeToken<Product>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with 'Location' and 'Retry-After' headers, Polls return a 200 with a response body after success
     *
     * @param product Product to put
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public void post202Retry200(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.post202Retry200(product, this.client.getAcceptLanguage());
            ServiceResponse<Void> response = post202Retry200Delegate(call.execute(), null);
            response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with 'Location' and 'Retry-After' headers, Polls return a 200 with a response body after success
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> post202Retry200Async(Product product, final ServiceCallback<Void> serviceCallback) {
        Call<ResponseBody> call = service.post202Retry200(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(post202Retry200Delegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> post202Retry200Delegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Void>()
                .register(202, new TypeToken<Void>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with 'Location' and 'Retry-After' headers, Polls return a 200 with a response body after success
     *
     * @param product Product to put
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public void beginPost202Retry200(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.beginPost202Retry200(product, this.client.getAcceptLanguage());
            ServiceResponse<Void> response = beginPost202Retry200Delegate(call.execute(), null);
            response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with 'Location' and 'Retry-After' headers, Polls return a 200 with a response body after success
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> beginPost202Retry200Async(Product product, final ServiceCallback<Void> serviceCallback) {
        Call<ResponseBody> call = service.beginPost202Retry200(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(beginPost202Retry200Delegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> beginPost202Retry200Delegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Void>()
                .register(202, new TypeToken<Void>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public void postAsyncRetrySucceeded(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.postAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
            ServiceResponse<Void> response = postAsyncRetrySucceededDelegate(call.execute(), null);
            response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> postAsyncRetrySucceededAsync(Product product, final ServiceCallback<Void> serviceCallback) {
        Call<ResponseBody> call = service.postAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(postAsyncRetrySucceededDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> postAsyncRetrySucceededDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Void>()
                .register(202, new TypeToken<Void>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @throws ServiceException the exception wrapped in ServiceException if failed.
     */
    public void beginPostAsyncRetrySucceeded(Product product) throws ServiceException {
        try {
            Call<ResponseBody> call = service.beginPostAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
            ServiceResponse<Void> response = beginPostAsyncRetrySucceededDelegate(call.execute(), null);
            response.getBody();
        } catch (ServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ServiceException(ex);
        }
    }

    /**
     * x-ms-client-request-id = 9C4D50EE-2D56-4CD3-8152-34347DC9F2B0 is required message header for all requests. Long running post request, service returns a 202 to the initial request, with an entity that contains ProvisioningState=’Creating’. Poll the endpoint indicated in the Azure-AsyncOperation header for operation status
     *
     * @param product Product to put
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     */
    public Call<ResponseBody> beginPostAsyncRetrySucceededAsync(Product product, final ServiceCallback<Void> serviceCallback) {
        Call<ResponseBody> call = service.beginPostAsyncRetrySucceeded(product, this.client.getAcceptLanguage());
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofit) {
                try {
                    serviceCallback.success(beginPostAsyncRetrySucceededDelegate(response, retrofit));
                } catch (ServiceException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return call;
    }

    private ServiceResponse<Void> beginPostAsyncRetrySucceededDelegate(Response<ResponseBody> response, Retrofit retrofit) throws ServiceException {
        return new ServiceResponseBuilder<Void>()
                .register(202, new TypeToken<Void>(){}.getType())
                .registerError(new TypeToken<CloudError>(){}.getType())
                .build(response, retrofit);
    }

}
