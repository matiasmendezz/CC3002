package model.combination

import model.Card
import scala.collection.mutable.ArrayBuffer
import model.rank._

/**
 * Represents a Straight Flush poker combination.
 *
 * A Straight Flush is a hand that contains five consecutive cards of the same suit.
 * The Ace can be used as either the highest card (after King) or the lowest card (before 2).
 *
 * Characteristics:
 * - At least 5 cards required
 * - All cards must be of the same suit
 * - Must contain 5 consecutive cards
 * - Ace can be high (A-K-Q-J-10) or low (5-4-3-2-A)
 *
 * Scoring:
 * - Chips: 100
 * - Multiplier: 8
 */
class StraightFlush extends AbstractPokerCombination(name="Straight Flush", 
                                             chips=100, 
                                             multiplier=8) {

  /**
   * Verifies if a sequence of card values is consecutive.
   *
   * @param values ArrayBuffer of integer values representing card ranks
   * @return true if the values form a consecutive sequence, false otherwise
   */
  private def isConsecutive(values: ArrayBuffer[Int]): Boolean = {
    values.sliding(2).forall { case ArrayBuffer(a, b) => b - a == 1 }
  }

  /**
   * Finds all possible 5-card straight sequences in a sorted list of values.
   *
   * @param values ArrayBuffer of integer values representing card ranks
   * @return true if at least one valid straight sequence is found, false otherwise
   */
  private def findStraightSequences(values: ArrayBuffer[Int]): Boolean = {
    values.sliding(5).exists(window => isConsecutive(window))
  }

  /**
   * Determines if the given cards form a Straight Flush.
   *
   * This method checks for both high straight flushes (where Ace is high)
   * and low straight flushes (where Ace is low). It can handle hands with
   * more than 5 cards, looking for any valid straight flush combination
   * within the hand.
   *
   * @param cards The collection of cards to evaluate
   * @return true if the cards contain a valid straight flush, false otherwise
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    if (cards.length < 5) return false

    // Group cards by suit and find suits with at least 5 cards
    val suitGroups = cards.groupBy(_._suit)

    suitGroups.exists { case (suit, suitCards) =>
      if (suitCards.length < 5) false
      else {
        // For each valid suit group, check for straight sequences

        // Case 1: High straight (Ace as 14)
        val highOrders = ArrayBuffer[Int]() ++= suitCards.flatMap(card =>
          if (card._rank._order.contains(14)) List(14) // Ace counts as 14 for high straight
          else card._rank._order
        ).distinct.sorted

        val hasHighStraight = if (highOrders.length >= 5) {
          findStraightSequences(highOrders)
        } else false

        // Case 2: Low straight with Ace
        val hasAce = suitCards.exists(_._rank._order.contains(14))
        val hasLowStraight = if (hasAce && suitCards.length >= 5) {
          val lowOrders = ArrayBuffer[Int]() ++= suitCards.flatMap(card =>
            if (card._rank._order.contains(14)) List(1) // Ace counts as 1 for low straight
            else card._rank._order
          ).distinct.sorted

          findStraightSequences(lowOrders)
        } else false

        hasHighStraight || hasLowStraight
      }
    }
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
}