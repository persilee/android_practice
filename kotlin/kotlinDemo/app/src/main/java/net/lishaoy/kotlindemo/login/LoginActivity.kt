package net.lishaoy.kotlindemo.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyf.immersionbar.ImmersionBar
import net.lishaoy.kotlindemo.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        ImmersionBar.with(this)
            .statusBarColor(R.color.top_bg_color)
            .fitsSystemWindows(true)
            .init();
    }
}