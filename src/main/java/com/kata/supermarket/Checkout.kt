package com.kata.supermarket

open class Checkout {
    private var items: MutableList<Item> = arrayListOf()

    fun scan(item: Item) {
        items.add(item)
    }

    fun total(): Double {
        var total = 0.00

        var itemACount = 0
        for (item in items) {
            if (isItemA(item)) {
                itemACount++
                if (itemACount == 3) {
                    total = total.plus(100).minus(80)
                    itemACount = 0
                } else {
                    total = getTotalPrice(item, total)
                }
            } else {
                total = getTotalPrice(item, total)
            }
        }
        return total
    }

    private fun getTotalPrice(item: Item, total: Double): Double {
        var total1 = total
        total1 = total1.plus(item.price)
        return total1
    }

    private fun isItemA(item: Item) = item.name == "A"

}