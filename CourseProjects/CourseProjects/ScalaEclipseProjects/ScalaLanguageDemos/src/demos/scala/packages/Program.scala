package demos.scala.packages {

  package foo {
      class MyClass {
        private[foo] var field1 = "ABC"
        private[packages] var field2 = "DEF"
        protected[foo] var field3 = "GHI"
        protected[packages] var field4 = "JKL"
      }

      class Other {
        def func() {
          val mc = new MyClass()
          val myvar1 = mc.field1 //Note this compiles
          val myvar2 = mc.field2
          val myvar3 = mc.field3
          val myvar4 = mc.field4
        }
      }
    }
  }
  package bar {

    import demos.scala.packages.foo.MyClass

    class MyDerivedB extends MyClass {
      def func() {
        //val myvar1 = field1 //Will not compile
        //val myvar2 = field2
        val myvar3 = field3
        val myvar4 = field4
      }
    }
  }
  class MyDerivedA extends demos.scala.packages.foo.MyClass {
    def func() {
      //val myvar1 = field1 //will not compile
      //val myvar2 = field2 //will not compile
      val myvar3 = field3
      val myvar4 = field4
    }
  }
  object Program {
    def main(args: Array[String]) {
      val mc = new demos.scala.packages.foo.MyClass();
      //println(mc.field1); //will not compile
      //println(mc.field2); //will not compile
      //println(mc.field3); //will not compile
      //println(mc.field4); //will not compile
    }
  }
