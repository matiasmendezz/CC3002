package model.combination

import model.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents the Three of a Kind combination in a poker hand.
 *
 * A Three of a Kind hand consists of three cards of the same rank,
 * accompanied by two other cards of different ranks.
 *
 * @note Groups cards by the first element of their rank order to handle 
 *       potential multi-element rank orders
 */
class ThreeOfAKind extends AbstractPokerCombination(name="Three of a Kind",
                                            chips=30, 
                                            multiplier=3) {

  /**
   * Validates whether the given set of cards forms a Three of a Kind hand.
   *
   * @param cards Mutable collection of cards to evaluate
   * @return true if the hand meets Three of a Kind criteria, false otherwise
   * @throws Nothing This method does not throw any exceptions
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    // Validate minimum card count
    if (cards.length < 2) return false

    // Group cards by first rank order element
    val rankGroups = cards.groupBy(_._rank._order.head)

    // Validation condition
    // At least one group must have exactly 3 cards
    rankGroups.exists(_._2.length == 3)
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
}