package demos.scala.currying

object CurryingDemoThree {
  def joinUp(separator : Char)(data : Array[String]) = {
      val sb = new StringBuilder
      for(str <- data) {
        sb.append(str)
        sb.append(separator)
      }
      sb.substring(0,sb.length - 1)
  }

  def joinUpWithHashes = joinUp('#') _
  def joinUpWithHyphens = joinUp('-') _

  def main(args : Array[String]) {
      val testData = Array("abc","def","ghi","jkl","mno")
      println(joinUp(',')(testData))
      println(joinUpWithHashes(testData))
      println(joinUpWithHyphens(testData))
  }
}