package ch.jdc.lexoranks.examples

import ch.jdc.lexoranks.*

fun main() {
    var items: MutableList<Sortable<Int>> = mutableListOf(
        ItemIntRank(name="Cat", rank=10),
        ItemIntRank(name="Dog", rank=20),
        ItemIntRank(name="Bird", rank=30),
    )

    println("We have a list of items with an integer rank.")
    println("Move Bird to the top")
    items.findByName("Bird")!!.rank = nextRank(0, items.findByName("Cat")!!.rank)

    println("We update only one item (instead of three) and the list is sorted correctly!")

    /**
     * Will print
     * ItemIntRank(name=Bird, rank=5)
     * ItemIntRank(name=Cat, rank=10)
     * ItemIntRank(name=Dog, rank=20)
     */
    items.sortByRank().println()

    println("Move Dog between Cat and Bird")
    items.findByName("Dog")!!.rank = nextRank(items.findByName("Cat")!!.rank, items.findByName("Bird")!!.rank)

    /**
     * Will print
     * ItemIntRank(name=Bird, rank=5)
     * ItemIntRank(name=Dog, rank=7)
     * ItemIntRank(name=Cat, rank=10)
     */
    items.sortByRank().println()
    println("We update only one item (instead of two) and the list is sorted correctly!")

    println("Move Cat to the top")
    items.findByName("Cat")!!.rank = nextRank(0, items.findByName("Bird")!!.rank)

    /**
     * Will print
     * ItemIntRank(name=Cat, rank=2)
     * ItemIntRank(name=Bird, rank=5)
     * ItemIntRank(name=Dog, rank=7)
     */
    items.sortByRank().println()

    println("Move Dog to the top")
    items.findByName("Dog")!!.rank = nextRank(0, items.findByName("Cat")!!.rank)

    /**
     * Will print
     * ItemIntRank(name=Dog, rank=1)
     * ItemIntRank(name=Cat, rank=2)
     * ItemIntRank(name=Bird, rank=5)
     */
    items.sortByRank().println()


    // Now we are stuck because we have no more space to move the items to the top
    // we need to balance the list to make space for the new items
    items = balance(items)

    /**
     * Will print
     * ItemIntRank(name=Dog, rank=10)
     * ItemIntRank(name=Cat, rank=20)
     * ItemIntRank(name=Bird, rank=30)
     */
    items.sortByRank().println()

}

private fun nextRank(prev: Int, next: Int): Int {
    return (prev + next) / 2
}

private fun balance(items: List<Sortable<Int>>): MutableList<Sortable<Int>> {
    println("We need to balance the list to make space for new items")

    val sorted = items.sortByRank()
    for (i in sorted.indices) {
        items[i].rank = (i+1) * 10
    }
    return sorted.toMutableList()
}



