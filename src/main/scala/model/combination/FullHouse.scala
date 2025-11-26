package model.combination

import model.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents a Full House poker combination.
 *
 * A Full House consists of three cards of one rank and two cards of another rank.
 * This combination is effectively a Three of a Kind combined with a Pair.
 *
 * Characteristics:
 * - Three cards of one rank (three of a kind)
 * - Two cards of another rank (pair)
 * - Total of five cards
 * - The suits of the cards don't matter
 * - Requires exactly two different ranks
 *
 * Scoring:
 * - Chips: 40
 * - Multiplier: 4
 */
class FullHouse extends AbstractPokerCombination(name="Full House", chips=40, multiplier=4) {
  /**
   * Determines if the given cards form a Full House.
   *
   * This method checks if the cards contain exactly three cards of one rank
   * and two cards of another rank. The suits of the cards are not considered
   * in this evaluation.
   *
   * @param cards The collection of cards to evaluate
   * @return true if the cards form a Full House, false otherwise
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    if (cards.length < 5) return false

    // Group cards by rank and get the size of each group
    val rankGroups = cards.groupBy(_._rank)
    val groupSizes = rankGroups.values.map(_.length).toList.sorted

    // Full house requires exactly two different ranks
    // and the groups must be of size 2 and 3
    rankGroups.size == 2 && groupSizes == List(2, 3)
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
  
}