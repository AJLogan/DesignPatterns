package demos.scala.numbers

class MyUtil(num : Int) {
  def triple() : Int = {
    num * 3
  }
}

object Program {
  implicit def bespokeConversion(x:Int) = new MyUtil(x)

  def main(args : Array[String]) {
    val myvar = 12
    val myrange = myvar.to(36,3)

    myrange.foreach(println _)

    val myvar2 = 123
    val retval = myvar2.triple()
    println(retval)
  }
}