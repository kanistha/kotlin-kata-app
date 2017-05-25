package com.kata.supermarket

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class CheckoutTest {

    private  val checkout = Checkout()

//    1) Get the unit price of item 'A'
//    Given cost for item 'A' is 40 cents
//    when customer wants to buy one 'A'
//    then he will pay 40 cents
   @Test
    fun `getPrice - returns given item unit price`() {
        //Given
        val itemA: Item = Item("A", 40.00)
        val itemB: Item = Item("B", 50.00)

        //when & then
        assertThat(itemA.price).isEqualTo(40.00)
        assertThat(itemB.price).isEqualTo(50.00)
    }

    @Test
    fun `getTotal - returns the total 80 for two items of A in basket on checkout`(){
        val itemA: Item = Item("A", 40.00)
        checkout.scan(itemA)
        checkout.scan(itemA)
        assertThat(checkout.total()).isEqualTo(80.00)
    }

    @Test
    fun `getTotal - returns the total 100 for two items of B in basket on checkout`(){
        val itemB: Item = Item("B", 50.00)
        checkout.scan(itemB)
        checkout.scan(itemB)
        assertThat(checkout.total()).isEqualTo(100.00)
    }

    @Test
    fun `getTotal - returns the total cost for randomly scanned items on checkout`(){
        val itemA: Item = Item("A", 40.00)
        val itemB: Item = Item("B", 50.00)
        checkout.scan(itemA)
        checkout.scan(itemB)
        checkout.scan(itemB)
        assertThat(checkout.total()).isEqualTo(140.00)
    }

    @Test
    fun `getTotal - with special offer returns 100 for three items of A`(){
        val itemA: Item = Item("A", 40.00)
        checkout.scan(itemA)
        checkout.scan(itemA)
        checkout.scan(itemA)

        assertThat(checkout.total()).isEqualTo(100.00)
    }

}


