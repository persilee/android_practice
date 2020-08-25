package net.lishaoy.kotlinbase

fun main() {

    var m1: () -> Unit

    var m2: (Int, Int) -> Int

    var m3: (String, String) -> Any?

    var m4: (Int, Double, String?) -> Boolean

    var m5: (Int, Int) -> Int = { n1, n2 -> n1 + n2 }
    println("m5:${m5(6, 66)}")

    var m6 = { n1: Int, n2: Int -> n1 + n2 }
    println("m6:${m6(6, 6)}")

    var m7 = { s1: String, s2: String -> println("m7: s1:$s1, s2:$s2") }
    m7("lsy", "persilee")

    var m8 = { str: String -> str }
    println("m8:${m8("lsy")}")

    var m9 = { i: Int ->
        when (i) {
            1 -> println("m9:数字是1")
            in 6..66 -> println("m9:数字是6到66之间")
            else -> println("m9:其他数字")
        }
    }
    m9(66)

    var m10 = { n1: Int -> println("m10:数字是$n1") }
    m10 = { println("m10:数字是$it(覆盖)") }
    m10(66)

    var m11 = { n1: Int ->
        println("m11:数字是$n1")
        n1 + 666
    }
    println("m11:${m11(6)}")

}