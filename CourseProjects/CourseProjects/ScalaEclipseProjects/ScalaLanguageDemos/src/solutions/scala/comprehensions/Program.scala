package scala.solutions.comprehensions

class Employee(val name : String, val dept : String, val age : Int, val salary : Double)
class Department(val name : String,  val location : String)

object Program {
  def main(args: Array[String]) {
     val results = for(emp <- buildStaff;
                       dept <- buildDepartments
                       if emp.dept == dept.name) yield (emp.name, dept.location)
    
     for(t <- results) {
       println(t._1 + " works in " + t._2)
     }
  }

  def buildStaff() = {
    Array(
      new Employee("Dave", "IT", 21, 30500.0),
      new Employee("Jane", "HR", 22, 31000.0),
      new Employee("Fred", "IT", 23, 31500.0),
      new Employee("Mary", "HR", 24, 32000.0),
      new Employee("Peter", "IT", 25, 32500.0),
      new Employee("Lucy", "HR", 26, 33000.0),
      new Employee("Simon", "IT", 27, 33500.0),
      new Employee("Hazel", "HR", 28, 34000.0)
    )
  }
  def buildDepartments() = {
    Array(
      new Department("IT", "London"),
      new Department("HR", "Dublin"),
      new Department("Sales", "Belfast")
    )
  }
}
