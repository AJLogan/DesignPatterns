package demos.scala.io

import scala.io.Source

object Program {
  def main(args: Array[String]) {
    val source = Source.fromFile("input.txt")
    for (line <- source.getLines()) {
      println(line)
    }
  }
}
