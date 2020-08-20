package net.lishaoy.kotlindemo.api

import io.reactivex.Observable
import net.lishaoy.kotlindemo.entity.LoginData
import net.lishaoy.kotlindemo.entity.LoginDataWrapper
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @POST("/user/login")
    @FormUrlEncoded
    fun login(@Field("username") username: String,
              @Field("password") password: String)
    : Observable<LoginDataWrapper<LoginData>>

}