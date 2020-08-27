package net.lishaoy.kotlinbase

val name: String = "lsy"
val age: Int = 66

fun main() {
    login("lsy", "123") { name, pwd ->
        if (name == "lsy" && pwd == "123")
            println("$name:登录成功")
        else
            println("登录失败")
    }

    name.myRun {
        println(this.length)
        true
    }
}

fun login(userName: String, userPwd: String, requestLogin: (String, String) -> Unit): Unit {
    requestLogin(userName, userPwd)
}

fun <T> T.myRun(m: T.() -> Boolean) {
    println(this)
    println(m())
}

