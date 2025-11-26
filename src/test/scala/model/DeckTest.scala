package model

import munit.FunSuite

class DeckTest extends FunSuite {

  var deck: Deck = _

  override def beforeEach(context: BeforeEach): Unit = {
    deck = new Deck()
  }

  test("A new Deck should be initialized with 52 cards") {
    assertEquals(deck.cardsLeft, 52, "A new deck must have exactly 52 cards")
  }

  test("A new Deck should contain 52 unique cards") {
    val allCards = deck.draw(52)
    val uniqueCards = allCards.toSet
    assertEquals(uniqueCards.size, 52, "All cards in a new deck must be unique")
  }

  test("draw method should return the correct number of cards") {
    val drawnCards = deck.draw(5)
    assertEquals(drawnCards.size, 5, "Drawing 5 cards should return a list of size 5")
  }

  test("draw method should remove the drawn cards from the deck") {
    deck.draw(10)
    assertEquals(deck.cardsLeft, 42, "After drawing 10 cards, 42 should remain")
    deck.draw(42)
    assertEquals(deck.cardsLeft, 0, "Drawing all remaining cards should leave an empty deck")
  }

  test("shuffle should change the order of the cards") {
    val initialOrderDeck = new Deck()
    val initialOrder = initialOrderDeck.draw(52)

    val shuffledDeck = new Deck()
    shuffledDeck.shuffle()
    val shuffledOrder = shuffledDeck.draw(52)

    assertNotEquals(initialOrder, shuffledOrder, "The order of cards should be different after shuffling")
    assertEquals(initialOrder.toSet, shuffledOrder.toSet, "The set of cards should be the same after shuffling")
  }
}