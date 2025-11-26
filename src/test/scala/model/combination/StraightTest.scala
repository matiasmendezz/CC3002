package model.combination

import munit.FunSuite
import munit.BeforeEach
import munit.Clue.generate
import model.rank._
import model.Card
import model.suit._
import scala.collection.mutable.ArrayBuffer

class StraightTest extends FunSuite {
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

  private var straight: Straight = _

  override def beforeEach(context: BeforeEach): Unit = {
    straight = new Straight()

    aceHeart = new Card(ace, heart)
    aceDiamond = new Card(ace, diamond)
    aceClub = new Card(ace, club)
    aceSpade = new Card(ace, spade)

    twoHeart = new Card(two, heart)
    twoDiamond = new Card(two, diamond)
    twoClub = new Card(two, club)
    twoSpade = new Card(two, spade)

    threeHeart = new Card(three, heart)
    threeDiamond = new Card(three, diamond)
    threeClub = new Card(three, club)
    threeSpade = new Card(three, spade)

    fourHeart = new Card(four, heart)
    fourDiamond = new Card(four, diamond)
    fourClub = new Card(four, club)
    fourSpade = new Card(four, spade)

    fiveHeart = new Card(five, heart)
    fiveDiamond = new Card(five, diamond)
    fiveClub = new Card(five, club)
    fiveSpade = new Card(five, spade)

    sixHeart = new Card(six, heart)
    sixDiamond = new Card(six, diamond)
    sixClub = new Card(six, club)
    sixSpade = new Card(six, spade)

    sevenHeart = new Card(seven, heart)
    sevenDiamond = new Card(seven, diamond)
    sevenClub = new Card(seven, club)
    sevenSpade = new Card(seven, spade)

    eightHeart = new Card(eight, heart)
    eightDiamond = new Card(eight, diamond)
    eightClub = new Card(eight, club)
    eightSpade = new Card(eight, spade)

    nineHeart = new Card(nine, heart)
    nineDiamond = new Card(nine, diamond)
    nineClub = new Card(nine, club)
    nineSpade = new Card(nine, spade)

    tenHeart = new Card(ten, heart)
    tenDiamond = new Card(ten, diamond)
    tenClub = new Card(ten, club)
    tenSpade = new Card(ten, spade)

    jackHeart = new Card(jack, heart)
    jackDiamond = new Card(jack, diamond)
    jackClub = new Card(jack, club)
    jackSpade = new Card(jack, spade)

    queenHeart = new Card(queen, heart)
    queenDiamond = new Card(queen, diamond)
    queenClub = new Card(queen, club)
    queenSpade = new Card(queen, spade)

    kingHeart = new Card(king, heart)
    kingDiamond = new Card(king, diamond)
    kingClub = new Card(king, club)
    kingSpade = new Card(king, spade)
  }

  test("Should identify regular straights with different ranks and suits") {
    val hand1 = ArrayBuffer(
      twoHeart, threeSpade, fourDiamond, fiveClub, sixHeart
    )
    val hand2 = ArrayBuffer(
      sixSpade, sevenHeart, eightDiamond, nineClub, tenHeart
    )
    assert(straight.matches(hand1), "Should identify straight from 2 to 6")
    assert(straight.matches(hand2), "Should identify straight from 6 to 10")
  }

  test("Should identify straight with Ace high") {
    val hand1 = ArrayBuffer(
      tenDiamond, jackHeart, queenSpade, kingClub, aceHeart
    )
    val hand2 = ArrayBuffer(
      aceSpade, kingHeart, queenDiamond, jackClub, tenSpade
    )
    assert(straight.matches(hand1), "Should identify Broadway straight (10-J-Q-K-A)")
    assert(straight.matches(hand2), "Should identify Broadway straight regardless of order")
  }

  test("Should identify straight with Ace low") {
    val hand1 = ArrayBuffer(
      aceSpade, twoHeart, threeClub, fourDiamond, fiveSpade
    )
    val hand2 = ArrayBuffer(
      twoClub, aceHeart, threeDiamond, fourHeart, fiveClub
    )
    assert(straight.matches(hand1), "Should identify wheel straight (A-2-3-4-5)")
    assert(straight.matches(hand2), "Should identify wheel straight regardless of order")
  }

  test("Should identify straights regardless of card order") {
    val hand1 = ArrayBuffer(
      fourHeart, twoSpade, fiveClub, threeDiamond, sixHeart
    )
    val hand2 = ArrayBuffer(
      kingSpade, aceHeart, queenDiamond, tenClub, jackSpade
    )
    assert(straight.matches(hand1), "Should identify straight from 2 to 6 in any order")
    assert(straight.matches(hand2), "Should identify Broadway straight in any order")
  }

  test("Should reject when cards are not consecutive") {
    val hand1 = ArrayBuffer(
      twoHeart, threeDiamond, fiveClub, sixSpade, sevenHeart
    )
    val hand2 = ArrayBuffer(
      twoHeart, fourClub, fiveSpade, sixDiamond, eightHeart
    )
    assert(!straight.matches(hand1), "Should reject non-consecutive cards")
    assert(!straight.matches(hand2), "Should reject non-consecutive cards")
  }


  test("Should reject when the number of cards is not five") {
    val lessThanFiveCards = ArrayBuffer(tenHeart, jackHeart, twoDiamond, kingClub)
    assert(!straight.matches(lessThanFiveCards), "Should reject less than five cards")

    val hand1 = ArrayBuffer(tenHeart, jackHeart, queenHeart, kingHeart)
    assert(!straight.matches(hand1), "Should reject less than five cards, even if consecutive and same suit")

    val hand2 = ArrayBuffer(tenHeart, queenHeart, aceHeart)
    assert(!straight.matches(hand2), "Should reject less than five cards, non-consecutive")

    val hand3 = ArrayBuffer(aceSpade, twoSpade)
    assert(!straight.matches(hand3), "Should reject less than five cards, even if consecutive and same suit")

    val hand4 = ArrayBuffer(aceHeart)
    assert(!straight.matches(hand4), "Should reject hands with a single card")

    val hand5 = ArrayBuffer[Card]()
    assert(!straight.matches(hand5), "Should reject empty hands")
  }
}