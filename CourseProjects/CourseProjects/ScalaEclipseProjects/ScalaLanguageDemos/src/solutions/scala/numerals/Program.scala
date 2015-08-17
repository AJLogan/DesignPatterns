package solutions.scala.roman.numerals

object Program {
  def main(args : Array[String]) {
    println("Enter the number to convert...")
    val numberAsString = readLine()
    val number = Integer.parseInt(numberAsString)
    
    val result = Numeral.convert(number);
    println("Your number as a roman numeral is: " + result)
  }
}
