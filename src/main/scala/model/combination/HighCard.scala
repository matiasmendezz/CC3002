package model.combination

import model.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents the High Card combination in a poker game.
 *
 * High Card is the lowest-ranking hand in poker. It is considered when 
 * no other poker hand combination (pair, two pairs, straight, etc.) 
 * is present in the given set of cards.
 *
 * @param combinations List of other poker combinations to verify 
 *                     that no other combination matches
 */
class HighCard(combinations: List[PokerCombination]) extends AbstractPokerCombination(name="High Card", 
                                                                              chips = 5,
                                                                              multiplier = 1){
  /**
   * Checks if the hand is a High Card.
   *
   * A hand is considered a High Card if:
   * - It contains at least one card
   * - No other poker hand combination matches the hand
   *
   * @param cards Set of cards to evaluate
   * @return true if it's a High Card, false otherwise
   */
  override def matches(cards: ArrayBuffer[Card]): Boolean = {
    // Verify that there is at least one card
    if (cards.length < 1) return false

    // Check that no other combination matches
    !combinations.exists(_.matches(cards))
  }

  /**
   * Finds the highest card in a set of cards.
   *
   * The highest card is determined first by its value, 
   * and in case of a tie, by its order.
   *
   * @param cards Set of cards to evaluate
   * @return The highest card in the set
   * @throws NoSuchElementException if the card set is empty
   */
  def getHighestCard(cards: ArrayBuffer[Card]): Card = {
    cards.maxBy(card => (
      card._rank.getValue,    // First compare by value
      card._rank.getOrder.max // In case of a tie, use the highest order
    ))
  }

  /**
   * Gets the list of poker combinations
   */
  def getCombinations: List[PokerCombination] = combinations


  /**
   * Implements the second dispatch of the visitor pattern
   */
  override def accept(visitor: PokerCombinationVisitor): Unit = {
    visitor.visit(this)
  }
}