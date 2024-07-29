package ch.jdc.lexoranks

interface Sortable<T: Comparable<T>> {
    var rank: T
    var name: String
}


fun <T : Comparable<T>> List<Sortable<T>>.sortByRank(): List<Sortable<T>> {
    return this.sortedBy { it.rank }
}

fun <T : Comparable<T>> List<Sortable<T>>.println() {
    this.forEach(::println)
}

fun <T : Comparable<T>> List<Sortable<T>>.findByName(name: String): Sortable<T>? {
    return this.find { it.name == name }
}

data class ItemLexicoRank(
    override var name: String,
    override var rank: String
): Sortable<String>

data class ItemIntRank(
    override var name: String,
    override var rank: Int
): Sortable<Int>

data class ItemDoubleRank(
    override var name: String,
    override var rank: Double
): Sortable<Double>
