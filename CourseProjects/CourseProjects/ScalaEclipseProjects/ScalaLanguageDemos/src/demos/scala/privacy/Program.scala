package demos.scala.privacy

class Point(var x : Int,  var y : Int) {
  private[this] var z : Int = 101

  def this(x : Int, y : Int, z : Int) {
    this(x,y)
    this.z = z
  }
  def swap(p : Point) {
    val tmpX = p.x
    val tmpY = p.y
    //val tmpZ = p.z //will not compile
    p.x = x
    p.y = y
    //p.z = z //will not compile
    x = tmpX
    y = tmpY
  }
  override def toString() = {
    "Point holding " + x + " , " + y + " , " + z
  }
}

object Program {
  def main(args : Array[String]) {
    val p1 = new Point(12,34)
    val p2 = new Point(56,78,90);
    
    p1.swap(p2)
    println(p1)
    println(p2)
  }
}
