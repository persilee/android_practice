package net.lishaoy.kotlindemo.login

import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.lishaoy.kotlindemo.api.Api
import net.lishaoy.kotlindemo.entity.LoginData
import net.lishaoy.kotlindemo.login.inter.LoginModule
import net.lishaoy.kotlindemo.login.inter.LoginPresenter
import net.lishaoy.kotlindemo.net.APIClient
import net.lishaoy.kotlindemo.net.LoginResponse

class LoginModuleImpl: LoginModule {

    override fun cancelRequest() {
        TODO("Not yet implemented")
    }

    override fun login(
        context: Context,
        username: String,
        userpwd: String,
        onLoginListener: LoginPresenter.OnLoginListener
    ) {
        APIClient.instance.instanceRetrofit(Api::class.java)
            .login(username, userpwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : LoginResponse<LoginData>(context) {
                override fun success(data: LoginData?) {
                    onLoginListener.loginSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    onLoginListener.loginFailure(errorMsg)
                }

            })
    }
}