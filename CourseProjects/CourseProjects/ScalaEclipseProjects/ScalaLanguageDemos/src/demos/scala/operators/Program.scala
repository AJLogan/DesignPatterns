package demos.scala.operators

class Point(var no1 : Int, var no2 : Int) {
  def +(other : Point) : Point = {
    return new Point(no1 + other.no1, no2 + other.no2)
  }
  def -(other : Point) : Point = {
    return new Point(no1 - other.no1, no2 - other.no2)
  }
  //def €() {
  //  println("Just to prove the point...")
  //}
  override def toString() : String = {
    "%d %d".format(no1,no2)
  }
}

object Program {
  def main(args : Array[String]) {
    val p1 = new Point(10,20)
    val p2 = new Point(5,7)

    val p3 = p1 + p2
    println(p3)

    val p4 = p1 - p2
    println(p4)

    //p4.€
  }
}