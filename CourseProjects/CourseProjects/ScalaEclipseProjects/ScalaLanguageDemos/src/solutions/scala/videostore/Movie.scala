package solutions.scala.videostore

import PriceCode._

class Movie(val title: String, val pricecode: PriceCode.Value) {
  def cost(daysRented: Int) = {
    var cost = 0.0
    pricecode match {
      case REGULAR => {
        cost += 2
        if (daysRented > 2)
          cost += (daysRented - 2) * 1.5
      }
      case NEW_RELEASE => cost += daysRented * 3
      case CHILDRENS => {
        cost += 1.5
        if (daysRented > 3)
          cost += (daysRented - 3) * 1.5
      }
    }
    cost
  }

  def points(daysRented: Int) = {
    var frequentRenterPoints = 1
    // add bonus for a two day new release rental
    if ((pricecode == NEW_RELEASE) && daysRented > 1) {
      frequentRenterPoints += 1
    }
    frequentRenterPoints
  }
}
