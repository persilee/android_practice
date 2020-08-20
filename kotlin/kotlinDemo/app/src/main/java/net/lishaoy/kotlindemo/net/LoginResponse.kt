package net.lishaoy.kotlindemo.net

import android.content.Context
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import net.lishaoy.kotlindemo.entity.LoginDataWrapper
import net.lishaoy.kotlindemo.utils.LoadingDialog

abstract class LoginResponse<T>(val context: Context) : Observer<LoginDataWrapper<T>> {

    private var isShow: Boolean = true

    constructor(context: Context, isShow: Boolean = false) : this(context) {
        this.isShow = isShow
    }

    abstract fun success(data: T?)

    abstract fun failure(errorMsg: String?)

    override fun onSubscribe(d: Disposable) {
        if (isShow) LoadingDialog.show(context)
    }

    override fun onNext(t: LoginDataWrapper<T>) {
        if (t.data == null)
            failure("登录失败，msg：${t.errorMsg}")
        else
            success(t.data)
    }

    override fun onError(e: Throwable) {
        LoadingDialog.cancel()
        failure(e.message)
    }

    override fun onComplete() {
        LoadingDialog.cancel()
    }

}