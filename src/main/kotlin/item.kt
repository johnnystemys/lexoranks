package ch.jdc.lexoranks

interface Sortable<T: Comparable<T>> {
    var rank: T
}

fun <T : Comparable<T>> List<Sortable<T>>.sortByRank(): List<Sortable<T>> {
    return this.sortedBy { it.rank }
}

fun <T : Comparable<T>> List<Sortable<T>>.println() {
    this.forEach(::println)
}

data class ItemLexicoRank(
    var name: String,
    override var rank: String
): Sortable<String>

data class ItemNumericalRank(
    var name: String,
    override var rank: Int
): Sortable<Int>
