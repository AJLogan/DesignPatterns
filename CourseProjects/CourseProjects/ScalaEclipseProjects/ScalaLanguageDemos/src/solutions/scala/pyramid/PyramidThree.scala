package demos.scala.pyramid

object PyramidThree  {
  def pyramidRow(rowNum: Int, height: Int) = {
      val numSpaces = height - rowNum
      val numHashes = rowNum * 2 - 1

      (" " * numSpaces) + ("#" * numHashes)
  }
  def squareRow(rowNum: Int, height: Int) = {
      if (rowNum == 1 || rowNum == height) {
        "########"
      } else {
        "#      #"
      }
  }
  def main(args : Array[String]) {
    println("Enter the height for the shapes...")
    val heightString = readLine()
    val height = Integer.parseInt(heightString)

    printShape(height, pyramidRow)
    println()
    printShape(height, squareRow)
  }
  def printShape(height : Int, func : (Int, Int) => String ) {
    for(rowNum <- 1 to height) {
        println(func(rowNum,height))
    }
  }
}