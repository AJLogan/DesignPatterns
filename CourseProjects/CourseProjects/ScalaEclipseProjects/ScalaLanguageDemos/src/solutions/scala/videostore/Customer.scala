package solutions.scala.videostore

class Customer(val name : String) {
  var rentals = List[Rental]()

  def addRental(arg : Rental) {
    rentals = arg :: rentals
  }

  def totalCost = {
    rentals.foldLeft(0.0)(_ + _.cost)
  }

  def totalPoints = {
    rentals.foldLeft(0)(_ + _.points)
  }

  def statement = {
    val result = new StringBuilder
    // add header lines
    result.append("\nRental Record for ")
    result.append(name)
    result.append("\n")
    for (rental <- rentals) {
      // show figures for this rental
      result.append("\t")
      result.append(rental.daysRented)
      result.append("\t")
      result.append(rental.movie.title)
      result.append("\t")
      result.append(rental.cost)
      result.append("\n")
    }
    // add footer lines
    result.append("Amount owed is ")
    result.append(totalCost)
    result.append("\n")
    result.append("You earned ")
    result.append(totalPoints)
    result.append(" frequent renter points\n")
    result.toString()
  }

}
