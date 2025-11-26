package model

import munit.FunSuite
import scala.collection.mutable.ArrayBuffer
import model.rank._
import model.suit._
import model.joker.{DeviousJoker, EvenSteven, GreedyJoker, ScaryFace, Joker}

class HandTest extends FunSuite {
  val deviousJoker = new DeviousJoker()
  val evenStevenJoker = new EvenSteven()
  val greedyJoker = new GreedyJoker()
  val scaryFaceJoker = new ScaryFace()
  val ace: Ace = new Ace()
  val two: Two = new Two()
  val three: Three = new Three()
  val four: Four = new Four()
  val five: Five = new Five()
  val six: Six = new Six()
  val seven: Seven = new Seven()
  val eight: Eight = new Eight()
  val nine: Nine = new Nine()
  val ten: Ten = new Ten()
  val jack: Jack = new Jack()
  val queen: Queen = new Queen()
  val king: King = new King()

  val heart: Heart = new Heart()
  val diamond: Diamond = new Diamond()
  val club: Club = new Club()
  val spade: Spade = new Spade()

  var aceHeart: Card = _
  var aceDiamond: Card = _
  var aceClub: Card = _
  var aceSpade: Card = _

  var twoHeart: Card = _
  var twoDiamond: Card = _
  var twoClub: Card = _
  var twoSpade: Card = _

  var threeHeart: Card = _
  var threeDiamond: Card = _
  var threeClub: Card = _
  var threeSpade: Card = _

  var fourHeart: Card = _
  var fourDiamond: Card = _
  var fourClub: Card = _
  var fourSpade: Card = _

  var fiveHeart: Card = _
  var fiveDiamond: Card = _
  var fiveClub: Card = _
  var fiveSpade: Card = _

  var sixHeart: Card = _
  var sixDiamond: Card = _
  var sixClub: Card = _
  var sixSpade: Card = _

  var sevenHeart: Card = _
  var sevenDiamond: Card = _
  var sevenClub: Card = _
  var sevenSpade: Card = _

  var eightHeart: Card = _
  var eightDiamond: Card = _
  var eightClub: Card = _
  var eightSpade: Card = _

  var nineHeart: Card = _
  var nineDiamond: Card = _
  var nineClub: Card = _
  var nineSpade: Card = _

  var tenHeart: Card = _
  var tenDiamond: Card = _
  var tenClub: Card = _
  var tenSpade: Card = _

  var jackHeart: Card = _
  var jackDiamond: Card = _
  var jackClub: Card = _
  var jackSpade: Card = _

  var queenHeart: Card = _
  var queenDiamond: Card = _
  var queenClub: Card = _
  var queenSpade: Card = _

  var kingHeart: Card = _
  var kingDiamond: Card = _
  var kingClub: Card = _
  var kingSpade: Card = _


  var hand: Hand = _


  override def beforeEach(context: BeforeEach): Unit = {
    var aceHeart: Card = new Card(ace, heart)
    var aceDiamond: Card = new Card(ace, diamond)
    var aceClub: Card = new Card(ace, club)
    var aceSpade: Card = new Card(ace, spade)

    var twoHeart: Card = new Card(two, heart)
    var twoDiamond: Card = new Card(two, diamond)
    var twoClub: Card = new Card(two, club)
    var twoSpade: Card = new Card(two, spade)

    var threeHeart: Card = new Card(three, heart)
    var threeDiamond: Card = new Card(three, diamond)
    var threeClub: Card = new Card(three, club)
    var threeSpade: Card = new Card(three, spade)

    var fourHeart: Card = new Card(four, heart)
    var fourDiamond: Card = new Card(four, diamond)
    var fourClub: Card = new Card(four, club)
    var fourSpade: Card = new Card(four, spade)

    var fiveHeart: Card = new Card(five, heart)
    var fiveDiamond: Card = new Card(five, diamond)
    var fiveClub: Card = new Card(five, club)
    var fiveSpade: Card = new Card(five, spade)

    var sixHeart: Card = new Card(six, heart)
    var sixDiamond: Card = new Card(six, diamond)
    var sixClub: Card = new Card(six, club)
    var sixSpade: Card = new Card(six, spade)

    var sevenHeart: Card = new Card(seven, heart)
    var sevenDiamond: Card = new Card(seven, diamond)
    var sevenClub: Card = new Card(seven, club)
    var sevenSpade: Card = new Card(seven, spade)

    var eightHeart: Card = new Card(eight, heart)
    var eightDiamond: Card = new Card(eight, diamond)
    var eightClub: Card = new Card(eight, club)
    var eightSpade: Card = new Card(eight, spade)

    var nineHeart: Card = new Card(nine, heart)
    var nineDiamond: Card = new Card(nine, diamond)
    var nineClub: Card = new Card(nine, club)
    var nineSpade: Card = new Card(nine, spade)

    var tenHeart: Card = new Card(ten, heart)
    var tenDiamond: Card = new Card(ten, diamond)
    var tenClub: Card = new Card(ten, club)
    var tenSpade: Card = new Card(ten, spade)

    var jackHeart: Card = new Card(jack, heart)
    var jackDiamond: Card = new Card(jack, diamond)
    var jackClub: Card = new Card(jack, club)
    var jackSpade: Card = new Card(jack, spade)

    var queenHeart: Card = new Card(queen, heart)
    var queenDiamond: Card = new Card(queen, diamond)
    var queenClub: Card = new Card(queen, club)
    var queenSpade: Card = new Card(queen, spade)

    var kingHeart: Card = new Card(king, heart)
    var kingDiamond: Card = new Card(king, diamond)
    var kingClub: Card = new Card(king, club)
    var kingSpade: Card = new Card(king, spade)

    // Jokers
    val deviousJoker: DeviousJoker = new DeviousJoker()
    val evenStevenJoker: EvenSteven = new EvenSteven()
    val greedyJoker: GreedyJoker = new GreedyJoker()
    val scaryFaceJoker: ScaryFace = new ScaryFace()


    hand = new Hand(ArrayBuffer[Card](), ArrayBuffer[Joker]())


  }

  test("Hand should add a single card") {
    hand.addCard(aceHeart)
    assertEquals(hand._cards.size, 1)
    assertEquals(hand._cards.head, aceHeart)

    hand.addCard(kingDiamond)
    assertEquals(hand._cards.size, 2)
    assert(hand._cards.contains(kingDiamond))
  }

  test("Hand should remove a card by index") {
    hand = new Hand(ArrayBuffer(aceHeart, kingDiamond, queenClub, jackSpade, tenHeart), ArrayBuffer[Joker]())


    val removedCard = hand.removeCardByIndex(1)
    assertEquals(removedCard, kingDiamond)
    assertEquals(hand._cards.size, 4)
    assertEquals(hand._cards, ArrayBuffer(aceHeart, queenClub, jackSpade, tenHeart))


    val removedFirstCard = hand.removeCardByIndex(0)
    assertEquals(removedFirstCard, aceHeart)
    assertEquals(hand._cards.size, 3)
    assertEquals(hand._cards, ArrayBuffer(queenClub, jackSpade, tenHeart))


    val removedLastCard = hand.removeCardByIndex(2)
    assertEquals(removedLastCard, tenHeart)
    assertEquals(hand._cards.size, 2)
    assertEquals(hand._cards, ArrayBuffer(queenClub, jackSpade))
  }

  test("Hand should add a joker") {
    hand.addJoker(deviousJoker)
    assertEquals(hand._jokers.size, 1)
    assertEquals(hand._jokers.head, deviousJoker)

    hand.addJoker(evenStevenJoker)
    assertEquals(hand._jokers.size, 2)
    assert(hand._jokers.contains(evenStevenJoker))
  }

  test("Hand should remove a joker by index") {
    hand = new Hand(ArrayBuffer[Card](), ArrayBuffer(deviousJoker, evenStevenJoker, greedyJoker, scaryFaceJoker))

    val removedFirstJoker = hand.removeJokerByIndex(0)
    assertEquals(removedFirstJoker, deviousJoker)
    assertEquals(hand._jokers.size, 3)
    assert(!hand._jokers.contains(deviousJoker))

    val removedLastJoker = hand.removeJokerByIndex(2)
    assertEquals(removedLastJoker, scaryFaceJoker)
    assertEquals(hand._jokers.size, 2)
    assert(!hand._jokers.contains(scaryFaceJoker))
  }

  test("Hand should play cards by removing cards at specified indices") {

    hand = new Hand(ArrayBuffer(aceHeart, kingDiamond, queenClub, jackSpade, tenHeart, nineClub, eightDiamond, sevenSpade), ArrayBuffer[Joker]())

    val playedCards1 = hand.playHand(ArrayBuffer(1, 3))
    assertEquals(playedCards1.size, 2)
    assert(playedCards1.contains(kingDiamond))
    assert(playedCards1.contains(jackSpade))
    assertEquals(hand._cards.size, 6)

    // Para pruebas adicionales, reutiliza el mismo patrón de configuración
    val playedCards2 = hand.playHand(ArrayBuffer(0, 4))
    assertEquals(playedCards2.size, 2)
    assert(playedCards2.contains(aceHeart))
    assert(playedCards2.contains(sevenSpade))
    assertEquals(hand._cards.size, 4)
  }

  test("Hand should play cards with various index scenarios") {
    hand = new Hand(ArrayBuffer(aceHeart, kingDiamond, queenClub, jackSpade, tenHeart, nineClub, eightDiamond, sevenSpade), ArrayBuffer[Joker]())

    // Play cards in non-consecutive order
    val playedCards1 = hand.playHand(ArrayBuffer(0, 2, 5))
    assertEquals(playedCards1.size, 3)
    assert(playedCards1.contains(aceHeart))
    assert(playedCards1.contains(queenClub))
    assert(playedCards1.contains(nineClub))
    assertEquals(hand._cards.size, 5)

    // Play a single card
    hand = new Hand(ArrayBuffer(aceHeart, kingDiamond, queenClub, jackSpade, tenHeart, nineClub, eightDiamond, sevenSpade), ArrayBuffer[Joker]())
    val playedCards2 = hand.playHand(ArrayBuffer(3))
    assertEquals(playedCards2.size, 1)
    assert(playedCards2.contains(jackSpade))
    assertEquals(hand._cards.size, 7)

    // Play 5 cards in a specific order
    hand = new Hand(ArrayBuffer(aceHeart, kingDiamond, queenClub, jackSpade, tenHeart, nineClub, eightDiamond, sevenSpade), ArrayBuffer[Joker]())
    val playedCards3 = hand.playHand(ArrayBuffer(0, 1, 2, 3, 4))
    assertEquals(playedCards3.size, 5)
    assertEquals(hand._cards.size, 3)
  }



  test("Hand should maintain correct card order after playing") {
    hand = new Hand(ArrayBuffer(aceHeart, kingDiamond, queenClub, jackSpade, tenHeart), ArrayBuffer[Joker]())

    val playedCards = hand.playHand(ArrayBuffer(1, 3))

    // Verify the remaining cards are in the correct order
    assertEquals(hand._cards, ArrayBuffer(aceHeart, queenClub, tenHeart))
  }

  test("applyScore should correctly apply EvenSteven Joker effect for an even-ranked card") {
    twoHeart = new Card(two, heart)
    val scoreInicial = new Score(10, 2)
    val jokers: ArrayBuffer[Joker] = ArrayBuffer(evenStevenJoker)

    val scoreFinal = twoHeart.applyScore(scoreInicial, jokers)

    assertEquals(scoreFinal.getChips, 10, "Chips should not be modified by EvenSteven")
    assertEquals(scoreFinal.getMultiplier, 2 + 4, "Multiplier should increase by 4 for an even card")
  }

  test("EvenSteven Joker: should NOT change score for an odd-ranked card") {

    val card = new Card(three, heart)
    val scoreInicial = new Score(10, 5)
    val jokers: ArrayBuffer[Joker] = ArrayBuffer(evenStevenJoker)


    val scoreFinal = card.applyScore(scoreInicial, jokers)

    assertEquals(scoreFinal, scoreInicial, "Score should not change for a non-matching card.")
  }

  test("Greedy Joker: should increase multiplier by 3 for a Diamond card") {

    val card = new Card(king, diamond) // Palo Diamante
    val scoreInicial = new Score(50, 1)
    val jokers: ArrayBuffer[Joker] = ArrayBuffer(greedyJoker)


    val scoreFinal = card.applyScore(scoreInicial, jokers)


    assertEquals(scoreFinal.getChips, 50, "Chips should remain unchanged.")
    assertEquals(scoreFinal.getMultiplier, 1 + 3, "Multiplier should increase by 3.")
  }

  test("Greedy Joker: should NOT change score for a non-Diamond card") {
    val card = new Card(king, heart)
    val scoreInicial = new Score(50, 1)
    val jokers: ArrayBuffer[Joker] = ArrayBuffer(greedyJoker)

    // Act
    val scoreFinal = card.applyScore(scoreInicial, jokers)

    // Assert
    assertEquals(scoreFinal, scoreInicial, "Score should not change for a non-matching suit.")
  }

  test("ScaryFace Joker: should increase chips by 30 for a face card") {
    val card = new Card(king, heart)
    val scoreInicial = new Score(100, 10)
    val jokers: ArrayBuffer[Joker] = ArrayBuffer(scaryFaceJoker)

    val scoreFinal = card.applyScore(scoreInicial, jokers)

    assertEquals(scoreFinal.getChips, 100 + 30, "Chips should increase by 30.")
    assertEquals(scoreFinal.getMultiplier, 10, "Multiplier should remain unchanged.")
  }
  test("ScaryFace Joker: should NOT change score for a non-face card") {
    val card = new Card(two, heart)
    val scoreInicial = new Score(100, 10)
    val jokers: ArrayBuffer[Joker] = ArrayBuffer(scaryFaceJoker)

    val scoreFinal = card.applyScore(scoreInicial, jokers)

    assertEquals(scoreFinal, scoreInicial, "Score should not change for a non-face card.")
  }



  test("getCards should return the current cards") {
    val cards = ArrayBuffer(new Card(ace, heart), new Card(king, spade))
    hand = new Hand(cards, ArrayBuffer.empty[Joker])
    assertEquals(hand.getCards, cards)
  }

  test("setCards should update the hand's cards") {
    val newCards = ArrayBuffer(new Card(ten, club), new Card(nine, diamond))
    hand.setCards(newCards)
    assertEquals(hand.getCards, newCards)
  }

  test("setCards should throw MaxCardsExceededException") {
    val tooManyCards = ArrayBuffer.fill(9)(new Card(ace, heart))
    intercept[exceptions.MaxCardsExceededException] {
      hand.setCards(tooManyCards)
    }
  }

  test("getJokers should return the current jokers") {
    val jokers: ArrayBuffer[Joker] = ArrayBuffer(greedyJoker)
    hand = new Hand(ArrayBuffer.empty[Card], jokers)
    assertEquals(hand.getJokers, jokers)
  }

  test("setJokers should update the hand's jokers") {
    val newJokers: ArrayBuffer[Joker] = ArrayBuffer(scaryFaceJoker)
    hand.setJokers(newJokers)
    assertEquals(hand.getJokers, newJokers)
  }

  test("setJokers should throw MaxJokersExceededException") {
    val tooManyJokers: ArrayBuffer[Joker] = ArrayBuffer(greedyJoker, scaryFaceJoker, deviousJoker)
    intercept[exceptions.MaxJokersExceededException] {
      hand.setJokers(tooManyJokers)
    }
  }



  test("playHand should throw MaxPlaysExceededException on fourth play") {
    hand = new Hand(ArrayBuffer.fill(8)(new Card(ace, heart)), ArrayBuffer.empty[Joker])
    hand.playHand(ArrayBuffer(0)) // 1st play
    hand.playHand(ArrayBuffer(0)) // 2nd play
    hand.playHand(ArrayBuffer(0)) // 3rd play
    intercept[exceptions.MaxPlaysExceededException] {
      hand.playHand(ArrayBuffer(0)) // 4th play should fail
    }
  }

  test("playHand should throw InvalidPlayCountException for 0 cards") {
    hand = new Hand(ArrayBuffer(new Card(ace, heart)), ArrayBuffer.empty[Joker])
    intercept[exceptions.InvalidPlayCountException] {
      hand.playHand(ArrayBuffer.empty[Int])
    }
  }

  test("playHand should throw InvalidPlayCountException for more than 5 cards") {
    hand = new Hand(ArrayBuffer.fill(6)(new Card(ace, heart)), ArrayBuffer.empty[Joker])
    intercept[exceptions.InvalidPlayCountException] {
      hand.playHand(ArrayBuffer(0, 1, 2, 3, 4, 5))
    }
  }

  test("playHand should throw InvalidIndexesForPlayException for out-of-bounds index") {
    hand = new Hand(ArrayBuffer(new Card(ace, heart)), ArrayBuffer.empty[Joker])
    intercept[exceptions.InvalidIndexesForPlayException] {
      hand.playHand(ArrayBuffer(5)) // Index 5 is out of bounds for a 1-card hand
    }
  }



  test("applyScoreHand should calculate score for a simple Pair without jokers") {
    val playedCards = ArrayBuffer(new Card(ace, heart), new Card(ace, spade))
    val score = hand.applyScoreHand(playedCards)

    assertEquals(score.getChips, 32)
    assertEquals(score.getMultiplier, 2)
  }

  test("applyScoreHand should calculate score for a High Card with a matching joker") {
    val playedCards = ArrayBuffer(new Card(king, heart))
    hand.setJokers(ArrayBuffer(scaryFaceJoker))
    val score = hand.applyScoreHand(playedCards)

    assertEquals(score.getChips, 45)
    assertEquals(score.getMultiplier, 1)
  }

  test("applyScoreHand should calculate score for a Pair with card-enhancing jokers") {
    val playedCards = ArrayBuffer(new Card(two, club), new Card(two, spade))
    hand.setJokers(ArrayBuffer(evenStevenJoker))
    val score = hand.applyScoreHand(playedCards)

    assertEquals(score.getChips, 14)
    assertEquals(score.getMultiplier, 10)
  }

  test("applyScoreHand should calculate score for a Flush with combo and card jokers") {
    val playedCards = ArrayBuffer(
      new Card(two, diamond), new Card(three, diamond), new Card(four, diamond),
      new Card(five, diamond), new Card(six, diamond)
    )
    hand.setJokers(ArrayBuffer(deviousJoker, greedyJoker))
    val score = hand.applyScoreHand(playedCards)

    assertEquals(score.getChips,120)
    assertEquals(score.getMultiplier,23)
  }


  test("addCard should throw MaxCardsExceededException when hand is full") {
    val fullHand = ArrayBuffer.fill(8)(new Card(ace, heart))
    hand = new Hand(fullHand, ArrayBuffer.empty[Joker])

    intercept[exceptions.MaxCardsExceededException] {
      hand.addCard(new Card(king, spade)) // Attempt to add the 9th card
    }
  }

  test("removeCardByIndex should throw InvalidCardIndexException for an out-of-bounds index") {
    hand.addCard(new Card(ace, heart)) // Hand has one card at index 0

    intercept[exceptions.InvalidCardIndexException] {
      hand.removeCardByIndex(1) // Index 1 is invalid
    }
    intercept[exceptions.InvalidCardIndexException] {
      hand.removeCardByIndex(-1) // Negative index is invalid
    }
  }

  test("addJoker should throw MaxJokersExceededException when jokers are full") {
    hand.addJoker(greedyJoker)
    hand.addJoker(scaryFaceJoker) // Hand now has 2 jokers

    intercept[exceptions.MaxJokersExceededException] {
      hand.addJoker(evenStevenJoker) // Attempt to add the 3rd joker
    }
  }

  test("removeJokerByIndex should throw InvalidJokerIndexException for an out-of-bounds index") {
    hand.addJoker(greedyJoker) // Hand has one joker at index 0

    intercept[exceptions.InvalidJokerIndexException] {
      hand.removeJokerByIndex(1) // Index 1 is invalid
    }
    intercept[exceptions.InvalidJokerIndexException] {
      hand.removeJokerByIndex(-1) // Negative index is invalid
    }
  }

  test("playHand should throw MaxPlaysExceededException on fourth play attempt") {
    hand = new Hand(ArrayBuffer.fill(8)(new Card(ace, heart)), ArrayBuffer.empty[Joker])

    // Perform 3 valid plays to increment the counter
    hand.playHand(ArrayBuffer(0)) // Play 1
    hand.playHand(ArrayBuffer(0)) // Play 2
    hand.playHand(ArrayBuffer(0)) // Play 3

    // The 4th play should be rejected
    intercept[exceptions.MaxPlaysExceededException] {
      hand.playHand(ArrayBuffer(0))
    }
  }

  test("playHand should throw InvalidPlayCountException for an empty selection") {
    hand = new Hand(ArrayBuffer(new Card(ace, heart)), ArrayBuffer.empty[Joker])

    intercept[exceptions.InvalidPlayCountException] {
      hand.playHand(ArrayBuffer.empty[Int]) // 0 cards
    }
  }

  test("playHand should throw InvalidPlayCountException for selecting more than 5 cards") {
    hand = new Hand(ArrayBuffer.fill(6)(new Card(ace, heart)), ArrayBuffer.empty[Joker])

    intercept[exceptions.InvalidPlayCountException] {
      hand.playHand(ArrayBuffer(0, 1, 2, 3, 4, 5)) // 6 cards
    }
  }

  test("playHand should throw InvalidIndexesForPlayException for an invalid index") {
    hand = new Hand(ArrayBuffer(new Card(ace, heart)), ArrayBuffer.empty[Joker])

    intercept[exceptions.InvalidIndexesForPlayException] {
      hand.playHand(ArrayBuffer(5)) // Index 5 is out of bounds
    }
  }
}