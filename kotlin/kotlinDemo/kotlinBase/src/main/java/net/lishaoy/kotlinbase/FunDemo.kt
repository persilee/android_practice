package net.lishaoy.kotlinbase

fun main() {
    println(add(6, 6))
    println(add2(6, 66))
    variableMethod(1, 2, 3, 4, 5, 6)

    //lamda函数
    var add3: (Int, Int) -> Int = { n1, n2 -> n1 + n2 }
    println(add3(66, 66))
}

// 返回值是Int
fun add(n1: Int, n2: Int): Int {
    return n1 + n2
}

// 类型推断
fun add2(n1: Int, n2: Int) = n1 + n2

fun variableMethod(vararg v: Int) {
    for (i in v) {
        if (i == v.size) println("$i") else print("$i, ")
    }
}