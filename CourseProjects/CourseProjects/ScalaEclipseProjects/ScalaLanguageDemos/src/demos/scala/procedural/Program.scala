package demos.scala.procedural


object Program {
   def main(args : Array[String]) {
     showConditionals()
     println("-----------------")
     showIteration()
   }
   def showConditionals() {
     val number = Math.random
     var choice1 = ""
     if(number < 0.5) {
       choice1 = "ABC"
     } else {
       choice1 = "DEF"
     }
     val choice2 = if (number < 0.5) "ABC" else "DEF"
     println(choice1)
     println(choice2)
   }
   def showIteration() {
     for(x <- 1 to 5) {
       println(x)
     }
     println("----")
     for(x <- 6.to(10)) {
       println(x)
     }
     println("----")
     var count = 11
     while(count <= 15) {
       println(count)
       count+=1
     }
     println("----")
     do {
       println(count)
       count+=1
     } while(count <= 20)
   }
}
