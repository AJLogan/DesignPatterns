package demos.scala.classes.extra

class Manager(_name: String,
              _age: Int,
              _salary: Double,
              val deptName: String,
              var budget: Double) extends Employee(_name, _age, _salary) {
  println("Primary constructor of manager " + name)


  override def toString() = {
    super.toString + " managing " + deptName + " with budget " + budget
  }

  override def awardBonus(bonus: Double) {
    salary += bonus * 2
  }

  def raiseBudget(raise: Double) {
    budget += raise
  }
}