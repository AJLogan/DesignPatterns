package poker

import org.scalacheck.Prop._
import org.scalacheck.Gen
import org.scalacheck.Test
import org.scalacheck.Test.Parameters
import org.scalatest.FunSuite

class TestPokerHand extends FunSuite {

    val rankGen = Gen.oneOf(List("A", "Q", "K", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"))
    val suitGen = Gen.oneOf(List("C", "H", "S", "D"))
    val cardGen = for {
        rank <- rankGen;
        suit <- suitGen
    } yield rank + suit

    val handGen = Gen.listOfN(5, cardGen).
        filter(x => x.distinct.size == 5).
        flatMap(cs => PokerHand.buildHand(cs.mkString(" ")))

    val params = Parameters.default.withMinSuccessfulTests(20000) // 'dealing' the default of 100 hands isn't enough to get occurrences of rarer hands 

    
    test("hand types exist") {
        val props = List(
            exists(handGen)(_.isPair),
            exists(handGen)(_.isTwoPair),
            exists(handGen)(_.isThreeOfAKind),
            exists(handGen)(_.isStraight),
            exists(handGen)(_.isFlush),
            exists(handGen)(_.isFullHouse),
            exists(handGen)(_.isFourOfAKind))

        props.foreach(prop => {
            val res = Test.check(params, prop)
            assert(res.passed)
        })
    }

    test("all 2 Pairs Are Pairs") {
        val prop = forAll(handGen)((h: PokerHand) => if (h.isTwoPair) h.isPair else true) // might be better to use filter on the generator to leave only 2-pair hands? 
        assert(Test.check(params, prop).passed)
    }

    test("all FH Are Pairs") {
        val prop = forAll(handGen)((h: PokerHand) => if (h.isFullHouse) (h.isPair && h.isThreeOfAKind) else true)
        assert(Test.check(params, prop).passed)
    }

    test("all 3s Are Pairs") {
        val prop = forAll(handGen)((h: PokerHand) => if (h.isThreeOfAKind) h.isPair else true)
        
        prop.check // prints to console
        
        assert(Test.check(params, prop).passed)
    }

}



