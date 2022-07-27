package com.javademo.common.utils;

import com.google.gson.Gson;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {
    private OkHttpUtil() {
    }

    public final static OkHttpClient client;

    static {
        client = new OkHttpClient().newBuilder()
                .callTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public static String commonCall(String url, MediaType mediaType, Map<String, Object> bodyNap, String method, Map<String, String> headers) {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(bodyNap), mediaType);
        Request.Builder reqBuilder = new Request.Builder();
        Request request = reqBuilder.method(method, body)
                .headers(buildHerders(headers))
                .url(url)
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                return response.message();
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Headers buildHerders(Map<String, String> headers) {
        Headers.Builder builder = new Headers.Builder();
        headers.forEach(builder::add);
        return builder.build();
    }
}
