package poker

import Card._
import Suits._

object PokerHand {
    def buildHand(line: String) = new PokerHand(line.split(" ").map(buildCard(_)))
}
class PokerHand(hand: Array[Card]) {
  def name = {
    if (isRoyalFlush)         "Royal Flush"
    else if(isStraightFlush)  "Straight Flush"
    else if(isFourOfAKind)    "Four Of A Kind"
    else if(isFullHouse)      "Full House"
    else if(isFlush)          "Flush"  
    else if(isStraight)       "Straight"
    else if(isThreeOfAKind)   "Three Of A Kind"
    else if(isTwoPair)        "Two Pair"
    else if(isPair)           "Pair"
    else                      "You Go Hungry"
  }
  override def toString = hand.foldLeft("")(_ + " " + _)
  
  def nOf(count: Int)(rank : String) = hand.count(_.rank == rank) == count
  def twoOf(rank : String)   = nOf(2)(rank)
  def threeOf(rank : String) = nOf(3)(rank)
  def fourOf(rank : String)  = nOf(4)(rank)
  
  def allOfSameSuit = hand.forall(_.suit == hand(0).suit)
  def allCardsHigh =  Array("A","Q","K","J","10").forall(r => hand.exists(_.rank == r))
  def ranksInDescendingOrder = hand.map(_.rank).sortWith(allRanks.indexOf(_) < allRanks.indexOf(_));
  
  def isFlush         = allOfSameSuit
  def isRoyalFlush    = allOfSameSuit && allCardsHigh
  def isStraightFlush = isStraight && allOfSameSuit
  def isFourOfAKind   = allRanks.exists(fourOf(_))  //(x) => fourOf(x)
  def isThreeOfAKind  = allRanks.exists(threeOf(_))
  def isTwoPair       = allRanks.combinations(2).exists(pair => twoOf(pair(0)) && twoOf(pair(1)))
  def isPair          = allRanks.exists(twoOf(_))
  def isStraight      = allRanks.containsSlice(ranksInDescendingOrder);
  def isFullHouse = {
      def twoOfThenThreeOf(pair : List[String]) = twoOf(pair(0)) && threeOf(pair(1))
      def threeOfThenTwoOf(pair : List[String]) = threeOf(pair(0)) && twoOf(pair(1))
      
      allRanks.combinations(2).exists(pair => twoOfThenThreeOf(pair) || threeOfThenTwoOf(pair))		  							      
  }
}