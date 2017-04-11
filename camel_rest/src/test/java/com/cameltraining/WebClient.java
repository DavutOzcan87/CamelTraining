package com.cameltraining;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


/**
 * Created by Lenovo on 4/11/2017.
 */
public class WebClient {
    OkHttpClient client = new OkHttpClient();
    Request.Builder requestBuilder = new  Request.Builder();

    public WebClient()
    {

    }
    WebClient url(String url)
    {
        requestBuilder.url(url);
        return this;
    }

    WebResponse call()
    {
        try {
            Response response = client.newCall(requestBuilder.build()).execute();
            return new WebResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class WebResponse
    {

        private final Response response;

        public WebResponse(Response response) {
            this.response = response;
        }

        String body()
        {
            try {
                return response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
