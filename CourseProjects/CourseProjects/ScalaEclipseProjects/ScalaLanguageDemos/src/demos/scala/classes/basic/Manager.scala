package demos.scala.classes.medium

class Manager(name : String,
              age : Int,
              salary : Double,
              val deptName : String,
              var budget : Double) extends Employee(name,age,salary) {
  println("Primary constructor of manager " + name)


  override def toString() = {
     super.toString + " managing " + deptName + " with budget " + budget
  }
  override def awardBonus(bonus : Double) {
    super.awardBonus(bonus * 2)
  }
  def raiseBudget(raise : Double) {
    budget += raise
  }
}