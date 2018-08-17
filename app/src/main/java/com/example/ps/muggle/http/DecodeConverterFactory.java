package com.example.ps.muggle.http;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class DecodeConverterFactory extends Converter.Factory {

    public static DecodeConverterFactory create() {
        return create(new Gson());
    }

    public static DecodeConverterFactory create(Gson gson) {
        return new DecodeConverterFactory(gson);
    }

    private final Gson gson;

    private DecodeConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, java.lang.annotation.Annotation[] parameterAnnotations, java.lang.annotation.Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new DecodeRequestBodyConverter<>(gson, adapter);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, java.lang.annotation.Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new DecodeResponseBodyConverter<>(adapter);
    }
}
