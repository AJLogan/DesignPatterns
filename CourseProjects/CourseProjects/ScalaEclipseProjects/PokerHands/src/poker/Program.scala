package poker

import Card._
import PokerHand._
import scala.io.Source

object Program {
  def main(args: Array[String]) {
    val hands = readHands("input/pokerHands.txt");
    nameAndPrintHands(hands)
  }
  def readHands(fileName: String) = {
    val linesInFile = Source.fromFile(fileName).getLines();
    linesInFile.map(buildHand(_)).toList
  }
  private def nameAndPrintHands(hands: List[PokerHand]) {
    for (hand <- hands) println(hand + " " + hand.name)
  }
}