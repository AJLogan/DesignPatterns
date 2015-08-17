package solutions.scala.videostore

class Rental (val movie : Movie,  val daysRented : Int) {
  def cost() = {
    movie.cost(daysRented);
  }
  def points() = {
    movie.points(daysRented);
  }
}
