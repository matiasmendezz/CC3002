package model.combination

import munit.FunSuite
import munit.BeforeEach
import model.rank._
import model.Card
import model.suit._
import scala.collection.mutable.ArrayBuffer

class StraightFlushTest extends FunSuite {
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

  private var straightFlush: StraightFlush = _

  override def beforeEach(context: BeforeEach): Unit = {
    straightFlush = new StraightFlush()

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

  test("Should reject when the number of cards is not five") {
    val lessThanFiveCards = ArrayBuffer(tenHeart, jackHeart, twoDiamond, kingClub)
    assert(!straightFlush.matches(lessThanFiveCards), "Should reject less than five cards")

    val hand1 = ArrayBuffer(tenHeart, jackHeart, queenHeart, kingHeart)
    assert(!straightFlush.matches(hand1), "Should reject less than five cards, even if consecutive and same suit")

    val hand2 = ArrayBuffer(tenHeart, queenHeart, aceHeart)
    assert(!straightFlush.matches(hand2), "Should reject less than five cards, non-consecutive")

    val hand3 = ArrayBuffer(aceSpade, twoSpade)
    assert(!straightFlush.matches(hand3), "Should reject less than five cards, even if consecutive and same suit")

    val hand4 = ArrayBuffer(aceHeart)
    assert(!straightFlush.matches(hand4), "Should reject hands with a single card")

    val hand5 = ArrayBuffer[Card]()
    assert(!straightFlush.matches(hand5), "Should reject empty hands")
  }

  test("Should reject when cards are not consecutive") {
    val hand = ArrayBuffer(twoSpade, fourSpade, sixSpade, eightSpade, tenSpade)
    assert(!straightFlush.matches(hand), "Cards must be consecutive for a straight flush")
  }

  test("Should reject when cards are not same suit") {
    val hand = ArrayBuffer(fiveClub, sixClub, sevenDiamond, eightClub, nineClub)
    assert(!straightFlush.matches(hand), "All cards must be same suit for a straight flush")
  }

  test("Should identify a regular straight flush") {
    val hand = ArrayBuffer(
      nineHeart, tenHeart, jackHeart, queenHeart, kingHeart
    )
    assert(straightFlush.matches(hand), "Should identify 9-10-J-Q-K all hearts as a straight flush")
  }

  test("Should identify a straight flush without ace") {
    val hand = ArrayBuffer(fourHeart, fiveHeart, sixHeart, sevenHeart, eightHeart)
    assert(straightFlush.matches(hand), "Should identify 4-5-6-7-8 all hearts as a straight flush")
  }

  test("Should identify ace-low straight flush") {
    val hand = ArrayBuffer(aceSpade, twoSpade, threeSpade, fourSpade, fiveSpade)
    assert(straightFlush.matches(hand), "Should identify A-2-3-4-5 all spades as a straight flush")
  }

  test("Should identify ace-high straight flush (Royal Flush)") {
    val hand = ArrayBuffer(tenDiamond, jackDiamond, queenDiamond, kingDiamond, aceDiamond)
    assert(straightFlush.matches(hand), "Should identify 10-J-Q-K-A all diamonds as a royal flush")
  }

  test("Should reject valid straight but different suits") {
    val hand = ArrayBuffer(sixHeart, sevenClub, eightDiamond, nineSpade, tenHeart)
    assert(!straightFlush.matches(hand), "Should reject straight with mixed suits")
  }

  test("Should reject same suit but not straight") {
    val hand = ArrayBuffer(twoClub, fiveClub, sevenClub, jackClub, kingClub)
    assert(!straightFlush.matches(hand), "Should reject non-consecutive cards of same suit")
  }
}