package com.example.lab01

// Problem #13. Run-length encoding of a list (direct solution).

/*
* Algorithm:
*
* encodeDirect(list: List of Some Type):
*   result <- an empty list
*   last <- last element of list
*   count <- 0
*
*   if size of list = 1:
*     return (1, last) as list
*
*   for each element and index in list:
*     if last = element:
*       count <- count + 1
*     else:
*       add (count, last) to result
*     if index + 1 = size of list:
*       add (count, element) to result
*
*     last = element
*
*   return result
*
*  */

/*
* This algorithm is useful if you want to encode or compress a file to save memory
* in disk. With the right adaptations, this algorithm might work with text files,
* images and many other file types.
* */

fun <T> encodeDirect(list: List<T>): List<Pair<Int, T>> {
    var result: List<Pair<Int, T>> = emptyList()
    var last: T = list[0]
    var count = 0

    if (list.size == 1) {
        return listOf(Pair(1, last))
    }

    list.forEachIndexed { index, element ->
        if (last == element) {
            count += 1
        } else {
            result += Pair(count, last)
            count = 1
        }

        if (index + 1 == list.size) {
            result += Pair(count, element)
        }
        last = element
    }

    return result
}

assertThat(
    encodeDirect("aaaabccaadeeee".toList()),
    listOf(
        Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
    ),
    1
)

assertThat(
    encodeDirect("abbcabb".toList()),
    listOf(
        Pair(1, 'a'), Pair(2, 'b'), Pair(1, 'c'), Pair(1, 'a'), Pair(2, 'b')
    ),
    2
)

assertThat(
    encodeDirect("abaaabab".toList()),
    listOf(
        Pair(1, 'a'), Pair(1, 'b'), Pair(3, 'a'), Pair(1, 'b'), Pair(1, 'a'), Pair(1, 'b')
    ),
    3
)

assertThat(
    encodeDirect("jjjjjjbbbkkkk".toList()),
    listOf(
        Pair(6, 'j'), Pair(3, 'b'), Pair(4, 'k')
    ),
    4
)

assertThat(
    encodeDirect(listOf(1, 1, 1, 4, 4, 4, 2)),
    listOf(
        Pair(3, 1), Pair(3, 4), Pair(1, 2)
    ),
    5
)