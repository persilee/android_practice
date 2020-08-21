package net.lishaoy.kotlindemo.login

import android.content.Context
import net.lishaoy.kotlindemo.entity.LoginData
import net.lishaoy.kotlindemo.login.inter.LoginPresenter
import net.lishaoy.kotlindemo.login.inter.LoginView

class LoginPresenterImpl(var loginView: LoginView?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    private val loginModule: LoginModuleImpl = LoginModuleImpl()

    override fun login(context: Context, username: String, userpwd: String) {
        loginModule.login(context, username, userpwd, this)
    }

    override fun unAttachView() {
        loginView = null
        loginModule.cancelRequest()
    }

    override fun loginSuccess(loginData: LoginData?) {
        loginView?.loginSuccess(loginData)
    }

    override fun loginFailure(errorMsg: String?) {
        loginView?.loginFailure(errorMsg)
    }

}