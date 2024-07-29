package ch.jdc.lexoranks.examples

import ch.jdc.lexoranks.*

fun main() {
    val items: MutableList<Sortable<Double>> = mutableListOf(
        ItemDoubleRank(name="Cat", rank=10.0),
        ItemDoubleRank(name="Dog", rank=20.0),
        ItemDoubleRank(name="Bird", rank=30.0),
    )

    println("We have a list of items with a double rank.")
    println("Move Item 2 to the top")

    items.findByName("Bird")!!.rank = nextRank(0.0, items.findByName("Cat")!!.rank)


    /**
     * Will print
     * ItemDoubleRank(name=Bird, rank=5.0)
     * ItemDoubleRank(name=Cat, rank=10.0)
     * ItemDoubleRank(name=Dog, rank=20.0)
     */
    items.sortByRank().println()

    println("We update only one item (instead of three) and the list is sorted correctly!")

    println("Move Dog between Cat and Bird")
    items.findByName("Dog")!!.rank = nextRank(items.findByName("Cat")!!.rank, items.findByName("Bird")!!.rank)

    /**
     * Will print
     * ItemDoubleRank(name=Bird, rank=5.0)
     * ItemDoubleRank(name=Dog, rank=7.5)
     * ItemDoubleRank(name=Cat, rank=10.0)
     */
    items.sortByRank().println()

    println("We update only one item (instead of two) and the list is sorted correctly!")
}

private fun nextRank(prev: Double, next: Double): Double {
    return (prev + next) / 2
}

