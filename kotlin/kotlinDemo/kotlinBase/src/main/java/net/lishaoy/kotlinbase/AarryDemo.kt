package net.lishaoy.kotlinbase

fun main() {

    val numbers = arrayOf(6,"lsy",3)
    println(numbers[1])
    for (number in numbers) {
        print("$number, ")
    }
    println()
    val number = Array(6) { v: Int -> v+6}
    for (i in number) {
        print("$i, ")
    }
}