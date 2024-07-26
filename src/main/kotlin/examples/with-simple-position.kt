package ch.jdc.lexoranks.examples

import ch.jdc.lexoranks.ItemNumericalRank
import ch.jdc.lexoranks.println
import ch.jdc.lexoranks.sortByRank

fun main() {
    val items = listOf(
        ItemNumericalRank(name="Item 1", rank=1),
        ItemNumericalRank(name="Item 2", rank=2),
        ItemNumericalRank(name="Item 3", rank=3),
    )

    items.sortByRank().println()
    println("Now we move Item 1 to the end")
    items[0].rank = 3
    items[2].rank = 1
    items[1].rank = 2
    items.sortByRank().println()

    println("We needed to do three updates to get the list sorted correctly. this could be a problem in a real-world scenario.")
}
