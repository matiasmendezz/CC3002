package model.combination

import munit.FunSuite
import munit.BeforeEach
import munit.Clue.generate
import model.rank._
import model.Card
import model.suit._
import scala.collection.mutable.ArrayBuffer

class FullHouseTest extends FunSuite {
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

  private var fullHouse: FullHouse = _

  override def beforeEach(context: BeforeEach): Unit = {
    fullHouse = new FullHouse()

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

  test("Should identify full house with high cards") {
    val hand1 = ArrayBuffer(
      aceHeart, aceSpade, aceDiamond, kingClub, kingHeart
    )
    val hand2 = ArrayBuffer(
      kingHeart, kingSpade, kingDiamond, aceClub, aceHeart
    )
    val hand3 = ArrayBuffer(
      queenHeart, queenSpade, queenDiamond, jackClub, jackHeart
    )
    assert(fullHouse.matches(hand1), "Should identify full house with three aces and two kings")
    assert(fullHouse.matches(hand2), "Should identify full house with three kings and two aces")
    assert(fullHouse.matches(hand3), "Should identify full house with three queens and two jacks")
  }

  test("Should identify full house with middle-ranked cards") {
    val hand1 = ArrayBuffer(
      sevenHeart, sevenSpade, sevenDiamond, eightClub, eightHeart
    )
    val hand2 = ArrayBuffer(
      eightHeart, eightSpade, eightDiamond, nineClub, nineHeart
    )
    val hand3 = ArrayBuffer(
      nineHeart, nineSpade, nineDiamond, tenClub, tenHeart
    )
    assert(fullHouse.matches(hand1), "Should identify full house with three sevens and two eights")
    assert(fullHouse.matches(hand2), "Should identify full house with three eights and two nines")
    assert(fullHouse.matches(hand3), "Should identify full house with three nines and two tens")
  }

  test("Should identify full house with low-ranked cards") {
    val hand1 = ArrayBuffer(
      twoHeart, twoSpade, twoDiamond, threeClub, threeHeart
    )
    val hand2 = ArrayBuffer(
      threeHeart, threeSpade, threeDiamond, fourClub, fourHeart
    )
    val hand3 = ArrayBuffer(
      fourHeart, fourSpade, fourDiamond, fiveClub, fiveHeart
    )
    assert(fullHouse.matches(hand1), "Should identify full house with three twos and two threes")
    assert(fullHouse.matches(hand2), "Should identify full house with three threes and two fours")
    assert(fullHouse.matches(hand3), "Should identify full house with three fours and two fives")
  }

  test("Should identify full house regardless of card order") {
    val hand1 = ArrayBuffer(
      kingHeart, aceHeart, aceSpade, aceDiamond, kingSpade
    )
    val hand2 = ArrayBuffer(
      twoHeart, threeHeart, twoDiamond, twoSpade, threeSpade
    )
    val hand3 = ArrayBuffer(
      jackHeart, jackSpade, queenHeart, queenDiamond, queenSpade
    )
    assert(fullHouse.matches(hand1), "Should identify full house regardless of order")
    assert(fullHouse.matches(hand2), "Should identify full house regardless of order")
    assert(fullHouse.matches(hand3), "Should identify full house regardless of order")
  }

  test("Should reject when not a full house pattern") {
    val hand1 = ArrayBuffer(
      aceHeart, aceSpade, aceDiamond, kingHeart, queenHeart
    )
    assert(!fullHouse.matches(hand1), "Should reject three of a kind (three aces)")

    val hand2 = ArrayBuffer(
      twoHeart, twoSpade, threeHeart, fourClub, fiveHeart
    )
    assert(!fullHouse.matches(hand2), "Should reject one pair (two twos)")

    val hand3 = ArrayBuffer(
      aceHeart, aceSpade, kingDiamond, kingClub, queenHeart
    )
    assert(!fullHouse.matches(hand3), "Should reject two pair (two aces and two kings)")
  }

  test("Should reject when all cards are different") {
    val hand1 = ArrayBuffer(
      aceHeart, kingSpade, queenDiamond, jackClub, tenHeart
    )
    val hand2 = ArrayBuffer(
      twoHeart, threeSpade, fourDiamond, fiveClub, sixHeart
    )
    assert(!fullHouse.matches(hand1), "Should reject when all cards have different ranks (high cards)")
    assert(!fullHouse.matches(hand2), "Should reject when all cards have different ranks (low cards)")
  }

  test("Should reject when less than 5 cards") {
    val hand1 = ArrayBuffer(aceHeart, aceSpade, aceDiamond, kingClub)
    assert(!fullHouse.matches(hand1), "Should reject with only 4 cards")

    val hand2 = ArrayBuffer(aceHeart, aceSpade, aceDiamond)
    assert(!fullHouse.matches(hand2), "Should reject three of a kind with only 3 cards")

    val hand3 = ArrayBuffer(aceHeart, aceSpade)
    assert(!fullHouse.matches(hand3), "Should reject pair with only 2 cards")

    val hand4 = ArrayBuffer(aceHeart)
    assert(!fullHouse.matches(hand4), "Should reject with only 1 card")

    val hand5 = ArrayBuffer[Card]()
    assert(!fullHouse.matches(hand5), "Should reject empty hands")
  }

  test("Should reject when only a three of a kind is present without a pair") {
    val hand1 = ArrayBuffer(
      aceHeart, aceSpade, aceDiamond, kingClub, queenHeart
    )
    val hand2 = ArrayBuffer(
      sevenHeart, sevenSpade, sevenDiamond, fourClub, twoHeart
    )
    val hand3 = ArrayBuffer(
      jackHeart, jackSpade, jackDiamond, threeClub, fiveHeart
    )
    assert(!fullHouse.matches(hand1), "Should reject three aces without a pair")
    assert(!fullHouse.matches(hand2), "Should reject three sevens without a pair")
    assert(!fullHouse.matches(hand3), "Should reject three jacks without a pair")
  }

  test("Should reject when only a pair is present without a three of a kind") {
    val hand1 = ArrayBuffer(
      aceHeart, aceSpade, kingDiamond, queenClub, jackHeart
    )
    val hand2 = ArrayBuffer(
      sevenHeart, sevenSpade, fiveDiamond, fourClub, twoHeart
    )
    val hand3 = ArrayBuffer(
      jackHeart, jackSpade, nineDiamond, threeClub, fiveHeart
    )
    assert(!fullHouse.matches(hand1), "Should reject pair of aces without three of a kind")
    assert(!fullHouse.matches(hand2), "Should reject pair of sevens without three of a kind")
    assert(!fullHouse.matches(hand3), "Should reject pair of jacks without three of a kind")
  }

}