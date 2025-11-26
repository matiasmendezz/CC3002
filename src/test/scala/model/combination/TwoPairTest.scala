package model.combination

import munit.FunSuite
import munit.BeforeEach
import model.rank._
import model.Card
import model.suit._
import scala.collection.mutable.ArrayBuffer

class TwoPairTest extends FunSuite {
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

  private var twoPair: TwoPair = _

  override def beforeEach(context: BeforeEach): Unit = {
    twoPair = new TwoPair()

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

  test("Should identify two pair with different ranks and suits") {
    // Two pairs with different suits
    val hand1 = ArrayBuffer(
      twoHeart, twoDiamond,
      fiveClub, fiveSpade,
      sevenHeart
    )

    // Two pairs with high ranks
    val hand2 = ArrayBuffer(
      kingHeart, kingDiamond,
      nineClub, nineSpade,
      aceHeart
    )

    // Two pairs with mixed suits
    val hand3 = ArrayBuffer(
      jackHeart, jackDiamond,
      threeClub, threeSpade,
      sevenHeart
    )

    assert(twoPair.matches(hand1), "Should identify two pair with 2 and 5")
    assert(twoPair.matches(hand2), "Should identify two pair with king and nine")
    assert(twoPair.matches(hand3), "Should identify two pair with jack and three")
  }

  test("Should reject less than three cards") {
    val hand1 = ArrayBuffer(
      twoHeart, twoDiamond,
      fiveClub
    )
    val hand2 = ArrayBuffer(
      aceDiamond, aceSpade)

    val hand3 = ArrayBuffer(
      kingHeart
    )

    assert(!twoPair.matches(hand1), "Should reject hand with three cards")
    assert(!twoPair.matches(hand2), "Should reject hand with two cards")
    assert(!twoPair.matches(hand3), "Should reject hand with one card")
  }


  test("Should reject hands without two pair") {
    // One pair
    val hand1 = ArrayBuffer(
      twoHeart, twoDiamond,
      fiveClub, sevenSpade,
      nineHeart
    )

    // Three of a kind
    val hand2 = ArrayBuffer(
      kingHeart, kingDiamond, kingClub,
      nineSpade,
      threeHeart
    )

    // No pairs
    val hand3 = ArrayBuffer(
      twoHeart, fourSpade,
      sixDiamond,
      eightClub,
      tenHeart
    )

    assert(!twoPair.matches(hand1), "Should reject hand with only one pair")
    assert(!twoPair.matches(hand2), "Should reject hand with three of a kind")
    assert(!twoPair.matches(hand3), "Should reject hand with no pairs")
  }


  test("Should handle two pair with different ranks") {
    // Two pairs with low ranks
    val hand1 = ArrayBuffer(
      threeHeart, threeDiamond,
      fourClub, fourSpade,
      sixHeart
    )

    // Two pairs with mixed ranks
    val hand2 = ArrayBuffer(
      sevenHeart, sevenDiamond,
      tenClub, tenSpade,
      kingHeart
    )

    assert(twoPair.matches(hand1), "Should identify two pair with 3 and 4")
    assert(twoPair.matches(hand2), "Should identify two pair with 7 and 10")
  }

  test("Should reject Full House") {
    // Full House (Three Kings, Two Fives)
    val fullHouse1 = ArrayBuffer(
      kingHeart, kingDiamond, kingClub,
      fiveSpade, fiveHeart
    )

    // Full House (Three Aces, Two Twos)
    val fullHouse2 = ArrayBuffer(
      aceHeart, aceDiamond, aceClub,
      twoSpade, twoHeart
    )

    assert(!twoPair.matches(fullHouse1), "Should accept Full House with Kings and Fives")
    assert(!twoPair.matches(fullHouse2), "Should accept Full House with Aces and Twos")

  }
}