package demos.scala.imports

import java.lang.Math._                  //import all static methods
import java.util.regex._                 //import all accessible classes
import java.util.{LinkedList, HashMap}   //import selectively
import java.util.{Map => IMap}           //import with an alias

object Program {
   def main(args : Array[String]) {
    printf("The square root of 16 is %.1f\n", sqrt(16));
     
    val m = Pattern.compile("[A-Z]{3,5}").matcher("HELLO")
    if(m.matches()) {
      println("Patten matches data!")
    }
    
    val list = new LinkedList[String]()
    printf("A new list has size %d\n",list.size())
     
    var map : IMap[String, String] = null //note use of alias here
    map = new HashMap[String, String]()
    printf("A new map has size %d\n",map.size())
   }
}
