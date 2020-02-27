package com.example.lab01

// Problem #40. Goldbach's conjecture.

/*
*
* Algorithm:
*
* goldbach(n: Integer):
*   fund: Integer
*
*   find in a list of prime numbers a number until:
*       n - number is a prime
*   found <- number
*
*   return a tuple (found, n - found)
*
* */

/*
*
* This algorithm is useful maybe in cryptography, while encrypting
* passwords, texts or other kind of information while generating
* the public and private keys which will be used to encrypt the data.
*
* */

fun Int.goldbach(): Pair<Int?, Int?> {
    val found = listPrimesInRange(2 until this).find {
        (this - it).isPrime()
    }

    if (found != null)
        return Pair(found, this - found)

    throw Error()
}

assertThat(4.goldbach(), Pair(2, 2), 1)
assertThat(28.goldbach(), Pair(5, 23), 2)
assertThat(30.goldbach(), Pair(7, 23), 3)
assertThat(74.goldbach(), Pair(3, 71), 4)
assertThat(98.goldbach(), Pair(19, 79), 5)