package demos.scala.pyramid

object PyramidTwo {
  def main(args : Array[String]) {
    println("Enter the height of the pyramid...")
    val heightString = readLine()
    val height = Integer.parseInt(heightString)

    (1 to height).foreach(i => println(buildRow(i, height)))
  }
  def buildRow(rowNum : Int, height : Int) = {
    val numSpaces = height - rowNum
    val numHashes = rowNum * 2 - 1

    (" " * numSpaces) + ("#" * numHashes)
  }
}