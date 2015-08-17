package demos.scala.matching.literals

object Program {
  def main(args : Array[String]) {
    process("Flintstones")
    process("Simpsons")
    process("Foobar")
  }
  def process(str : String) { 
    str match {
      case "Flintstones" => println("Fred")
      case "Simpsons" => println("Homer")
      case _ => println("Dave")
    }
  }
}
