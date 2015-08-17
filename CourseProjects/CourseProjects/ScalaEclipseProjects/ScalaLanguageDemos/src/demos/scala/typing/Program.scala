package demos.scala.typing

class MyClass

object Program {
  def main(args : Array[String]) {
    val myval1 = "ABC"
    val myval2 = "[a-z]{3}".r
    val myval3 = new MyClass
    val myval4 = new Array[MyClass](10)
    val myval5 = List("abc","def","ghi","jkl")
    val myval6 = (123,"abc")

    println(myval1.getClass.getName)
    println(myval2.getClass.getName)
    println(myval3.getClass.getName)
    println(myval4.getClass.getName)
    println(myval5.getClass.getName)
    println(myval6.getClass.getName)
  }
}