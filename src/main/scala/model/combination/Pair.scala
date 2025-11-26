package model.combination

import model.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents the One Pair combination in a poker hand.
 *
 * A One Pair hand consists of exactly two cards of the same rank,
 * accompanied by three other cards of different ranks.
 *
 * @note Groups cards by the first element of their rank order to handle
 *       potential multi-element rank orders
 */
class Pair extends AbstractPokerCombination(name="One Pair",
                                    chips=10, 
                                    multiplier=2) {
  /**
   * Validates whether the given set of cards forms a One Pair hand.
   *
   * @param cards Mutable collection of cards to evaluate
   * @return true if the hand meets One Pair criteria, false otherwise
   * @throws Nothing This method does not throw any exceptions
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    // Validate minimum card count
    if (cards.length < 2) return false

    // Group cards by first rank order element
    val rankGroups = cards.groupBy(_._rank._order.head)

    // Validation conditions
    // 1. Exactly one group must have 2 cards
    // 2. No group should have more than 2 cards
    rankGroups.count(_._2.length == 2) == 1 &&
      !rankGroups.exists(_._2.length > 2)
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
}