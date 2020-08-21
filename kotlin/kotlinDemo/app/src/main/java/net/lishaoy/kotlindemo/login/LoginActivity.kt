package net.lishaoy.kotlindemo.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gyf.immersionbar.ImmersionBar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import net.lishaoy.kotlindemo.R
import net.lishaoy.kotlindemo.api.Api
import net.lishaoy.kotlindemo.base.BaseActivity
import net.lishaoy.kotlindemo.entity.LoginData
import net.lishaoy.kotlindemo.login.inter.LoginPresenter
import net.lishaoy.kotlindemo.login.inter.LoginView
import net.lishaoy.kotlindemo.net.APIClient
import net.lishaoy.kotlindemo.net.LoginResponse

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        hideActionBar()

        ImmersionBar.with(this)
            .statusBarColor(R.color.top_bg_color)
            .fitsSystemWindows(true)
            .init();

        login_btn.setOnClickListener(onClickListener)


    }

    private val onClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.login_btn -> {
                val userName = user_name.text.toString()
                val userPwd = user_pwd.text.toString()
                presenter.login(this@LoginActivity, userName, userPwd)
            }
        }
    }

    override fun loginSuccess(loginData: LoginData?) {
        Toast.makeText(this@LoginActivity, "登录成功", Toast.LENGTH_SHORT).show()
    }

    override fun loginFailure(errorMsg: String?) {
        Toast.makeText(this@LoginActivity, "登录失败", Toast.LENGTH_SHORT).show()
    }

    override fun createPresenter(): LoginPresenter = LoginPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }
}