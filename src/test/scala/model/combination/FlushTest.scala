package model.combination

import munit.FunSuite
import munit.BeforeEach
import munit.Clue.generate
import model.rank._
import model.Card
import model.suit._
import scala.collection.mutable.ArrayBuffer

class FlushTest extends FunSuite {
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

  private var flush: Flush = _

  override def beforeEach(context: BeforeEach): Unit = {
    flush = new Flush()

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

  test("Should identify flush with different card ranks and suits") {
    val handHeart = ArrayBuffer(
      twoHeart, fiveHeart, sevenHeart, jackHeart, kingHeart
    )
    val handDiamond = ArrayBuffer(
      threeDiamond, sixDiamond, eightDiamond, queenDiamond, aceDiamond
    )
    val handSpade = ArrayBuffer(
      twoSpade, fiveSpade, sevenSpade, tenSpade, aceSpade
    )
    val handClub = ArrayBuffer(
      threeClub, sixClub, nineClub, jackClub, kingClub
    )
    assert(flush.matches(handHeart), "Should identify flush of hearts")
    assert(flush.matches(handDiamond), "Should identify flush of diamonds")
    assert(flush.matches(handSpade), "Should identify flush of spades")
    assert(flush.matches(handClub), "Should identify flush of clubs")
  }

  test("Should reject when not all cards are same suit") {
    val hand = ArrayBuffer(
      twoHeart, fiveHeart, sevenHeart, jackDiamond, kingHeart
    )
    assert(!flush.matches(hand), "Should reject hand with mixed suits")
  }

  test("Should reject with insufficient number of cards") {
    val oneCard = ArrayBuffer(twoHeart)
    val twocards = ArrayBuffer(twoHeart, fiveHeart)
    val threecards = ArrayBuffer(twoHeart, fiveHeart, sevenHeart)
    val fourcards = ArrayBuffer(twoHeart, fiveHeart, sevenHeart, jackHeart)
    val emptycards = ArrayBuffer[Card]()

    assert(!flush.matches(oneCard), "Should reject hand with 1 card")
    assert(!flush.matches(twocards), "Should reject hand with 2 cards")
    assert(!flush.matches(threecards), "Should reject hand with 3 cards")
    assert(!flush.matches(fourcards), "Should reject hand with 4 cards")
    assert(!flush.matches(emptycards), "Should reject empty hand")
  }

  test("Should identify flush when having more than 5 cards of same suit") {
    val hand = ArrayBuffer(
      twoHeart, fiveHeart, sevenHeart, jackHeart, kingHeart, aceHeart
    )
    assert(flush.matches(hand), "Should identify flush with 6 cards of same suit")
  }

  test("Should identify flush with multiple suits but 5 of same suit") {
    val hand = ArrayBuffer(
      twoHeart, fiveHeart, sevenHeart, jackHeart, kingHeart, aceDiamond, twoClub
    )
    assert(flush.matches(hand), "Should identify flush despite having other suits")
  }

  test("Should reject when having 4 cards of one suit and 4 of another") {
    val hand = ArrayBuffer(
      twoHeart, fiveHeart, sevenHeart, jackHeart, // 4 hearts
      aceDiamond, kingDiamond, queenDiamond, jackDiamond // 4 diamonds
    )
    assert(!flush.matches(hand), "Should reject when no suit has 5 cards")
  }

  test("Should identify flush with 5 cards and ace as lowest") {
    val straightFlushHand = ArrayBuffer(
      aceHeart, threeHeart, fourHeart, fiveHeart, sixHeart
    )
    assert(flush.matches(straightFlushHand), "Should reject straight flush")
  }

  test("Should identify flush with face cards") {
    val hand = ArrayBuffer(
      tenHeart, jackHeart, queenHeart, kingHeart, aceHeart
    )
    assert(flush.matches(hand), "Should identify flush with face cards")
  }

  test("Should identify flush with non-consecutive numbers") {
    val hand = ArrayBuffer(
      twoHeart, fourHeart, sixHeart, eightHeart, tenHeart
    )
    assert(flush.matches(hand), "Should identify flush with non-consecutive numbers")
  }

  test("Should identify flush with mixed face and number cards") {
    val hand = ArrayBuffer(
      twoHeart, sixHeart, tenHeart, kingHeart, aceHeart
    )
    assert(flush.matches(hand), "Should identify flush with mixed face and number cards")
  }

  test("Should reject when exactly 4 cards of same suit") {
    val hand = ArrayBuffer(
      twoHeart, sixHeart, tenHeart, kingHeart, aceDiamond
    )
    assert(!flush.matches(hand), "Should reject when only 4 cards of same suit")
  }

  test("Should identify flush in any position within larger hand") {
    val hand1 = ArrayBuffer(
      twoClub, sixClub, // non-flush cards at start
      aceHeart, kingHeart, queenHeart, jackHeart, tenHeart // flush cards at end
    )
    val hand2 = ArrayBuffer(
      aceHeart, kingHeart, queenHeart, jackHeart, tenHeart, // flush cards at start
      twoClub, sixClub // non-flush cards at end
    )
    val hand3 = ArrayBuffer(
      twoClub, // non-flush at start
      aceHeart, kingHeart, queenHeart, jackHeart, tenHeart, // flush cards in middle
      sixClub // non-flush at end
    )

    assert(flush.matches(hand1), "Should identify flush at end of hand")
    assert(flush.matches(hand2), "Should identify flush at start of hand")
    assert(flush.matches(hand3), "Should identify flush in middle of hand")
  }

  test("Should reject when having multiple non-flush cards mixed") {
    val hand = ArrayBuffer(
      twoHeart, sixDiamond, tenHeart, kingClub, aceSpade,
      jackHeart, queenDiamond
    )
    assert(!flush.matches(hand), "Should reject with mixed suits")
  }

  test("Should identify flush with duplicate ranks of same suit") {
    val hand = ArrayBuffer(
      twoHeart, twoHeart, threeHeart, fourHeart, fiveHeart
    )
    assert(flush.matches(hand), "Should identify flush with duplicate ranks")
  }
}