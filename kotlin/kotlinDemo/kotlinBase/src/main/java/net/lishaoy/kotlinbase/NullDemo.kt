package net.lishaoy.kotlinbase

fun main() {
    var str: String? = null

    println(str)

    fun method(name: String): Int? {
        if (name == "lsy") return 666
        return null
    }

    println(method("lsy"))
}