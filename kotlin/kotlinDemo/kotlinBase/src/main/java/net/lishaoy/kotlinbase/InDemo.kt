package net.lishaoy.kotlinbase

fun main() {

    for (i in 1..6) {
        print(i)
    }
    println()
    for (i in 6 downTo 1) {
        print(i)
    }
    println()
    var v = 66
    if (v in 1..100) println("包含$v") else println("不包含$v")
    for (i in 1..6 step 2) print(i)
    println()
    for (i in 1 until 6) print(i)
}