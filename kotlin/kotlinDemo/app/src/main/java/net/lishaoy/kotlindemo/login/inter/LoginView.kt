package net.lishaoy.kotlindemo.login.inter

import net.lishaoy.kotlindemo.entity.LoginData

interface LoginView {

    fun loginSuccess(loginData: LoginData?)
    fun loginFailure(errorMsg: String?)

}