package demos.scala.conversions.parameters

class Person(val name : String)

object MyDefaults {
  implicit val p = new Person("Dave")
}

object Program {
  def foo(param1 : Int)(implicit param2 : Person) {
    printf("Foo called with the number %d and person %s\n", param1, param2.name)
  }
  def bar() {
    import MyDefaults._
    foo(789)
  }

  def main(args : Array[String]) {
    //foo(123)("Mary")  //will not compile
    foo(456)(new Person("Liza"))
    bar()
  }
}
