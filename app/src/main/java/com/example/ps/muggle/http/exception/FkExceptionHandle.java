package com.example.ps.muggle.http.exception;

import android.content.Context;

import com.example.ps.muggle.model.bean.RootBean;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;

import retrofit2.HttpException;

public class FkExceptionHandle {

    public static ApiException handleException(Throwable e, Context context) {
        ApiException ex;
        int code = -9999;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            code = httpException.code();
            String msg = null;
            String errString = null;
            try {
                errString = httpException.response().errorBody().string();
                if (errString != null) {
                    if (errString.contains("code") && errString.contains("errors")) {
                        Gson gson = new Gson();
                        RootBean result = gson.fromJson(errString, RootBean.class);
                        msg = result.getMsg();
                    }
                } else {
                    msg = "服务异常";
                }
            } catch (IOException e1) {
                msg = "服务异常";
            }
            ex = new ApiException(msg, code);
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new ApiException(resultException.message, resultException.code);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
            /*|| e instanceof ParseException*/) {
            ex = new ApiException("解析错误", ERROR.PARSE_ERROR);
        } else if (e instanceof ConnectException) {
            ex = new ApiException("连接失败", ERROR.NETWORD_ERROR);
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ApiException("证书验证失败", ERROR.SSL_ERROR);
        } else {
            ex = new ApiException("未知错误", ERROR.UNKNOWN);
        }
        return ex;
    }


    /**
     * 约定异常 没什么卵用 全是httpException
     */
    class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;
    }

    public static class ResponseThrowable extends Exception {
        public int code;
        public String message;

        public ResponseThrowable(Throwable throwable, int code) {
            super(throwable);
            this.code = code;
        }
    }

    /**
     * ServerException发生后，将自动转换为ResponseThrowable返回
     */
    class ServerException extends RuntimeException {
        int code;
        String message;
    }

}