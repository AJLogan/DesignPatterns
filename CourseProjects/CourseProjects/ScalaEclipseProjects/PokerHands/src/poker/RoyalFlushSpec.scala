package poker

import org.scalatest._

class RoyalFlushSpec extends FlatSpec with Matchers {
  "A royal flush " should "be recognised" in {
    val hand = PokerHand.buildHand("AS KS QS JS 10S")
    hand.isRoyalFlush should be (true)
  }
  it should "be recognised regardless of order" in {
    val cards = List("AS", "KS", "QS", "JS", "10S")
    for(cards <- cards.permutations.map(_.mkString(" "))) {
      val hand = PokerHand.buildHand(cards)
      hand.isRoyalFlush should be (true)
    }
  }
  it should "be recognised regardless of suit" in {
    val suits = List("H","S","C","D")
    val ranks = List("A", "K", "Q", "J", "10")
    
    for(suit <- suits) {
      val cards = ranks.map(_ + suit).mkString(" ")
      val hand = PokerHand.buildHand(cards)
      hand.isRoyalFlush should be (true)
    }
  }
}