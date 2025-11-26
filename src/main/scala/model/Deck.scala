package model

import model.rank._ 
import model.suit._ 

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Represents the game's deck of cards.
 */
class Deck {

  /** The internal collection of cards in the deck. */
  private var cards: ArrayBuffer[Card] = ArrayBuffer.empty

  /**
   * Shuffles the cards in the deck into a random order.
   */
  def shuffle(): Unit = {
    cards = Random.shuffle(cards)
  }


  /**
   * Draws a specified number of cards from the top of the deck.
   * The drawn cards are removed from the deck. This operation modifies the deck.
   *
   * @param count The number of cards to draw.
   * @return A list containing the drawn cards.
   */
  def draw(count: Int): ArrayBuffer[Card] = {
    val drawnCards = cards.take(count)
    cards.remove(0, count)
    drawnCards
  }


  /** Returns the number of cards currently remaining in the deck. */
  def cardsLeft: Int = cards.size

  /**
   * Private method to create a standard 52-card deck.
   * Called once when the Deck object is instantiated.
   */
  private def initialize(): Unit = {
    val ranks: List[Rank] = List(
      new Ace(), new Two(), new Three(), new Four(), new Five(), new Six(),
      new Seven(), new Eight(), new Nine(), new Ten(), new Jack(), new Queen(), new King()
    )
    val suits: List[Suit] = List(
      new Heart(), new Diamond(), new Club(), new Spade()
    )
    for (suit <- suits) {
      for (rank <- ranks) {
        cards += new Card(rank, suit)
      }
    }
  }
  initialize()
}