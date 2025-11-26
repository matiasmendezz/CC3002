package model.combination

import munit.FunSuite
import munit.BeforeEach
import munit.Clue.generate
import model.rank._
import model.Card
import model.suit._
import scala.collection.mutable.ArrayBuffer

class FourOfAKindTest extends FunSuite {
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

  private var fourOfAKind: FourOfAKind = _

  override def beforeEach(context: BeforeEach): Unit = {
    fourOfAKind = new FourOfAKind()

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


  test("Should identify four of a kind with high cards") {
    val hand1 = ArrayBuffer(
      aceHeart, aceSpade, aceDiamond, aceClub, kingHeart
    )
    val hand2 = ArrayBuffer(
      kingHeart, kingSpade, kingDiamond, kingClub, aceHeart
    )
    val hand3 = ArrayBuffer(
      queenHeart, queenSpade, queenDiamond, queenClub, jackHeart
    )
    assert(fourOfAKind.matches(hand1), "Should identify four aces as four of a kind")
    assert(fourOfAKind.matches(hand2), "Should identify four kings as four of a kind")
    assert(fourOfAKind.matches(hand3), "Should identify four queens as four of a kind")
  }

  test("Should identify four of a kind with middle-ranked cards") {
    val hand1 = ArrayBuffer(
      sevenHeart, sevenSpade, sevenDiamond, sevenClub, aceHeart
    )
    val hand2 = ArrayBuffer(
      eightHeart, eightSpade, eightDiamond, eightClub, twoHeart
    )
    val hand3 = ArrayBuffer(
      nineHeart, nineSpade, nineDiamond, nineClub, threeHeart
    )
    assert(fourOfAKind.matches(hand1), "Should identify four sevens as four of a kind")
    assert(fourOfAKind.matches(hand2), "Should identify four eights as four of a kind")
    assert(fourOfAKind.matches(hand3), "Should identify four nines as four of a kind")
  }

  test("Should identify four of a kind with low-ranked cards") {
    val hand1 = ArrayBuffer(
      twoHeart, twoSpade, twoDiamond, twoClub, aceHeart
    )
    val hand2 = ArrayBuffer(
      threeHeart, threeSpade, threeDiamond, threeClub, kingHeart
    )
    val hand3 = ArrayBuffer(
      fourHeart, fourSpade, fourDiamond, fourClub, queenHeart
    )
    assert(fourOfAKind.matches(hand1), "Should identify four twos as four of a kind")
    assert(fourOfAKind.matches(hand2), "Should identify four threes as four of a kind")
    assert(fourOfAKind.matches(hand3), "Should identify four fours as four of a kind")
  }

  test("Should identify four of a kind regardless of card order") {
    val hand1 = ArrayBuffer(
      kingHeart, aceHeart, aceSpade, aceDiamond, aceClub
    )
    val hand2 = ArrayBuffer(
      twoHeart, twoSpade, kingHeart, twoDiamond, twoClub
    )
    val hand3 = ArrayBuffer(
      jackHeart, jackSpade, queenHeart, jackDiamond, jackClub
    )
    assert(fourOfAKind.matches(hand1), "Should identify four of a kind regardless of order")
    assert(fourOfAKind.matches(hand2), "Should identify four of a kind regardless of order")
    assert(fourOfAKind.matches(hand3), "Should identify four of a kind regardless of order")
  }

  test("Should reject when not exactly four cards match") {
    val hand1 = ArrayBuffer(
      aceHeart, aceSpade, aceDiamond, kingHeart, queenHeart
    )
    val hand2 = ArrayBuffer(
      twoHeart, twoSpade, queenDiamond, kingClub, jackHeart
    )
    val hand3 = ArrayBuffer(
      tenHeart, tenSpade, tenDiamond, kingClub, queenHeart
    )
    assert(!fourOfAKind.matches(hand1), "Should reject three of a kind (three aces)")
    assert(!fourOfAKind.matches(hand2), "Should reject one pair (two twos)")
    assert(!fourOfAKind.matches(hand3), "Should reject three of a kind (three tens)")
  }
}
  