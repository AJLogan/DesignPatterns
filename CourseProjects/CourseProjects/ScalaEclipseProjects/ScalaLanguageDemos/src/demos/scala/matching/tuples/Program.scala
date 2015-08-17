package demos.scala.matching.tuples


object Program {
  def main(args: Array[String]) {
    val t1 = (12,13)
    val t2 = ("abc", 14)
    val t3 = ("def", 15, true)

    process(t1)
    process(t2)
    process(t3)
  }

  def process(theTuple: Any) {
    theTuple match {
      case (a : Int,  b: Int) => println("A two int tuple holding " + a + "," + b)
      case (a : Int,  b: String) => println("An int/string tuple holding " + a + "," + b)
      case (a : String,  b: Int) => println("A string/int tuple holding " + a + "," + b)
      case (a,b,c) => println("A three value tuple holding " + a + "," + b + "," + c)
      case _ => println("Received an unknown value")
    }
  }
}
