package com.javademo.common.utils;

import com.google.gson.Gson;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {
    private static final OkHttpUtil INSTANCE = new OkHttpUtil();

    public static OkHttpUtil getInstance() {
        return INSTANCE;
    }

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

    public static String commonCall(String url, MediaType mediaType, Map<String, Object> bodyMap, String method, Map<String, String> headers) {
        Gson gson = new Gson();
        Request.Builder reqBuilder = new Request.Builder();
        if (!CollectionUtils.isEmpty(bodyMap)) {
            RequestBody body = RequestBody.create(gson.toJson(bodyMap), mediaType);
            reqBuilder.method(method, body);
        } else {
            reqBuilder.method(method, null);
        }
        Request request = reqBuilder
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


    public String postFile(String url, OkHttpUploadEntity uploadEntity, Map<String, String> headers) throws IOException {
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(uploadEntity.mediaType);
        if (!CollectionUtils.isEmpty(uploadEntity.getParams())) {
            for (Map.Entry<String, String> param : uploadEntity.getParams().entrySet()) {
                multipartBuilder.addFormDataPart(param.getKey(), param.getValue());
            }
        }
        multipartBuilder.addFormDataPart(uploadEntity.getFileParamName(),
                uploadEntity.getFilename(),
                RequestBody.create(uploadEntity.getFileBytes(), uploadEntity.mediaType));
        Request.Builder requestBuilder = new Request.Builder()
                .url(url)
                .headers(buildHerders(headers))
                .post(multipartBuilder.build());
        Response response = client.newCall(requestBuilder.build()).execute();
        if (!response.isSuccessful()) {
            throw new RuntimeException(response.message());
        }
        return response.body().string();
    }

    public static Map<String, String> generateBasicHeader(String base64Str) {
        return Map.of("Authorization", "Basic " + base64Str);
    }

    public static Map<String, String> generateBearerHeader(String token) {
        return Map.of("Authorization", "Bearer " + token);
    }

    public static class OkHttpUploadEntity {
        private Map<String, String> params;
        private byte[] fileBytes;
        private MediaType mediaType;
        private String filename;
        private String fileParamName;

        public Map<String, String> getParams() {
            return params;
        }

        public void setParams(Map<String, String> params) {
            this.params = params;
        }

        public byte[] getFileBytes() {
            return fileBytes;
        }

        public void setFileBytes(byte[] fileBytes) {
            this.fileBytes = fileBytes;
        }

        public MediaType getMediaType() {
            return mediaType;
        }

        public void setMediaType(MediaType mediaType) {
            this.mediaType = mediaType;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFileParamName() {
            return fileParamName;
        }

        public void setFileParamName(String fileParamName) {
            this.fileParamName = fileParamName;
        }
    }
}
