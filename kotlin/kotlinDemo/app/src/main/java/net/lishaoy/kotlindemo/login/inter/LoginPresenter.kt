package net.lishaoy.kotlindemo.login.inter

import android.content.Context
import net.lishaoy.kotlindemo.base.IBasePresenter
import net.lishaoy.kotlindemo.entity.LoginData

interface LoginPresenter : IBasePresenter {

    fun login(
        context: Context,
        username: String,
        userpwd: String
    )

    interface OnLoginListener {
        fun loginSuccess(loginData: LoginData?)
        fun loginFailure(errorMsg: String?)
    }

}