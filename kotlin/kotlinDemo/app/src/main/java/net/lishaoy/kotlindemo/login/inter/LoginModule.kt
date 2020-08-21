package net.lishaoy.kotlindemo.login.inter

import android.content.Context

interface LoginModule {

    fun cancelRequest()

    fun login(
        context: Context,
        username: String,
        userpwd: String,

        onLoginListener: LoginPresenter.OnLoginListener
    )

}