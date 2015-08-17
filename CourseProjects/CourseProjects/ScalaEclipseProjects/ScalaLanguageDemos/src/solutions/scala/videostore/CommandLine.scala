package solutions.scala.videostore

import PriceCode._

object CommandLine {
  def main(args: Array[String]) {
    val peterPan = new Movie("Peter Pan", CHILDRENS)
    val theHulk = new Movie("The Hulk", REGULAR)
    val starWars = new Movie("Star Wars", REGULAR)
    val toyStory = new Movie("Toy Story", CHILDRENS)
    val killBill = new Movie("Kill Bill", NEW_RELEASE)

    val r1 = new Rental(peterPan, 2)
    val r2 = new Rental(theHulk, 1)
    val r3 = new Rental(starWars, 3)
    val r4 = new Rental(toyStory, 2)
    val r5 = new Rental(killBill, 4)

    val customer = new Customer("Joe Bloggs")
    customer.addRental(r1)
    customer.addRental(r2)
    customer.addRental(r3)
    customer.addRental(r4)
    customer.addRental(r5)

    println(customer.statement)
  }
}
