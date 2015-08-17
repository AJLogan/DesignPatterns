package solutions.scala.roman.numerals

class Numeral(textValue: String, decimalValue : Int) {
   def apply(number : Int,  buffer : StringBuffer) = {
     val times = number / decimalValue
     if(times > 0) {
      (1 to times).foreach((i) => buffer.append(textValue))
      number % decimalValue
     } else {
      number
     }
   }
}

object Numeral {
  val numerals = Array(new Numeral("C",100),
                       new Numeral("XC",90),
                       new Numeral("L",50),
                       new Numeral("XL",40),
                       new Numeral("X",10),
                       new Numeral("IX",9),
                       new Numeral("V",5),
                       new Numeral("IV",4),
                       new Numeral("I",1))

  def convert(number : Int) = {
    var adjustedNumber = number
    val result = new StringBuffer
    for(numeral <- numerals) {
      adjustedNumber = numeral.apply(adjustedNumber, result)
    }
    result.toString()
  }
}
