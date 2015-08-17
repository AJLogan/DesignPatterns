package demos.scala.collections.parallel

class Result (val value : String, val threadID : Long) {}

object Program {
  def main(args : Array[String]) {
    val originalData = List("ab", "cd", "ef", "gh", "ij", "kl")
    
    val newData1 = originalData.map((str) => new Result(str + "yy", Thread.currentThread.getId))

    val newData2 = originalData.par.map((str) => new Result(str + "zz", Thread.currentThread.getId))
    
    for( r <- newData1) {
      printf("%s from thread %d\n", r.value, r.threadID)
    }

    println("----------------------------")
    
    for( r <- newData2) {
      printf("%s from thread %d\n", r.value, r.threadID)
    }
  }
}
