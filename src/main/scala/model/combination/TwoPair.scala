package model.combination

import model.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents the Two Pair combination in a poker hand.
 *
 * A Two Pair hand consists of two different pairs of cards
 * with the same rank, along with an additional card.
 *
 * @note Groups cards by the first element of their rank order to handle
 *       potential multi-element rank orders
 */
class TwoPair extends AbstractPokerCombination(name="Two Pair",
                                       chips=20,
                                       multiplier=2) {


  /**
   * Validates whether the given set of cards forms a Two Pair hand.
   *
   * Validation Process:
   * 1. Checks minimum card count (4 cards)
   * 2. Groups cards by rank order
   * 3. Ensures exactly two groups contain 2 cards each
   *
   * @param cards Mutable collection of cards to evaluate
   * @return true if the hand meets Two Pair criteria, false otherwise
   * @throws Nothing This method does not throw any exceptions
   *
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    // Validate minimum card count
    if (cards.length < 4) return false

    // Group cards by first rank order element
    val rankGroups = cards.groupBy(_._rank._order.head)

    // Validation condition
    // Exactly two groups must have 2 cards each
    rankGroups.count(_._2.length == 2) == 2
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
}