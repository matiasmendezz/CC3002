package model.combination

import model.Card
import model.Score
import model.joker.Joker

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a Flush poker combination.
 *
 * A Flush is a hand that contains five cards of the same suit,
 * regardless of their ranks. Unlike a Straight Flush, the cards
 * do not need to be in sequential order.
 *
 * Characteristics:
 * - At least 5 cards of the same suit
 * - Cards can be of any rank
 * - Cards do not need to be in sequential order
 * - Can be formed with more than 5 cards as long as 5 share the same suit
 * - The suit itself (hearts, diamonds, clubs, spades) doesn't matter
 *
 * Scoring:
 * - Chips: 35
 * - Multiplier: 4
 */
class Flush extends AbstractPokerCombination(name = "Flush", 
                                    chips = 35,
                                    multiplier = 4) {
 
  /**
   * Determines if the given cards form a Flush.
   *
   * This method checks if there are at least five cards of the same suit
   * in the provided collection of cards. The ranks of the cards and their
   * order do not matter for this combination.
   *
   * Note that this implementation allows for:
   * - Multiple suits present as long as one suit has at least 5 cards
   * - Any combination of ranks within the same suit
   *
   * @param cards The collection of cards to evaluate
   * @return true if the cards contain at least 5 cards of the same suit, false otherwise
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    if (cards.length < 5) return false

    // Group cards by suit and check if any suit has at least 5 cards
    val suitGroups = cards.groupBy(_._suit)
    suitGroups.exists(_._2.length >= 5)
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }


}