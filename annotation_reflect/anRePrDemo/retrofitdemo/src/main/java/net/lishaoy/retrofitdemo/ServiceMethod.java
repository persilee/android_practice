package net.lishaoy.retrofitdemo;

import net.lishaoy.retrofitdemo.annotation.Field;
import net.lishaoy.retrofitdemo.annotation.Get;
import net.lishaoy.retrofitdemo.annotation.Post;
import net.lishaoy.retrofitdemo.annotation.Query;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;

public class ServiceMethod {

    private final Call.Factory callFactory;
    private final String relativeUrl;
    private final boolean hasBody;
    private final ParameterHandler[] parameterHandler;
    private FormBody.Builder formBuild;
    HttpUrl baseUrl;
    String httpMethod;
    HttpUrl.Builder urlBuilder;

    public ServiceMethod(Builder builder) {
        baseUrl = builder.lsyRetrofit.baseUrl;
        callFactory = builder.lsyRetrofit.factory;

        httpMethod = builder.httpMethod;
        relativeUrl = builder.relativeUrl;
        hasBody = builder.hasBody;
        parameterHandler = builder.parameterHandler;

        if (hasBody) {
            formBuild = new FormBody.Builder();
        }
    }

    public Object invoke(Object[] args) {
        for (int i = 0; i < parameterHandler.length; i++) {
            ParameterHandler handler = parameterHandler[i];
            handler.apply(this, args[i].toString());
        }

        HttpUrl url;
        if (urlBuilder == null) {
            urlBuilder = baseUrl.newBuilder(relativeUrl);
        }
        url = urlBuilder.build();

        FormBody formBody = null;
        if (formBody != null) {
            formBody = formBuild.build();
        }

        Request request = new Request.Builder().url(url).method(httpMethod, formBody).build();

        return callFactory.newCall(request);
    }

    public void addQueryParameter(String key, String value) {
        if (urlBuilder == null) {
            urlBuilder = baseUrl.newBuilder(relativeUrl);
        }
        urlBuilder.addQueryParameter(key, value);
    }

    public void addFiledParameter(String key, String value) {
        formBuild.add(key, value);
    }

    public static class Builder {

        private final LsyRetrofit lsyRetrofit;
        private final Annotation[] methodAnnotations;
        private final Annotation[][] parameterAnnotations;
        ParameterHandler[] parameterHandler;
        private String httpMethod;
        private String relativeUrl;
        private boolean hasBody;

        public Builder(LsyRetrofit lsyRetrofit, Method method) {
            this.lsyRetrofit = lsyRetrofit;
            // 获取方法上的所有注解
            methodAnnotations = method.getAnnotations();
            // 获取参数上的所有注解
            parameterAnnotations = method.getParameterAnnotations();
        }

        public ServiceMethod build() {

            for (Annotation methodAnnotation: methodAnnotations) {
                if(methodAnnotation instanceof Post) {
                    this.httpMethod = "POST";
                    this.relativeUrl = ((Post) methodAnnotation).value();
                    this.hasBody = true;
                }else if (methodAnnotation instanceof Get) {
                    this.httpMethod = "GET";
                    this.relativeUrl = ((Get) methodAnnotation).value();
                    this.hasBody = false;
                }
            }

            int length = parameterAnnotations.length;
            parameterHandler = new ParameterHandler[length];
            for (int i = 0; i < length; i++) {
                Annotation[] annotations = parameterAnnotations[i];
                for (Annotation annotation: annotations) {
                    if (annotation instanceof Field) {
                        String value = ((Field) annotation).value();
                        parameterHandler[i] = new ParameterHandler.FileParameterHandler(value);
                    }else if (annotation instanceof Query) {
                        String value = ((Query) annotation).value();
                        parameterHandler[i] = new ParameterHandler.QueryParameterHandler(value);
                    }
                }
            }

            return new ServiceMethod(this);
        }
    }
}
