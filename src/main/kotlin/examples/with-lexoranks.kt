package ch.jdc.lexoranks.examples

import ch.jdc.lexoranks.ItemLexicoRank
import ch.jdc.lexoranks.Sortable
import ch.jdc.lexoranks.println
import ch.jdc.lexoranks.sortByRank

fun main() {
    val items: MutableList<Sortable<String>> = mutableListOf(
        ItemLexicoRank(name="Item 1", rank="AAA"),
        ItemLexicoRank(name="Item 2", rank="BBB"),
        ItemLexicoRank(name="Item 3", rank="CCC"),
    )

    /**
     * Will print
     * ItemLexicoRank(name=Item 1, rank=AAA)
     * ItemLexicoRank(name=Item 2, rank=BBB)
     * ItemLexicoRank(name=Item 3, rank=CCC)
     */
    items.sortByRank().println()
    println("Now we move Item 1 to the end")
    items[0].rank = "DDD"

    /**
     * Will print
     * ItemLexicoRank(name=Item 2, rank=BBB)
     * ItemLexicoRank(name=Item 3, rank=CCC)
     * ItemLexicoRank(name=Item 1, rank=DDD)
     */
    items.sortByRank().println()

    println("Now we want to add a new item between Item 4 and Item 1.")

    items.add(ItemLexicoRank(name="Item 4", rank="DAA"))

    /**
     * Will print
     * ItemLexicoRank(name=Item 2, rank=BBB)
     * ItemLexicoRank(name=Item 3, rank=CCC)
     * ItemLexicoRank(name=Item 4, rank=DAA)
     * ItemLexicoRank(name=Item 1, rank=DDD)
     */
    items.sortByRank().println()

    println("We update only one item and the list is sorted correctly. This is the power of the LexoRank!")

}

