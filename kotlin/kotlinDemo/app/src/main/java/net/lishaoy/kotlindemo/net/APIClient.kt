package net.lishaoy.kotlindemo.net

import net.lishaoy.kotlindemo.config.Flag
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient {

    private object Holder {
        val INSTANCE = APIClient()
    }

    companion object {
        val instance = Holder.INSTANCE
    }

    fun <T> instanceRetrofit(apiInterface: Class<T>): T {

        val okHttpClient = OkHttpClient()
            .newBuilder()
            .readTimeout(666, TimeUnit.SECONDS) // 读取超时时间
            .connectTimeout(666, TimeUnit.SECONDS) // 连接超时时间
            .writeTimeout(666, TimeUnit.SECONDS) // 写出超时时间
            .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl(Flag.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        return retrofit.create(apiInterface)
    }

}