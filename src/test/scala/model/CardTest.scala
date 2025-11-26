package model

import munit.FunSuite
import model.joker.{EvenSteven, GreedyJoker, Joker, ScaryFace}
import model.rank.*
import model.suit.*

import scala.collection.mutable.ArrayBuffer

class CardTest extends FunSuite {

  val ace: Ace = new Ace()
  val two: Two = new Two()
  val four: Four = new Four()
  val jack: Jack = new Jack()
  val king: King = new King()

  val heart: Heart = new Heart()
  val diamond: Diamond = new Diamond()
  val club: Club = new Club()
  val spade: Spade = new Spade()

  val evenStevenJoker = new EvenSteven()
  val greedyJoker = new GreedyJoker()
  val scaryFaceJoker = new ScaryFace()

  var defaultCard: Card = _

  override def beforeEach(context: BeforeEach): Unit = {
    defaultCard = new Card(ace, heart)
  }

  test("Card should be initialized with the correct rank and suit") {
    val card = new Card(king, spade)
    assertEquals(card.getRank, king, "The initial rank should be King")
    assertEquals(card.getSuit, spade, "The initial suit should be Spade")
  }


  test("setRank should update the card's rank") {
    defaultCard.setRank(jack)
    assertEquals(defaultCard.getRank, jack, "Rank should be updated to Jack")
    assertEquals(defaultCard.getSuit, heart, "Suit should not change when rank is updated")
  }

  test("setSuit should update the card's suit") {
    defaultCard.setSuit(diamond)
    assertEquals(defaultCard.getSuit, diamond, "Suit should be updated to Diamond")
    assertEquals(defaultCard.getRank, ace, "Rank should not change when suit is updated")
  }



  test("toString should return a descriptive string representation") {
    val card = new Card(jack, club)
    assertEquals(card.toString, "Jack of Club")

    val anotherCard = new Card(two, heart)
    assertEquals(anotherCard.toString, "Two of Heart")
  }



  test("applyScore should not change the score if there are no jokers") {
    val initialScore = new Score(100, 10)
    val jokers = ArrayBuffer.empty[Joker]

    val finalScore = defaultCard.applyScore(initialScore, jokers)

    assertEquals(finalScore.getChips, initialScore.getChips)
    assertEquals(finalScore.getMultiplier, initialScore.getMultiplier)
  }

  test("applyScore should apply the effect from a matching rank-based joker") {
    val evenCard = new Card(four, heart) // Rank is even
    val initialScore = new Score(50, 2)
    val jokers = ArrayBuffer[Joker](evenStevenJoker)

    val finalScore = evenCard.applyScore(initialScore, jokers)

    assertEquals(finalScore.getChips, 50, "Chips should remain unchanged")
    assertEquals(finalScore.getMultiplier, 2 + 4, "Multiplier should increase by 4 for EvenSteven")
  }

  test("applyScore should apply the effect from a matching suit-based joker") {
    val diamondCard = new Card(king, diamond) // Suit is Diamond
    val initialScore = new Score(50, 2)
    val jokers = ArrayBuffer[Joker](greedyJoker)

    val finalScore = diamondCard.applyScore(initialScore, jokers)

    assertEquals(finalScore.getChips, 50, "Chips should remain unchanged")
    assertEquals(finalScore.getMultiplier, 2 + 3, "Multiplier should increase by 3 for GreedyJoker")
  }

  test("applyScore should NOT apply joker effects if the card does not match") {
    val oddNonDiamondCard = new Card(ace, spade) // Doesn't match any test joker
    val initialScore = new Score(10, 1)
    val jokers = ArrayBuffer[Joker](evenStevenJoker, greedyJoker, scaryFaceJoker)

    val finalScore = oddNonDiamondCard.applyScore(initialScore, jokers)

    assertEquals(finalScore.getChips, 10)
    assertEquals(finalScore.getMultiplier, 1)
  }

  test("applyScore should accumulate effects correctly from multiple matching jokers") {
    // This card is both a face card AND its suit is Diamond.
    val faceDiamondCard = new Card(king, diamond)
    val initialScore = new Score(100, 5)
    val jokers = ArrayBuffer[Joker](greedyJoker, scaryFaceJoker) // Should match both

    val finalScore = faceDiamondCard.applyScore(initialScore, jokers)

    val expectedChips = 100 + 30 // From ScaryFace
    val expectedMultiplier = 5 + 3   // From GreedyJoker

    assertEquals(finalScore.getChips, expectedChips, "Chips should increase from ScaryFace")
    assertEquals(finalScore.getMultiplier, expectedMultiplier, "Multiplier should increase from GreedyJoker")
  }
}