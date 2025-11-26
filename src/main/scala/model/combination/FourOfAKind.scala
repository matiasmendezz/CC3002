package model.combination

import model.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents a Four of a Kind poker combination.
 *
 * A Four of a Kind consists of four cards of the same rank and one additional card
 * (known as the "kicker"). This is one of the highest-ranking poker hands.
 *
 * Characteristics:
 * - Exactly four cards of the same rank
 * - One additional card of any rank
 * - The suit of the cards doesn't matter
 * - Only the rank is considered for matching
 *
 * Scoring:
 * - Chips: 60
 * - Multiplier: 7
 */
class FourOfAKind extends AbstractPokerCombination(name = "Four of a Kind", 
                                           chips=60, 
                                           multiplier=7) {

  /**
   * Determines if the given cards form a Four of a Kind.
   *
   * This method checks if exactly four cards share the same rank, regardless
   * of their suits.
   *
   * @param cards The collection of cards to evaluate
   * @return true if the cards form a Four of a Kind, false otherwise
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    if (cards.length < 5) return false

    // Group cards by their rank order (not value) and check if any group has 4 cards
    val rankGroups = cards.groupBy(_._rank._order.head)
    rankGroups.exists(_._2.length == 4)
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
}