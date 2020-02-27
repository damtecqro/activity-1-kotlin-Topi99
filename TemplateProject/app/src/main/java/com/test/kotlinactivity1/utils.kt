package com.example.lab01

fun <T> assertThat(test: T, must: T, number: Int) {
    if (test != must) {
        throw Error("\n-> Error in test #%d:\n\nExpected %s, but got %s".format(
            number, must.toString(), test.toString())
        )
    }

    println("Test #%d: Passed".format(number))
}

fun Int.isPrime() = this > 1 && (2..(this / 2)).all { this % it != 0 }

fun listPrimesInRange(range: IntRange): List<Int> = range.filter { it.isPrime() }