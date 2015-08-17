package demos.scala.classes.medium

class Employee(val name : String,
               val age : Int,
               var salary : Double) {
  println("Primary constructor of employee " + name)

  override def toString() = {
     name + " of age " + age + " earning " + salary
  }
  def awardBonus(bonus : Double) {
    salary += bonus
  }
}