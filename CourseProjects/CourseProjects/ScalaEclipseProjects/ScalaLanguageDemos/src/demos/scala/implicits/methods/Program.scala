package demos.scala.conversions.methods

class A {
  def foo() {
    println("FOO")
  }

  def bar() {
    println("BAR")
  }
}

class B(obj: A) {
  println("Instance of B created...")

  def zed() {
    println("ZED")
  }
}

object Program {
  implicit def convertAtoB(obj: A) = new B(obj)

  def main(args: Array[String]) {
    val tst = new A()
    tst.foo()
    tst.bar()
    tst.zed()
  }
}