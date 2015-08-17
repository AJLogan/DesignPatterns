package poker

import Suits._

object Card {
  val allRanks = List("A","Q","K","J","10","9","8","7","6","5","4","3","2","1")
  def buildCard(str: String) = {
    val tenCard = str.startsWith("10")
    val rank = if(tenCard) "10" else str.substring(0,1)
    val suitAsString = str.substring(if(tenCard) 2 else 1) 
    Card(rank, Suits.withName(suitAsString))
  }
}
case class Card(val rank : String, val suit : Suits.Value) {
  override def toString = {
    rank + suit.toString() + toSymbol
  }
  def toSymbol = {
    val all = Card.allRanks
    val rankValue = Integer.toHexString(all.length - all.indexOf(rank))
    val unicode = suit match {
	    case SPADES   => "1F0A" + rankValue
	    case HEARTS   => "1F0B" + rankValue
	    case DIAMONDS => "1F0C" + rankValue
	    case CLUBS    => "1F0D" + rankValue
	}
    Integer.parseInt(unicode,16).toChar
  }
}