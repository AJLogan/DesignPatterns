package demos.scala.options.basic

object Program {
  def findProperty(name: String): Option[String] = {
    val result = System.getProperty(name)
    if (result eq null) None else Some(result)
  }

  def main(args: Array[String]) {
    println(findProperty("java.vendor") getOrElse "No Such Property!")
    println(findProperty("foobar") getOrElse "No Such Property!")
  }
}
