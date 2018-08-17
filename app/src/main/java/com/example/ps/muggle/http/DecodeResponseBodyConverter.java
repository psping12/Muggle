package com.example.ps.muggle.http;

import com.google.gson.TypeAdapter;
import com.orhanobut.logger.Logger;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class DecodeResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    DecodeResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        //解密字符串
        String str = value.string();
        Logger.e("ResponseBody1==>" + str);
        return adapter.fromJson(str);
    }
}
