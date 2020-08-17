package net.lishaoy.kotlinbase

fun main() {

    // var 关键字声明变量可以修改
    var name: String = "lsy"
    name = "persilee"
    println(name)

    // val 关键字声明变量不能修改
    val age: Int = 66
    //age = 16
    println(age)

    var s = "abc" // 类型推断

    println("name:$name, age:$age")

}

class Person {

    var name: String = "lsy"
    val age: Int = 66

}

