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
import net.lishaoy.kotlindemo.entity.LoginData
import net.lishaoy.kotlindemo.net.APIClient
import net.lishaoy.kotlindemo.net.LoginResponse

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

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
                APIClient.instance.instanceRetrofit(Api::class.java)
                    .login(userName, userPwd)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : LoginResponse<LoginData>(this) {
                        override fun success(data: LoginData?) {
                            Toast.makeText(this@LoginActivity, "登录成功", Toast.LENGTH_SHORT).show()
                        }

                        override fun failure(errorMsg: String?) {
                            Toast.makeText(this@LoginActivity, "登录失败", Toast.LENGTH_SHORT).show()
                        }

                    })
            }
        }
    }
}