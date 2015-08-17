package demos.scala.matching.objects

object MovieType extends Enumeration {
  val VIDEO = Value("Video")
  val DVD = Value("DVD")
  val BLUE_RAY = Value("BLUE_RAY")
}

abstract class StockItem

case class Book(isbn: String, category: String) extends StockItem
case class Movie(title: String, format: MovieType.Value) extends StockItem
case class CD(name: String, artist: String, numTracks: Int) extends StockItem

object Program {
  def main(args : Array[String]) {
    val b1 = new Book("ABC123","SciFi")
    val b2 = new Book("DEF456","Crime")
    val m1 = new Movie("Star Wars",MovieType.DVD)
    val m2 = new Movie("Pulp Fiction",MovieType.BLUE_RAY)
    val cd = new CD("Superunknown","Soundgarden",12)

    processItem(b1)
    processItem(b2)
    processItem(m1)
    processItem(m2)
    processItem(cd)
  }
  def processItem(item : StockItem) {
    item match {
      case Book(_,"Crime") => println("Found a crime novel")
      case Movie(_,MovieType.DVD) => println("Found a DVD movie")
      case CD(_,_,12) => println("Found a CD with 12 tracks")
      case CD(_,"Soundgarden",_) => println("Found a CD by Soundgarden")
      case Book(_,_) => println("Found some kind of book")
      case _ => println("Found something...")
    }
  }
}