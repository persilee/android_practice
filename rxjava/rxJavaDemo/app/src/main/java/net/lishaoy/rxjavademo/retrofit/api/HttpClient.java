package net.lishaoy.rxjavademo.retrofit.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {
    // api 的 base url
    public static String BASE_URL = "https://www.wanandroid.com/";

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    // 创建 Retrofit
    public static Retrofit getRetrofit() {
        // 创建 OkHttp 客户端
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 配置参数
        OkHttpClient httpClient = builder.addNetworkInterceptor(new StethoInterceptor())
                .readTimeout(6666, TimeUnit.SECONDS)
                .connectTimeout(6666, TimeUnit.SECONDS)
                .writeTimeout(6666, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(httpClient) // 使用 OkHttp 访问网络
                .addConverterFactory(GsonConverterFactory.create(new Gson())) // 设置 json 解析工具
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 设置 rxjava
                .build();
    }

}
