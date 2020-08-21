package net.lishaoy.kotlindemo.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T : IBasePresenter> : AppCompatActivity() {

    lateinit var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    abstract fun createPresenter() : T

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    fun hideActionBar() {
        supportActionBar?.hide()
    }

    fun showActionBar() {
        supportActionBar?.show()
    }

}