package model.combination

import model.joker.Joker
import model.{Card, Score}

import scala.collection.mutable.ArrayBuffer

/**
 * Represents the Straight combination in a poker hand.
 *
 * A Straight is a hand containing five cards of sequential rank, 
 * not all of the same suit. The Ace can be used as both the highest 
 * card and the lowest card.
 *
 * @note Uses a custom consecutive check method to handle complex 
 *       rank ordering, especially with Ace's dual role
 */
class Straight extends AbstractPokerCombination(name="Straight",
                                        chips=30,
                                        multiplier=4) {
  /**
   * Checks if a sequence of values is consecutive.
   *
   * @param values Sorted array of integer values to check
   * @return true if values are strictly consecutive, false otherwise
   * @note Assumes input is already sorted
   */
  private def isConsecutive(values: ArrayBuffer[Int]): Boolean = {
    values.zip(values.tail).forall { case (a, b) => b - a == 1 }
  }

  /**
   * Validates whether the given set of cards forms a Straight hand.
   *
   * @param cards Mutable collection of cards to evaluate
   * @return true if the hand meets Straight criteria, false otherwise
   * @throws Nothing This method does not throw any exceptions
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    // Validate card count
    if (cards.length != 5) return false

    // Case 1: High straight (Ace as 14)
    val highOrders = ArrayBuffer[Int]() ++= cards.map(card =>
      if (card._rank._order.contains(14)) 14 // Ace counts as 14 for high straight
      else card._rank._order.head
    ).sorted
    val isHighStraight = isConsecutive(highOrders)

    // Case 2: Low straight with Ace (Ace as lowest card)
    val hasAce = cards.exists(_._rank._order.contains(14))
    val isLowStraight = if (hasAce) {
      val lowOrders = ArrayBuffer[Int]() ++= cards.map(card =>
        if (card._rank._order.contains(14)) 1 // Ace counts as 1 for low straight
        else card._rank._order.head
      ).sorted
      isConsecutive(lowOrders)
    } else false

    // Hand is valid if either high or low straight
    (isHighStraight || isLowStraight)
  }
  
  override def applyScore(score:Score, joker:Joker): Score = {
    joker.applyScorePokerCombination(score, this)
  }

  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
}