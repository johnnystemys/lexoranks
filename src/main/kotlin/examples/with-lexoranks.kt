package ch.jdc.lexoranks.examples

val MIN_RANK = "00000"
val MAX_RANK = "zzzzz"
val VALUES = "0123456789abcdefghijklmnopqrstuvwxyz"

fun main() {
    val itemA= "aaaaa"
    val itemB= "bbbbb"
    val itemC= "ccccc"

    println("We have a list of items with a lexico rank.")
    println("Move Item C between Item A and Item B")
    println("Compute the new rank for Item C based on the ranks of Item A and Item B should be ${computeRank(itemA, itemB)}")
    println("Compute the new rank for Item N based on the ranks of Item B and Item C should be ${computeRank(itemB, itemC)}")

}

fun base36ToBase10(value: String): Long {
    return value.fold(0L) { acc, c -> acc * 36 + VALUES.indexOf(c) }
}

fun base10ToBase36(value: Long): String {
    return if (value == 0L) {
        MIN_RANK
    } else {
        var v = value
        val sb = StringBuilder()
        while (v > 0) {
            sb.append(VALUES[(v % 36).toInt()])
            v /= 36
        }
        sb.reverse().toString()
    }
}

fun computeRank(rankA: String, rankB: String): String {
    val valueA = base36ToBase10(rankA)
    val valueB = base36ToBase10(rankB)
    val valueC = (valueA + valueB) / 2
    return base10ToBase36(valueC)
}

