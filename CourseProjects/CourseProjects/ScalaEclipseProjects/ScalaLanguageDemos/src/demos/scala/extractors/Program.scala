package demos.scala.extractors

class Address(val num: Int, val street: String, val postcode: String) {
}

object Address {
  def apply(num: Int, street: String, postcode: String): Address = {
    new Address(num, street, postcode)
  }

  def unapply(theAddress: String): Option[(Int, String, String)] = {
    val addressRegex = """([0-9]+) ("[a-zA-Z ]+") ([A-Z]{3}[0-9]{2} [A-Z]{3})""".r
    theAddress match {
      case addressRegex(m1, m2, m3) => Some(m1.toInt, m2, m3)
      case _ => None
    }
  }
}

object Program {
  def main(args: Array[String]) {
    val validAddress1 = "10 \"Arcatia Road\" ABC12 XYZ"
    val validAddress2 = "12 \"Arcatia Road\" ABC12 XYZ"
    val validAddress3 = "12 \"University Street\" FGT57 MNB"
    val validAddress4 = "16 \"University Street\" FGT57 MNB"
    val invalidAddress = "foobar"

    checkUnapplyWorks(validAddress1)
    checkUnapplyWorks(invalidAddress)
    println("-----------------")
    demoExtractorsOne(validAddress1)
    demoExtractorsOne(invalidAddress)
    println("-----------------")
    demoExtractorsTwo(validAddress1)
    demoExtractorsTwo(validAddress2)
    demoExtractorsTwo(validAddress3)
    demoExtractorsTwo(validAddress4)
    demoExtractorsTwo(invalidAddress)

  }

  def checkUnapplyWorks(data: String) {
    val result = Address.unapply(data)
    result match {
      case Some(t) => printf("Found address %d %s (%s)\n", t._1, t._2, t._3)
      case None => println(data + " is NOT a valid address")
    }
  }

  def demoExtractorsOne(data: String) {
    data match {
      case Address(a, b, c) => printf("Found address %d %s (%s)\n", a, b, c)
      case _ => println(data + " is NOT a valid address")
    }
  }

  def demoExtractorsTwo(data: String) {
    data match {
      case Address(a, "\"Arcatia Road\"", _) => printf("Found an Arcatia Road address (no %d)\n", a)
      case Address(12,a,_) => printf("Found a no 12 address on %s\n",a)
      case Address(a, b, c) => printf("Found address %d %s (%s)\n", a, b, c)
      case _ => println(data + " is NOT a valid address")
    }
  }
}
