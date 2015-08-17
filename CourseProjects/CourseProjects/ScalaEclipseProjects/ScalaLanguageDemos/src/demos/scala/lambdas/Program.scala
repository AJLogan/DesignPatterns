package demos.scala.lambdas

object Program {
  def main(args : Array[String]) {
    println("---Demo 1---")
    val limit = 6
    (1.to(limit)).foreach(num => printf("%d ", num))
    println
    (1 to limit).foreach(printf("%d ", _))

    println("\n\n---Demo 2 ---")
    val data = List(10,11,12,13,14,15)
    val result1 = data.foldLeft(1000)((a,b) => a + b)
    val result2 = data.foldLeft(2000)(_ +  _)
    println(result1)
    println(result2)

    println("\n---Demo 3 ---")
    val text = "abc123def456ghi789"
    val newText = "[a-z]{3}".r.replaceAllIn(text, _.group(0).toUpperCase())
    println(newText)
  }
}