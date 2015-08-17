package demos.scala.predef

object Program {
   def main(args : Array[String]) {
     try {
       println("Enter an integer")
       val num1 = readInt()
       printf("Thanks for %d - enter another\n", num1)
       val num2 = readInt()
       printf("%d plus %d is %d\n", num1, num2, num1 + num2)
     } catch {
       case ex : NumberFormatException => println("That wasnt a number!")
     }
   }
}
