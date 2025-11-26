package model.combination

import model.joker.Joker
import model.{Card, Score}

import scala.collection.mutable.ArrayBuffer

/**
 * Trait that represents a poker combination.
 * Each combination has a base score, a multiplier, and logic to verify
 * if a hand of cards meets the requirements of the combination.
 */
trait PokerCombination(val name: String,
                       val chips: Int,
                       val multiplier: Int) {



  /**
   * Verifies if a list of cards matches this combination.
   *
   * @param cards List of cards to check (from 1 to 5 cards)
   * @return true if the cards match the combination, false otherwise
   */
  def matches(cards: ArrayBuffer[Card]): Boolean


  /**
   * Provides implementation for applying a Joker's effect.
   *
   * This method returns the  new score applied a Joker's effect.
   *
   * @param score The current score object to be potentially modified.
   * @param joker The Joker whose effect is being applied.
   * @return The original, unmodified Score object.
   */
  def applyScore(score: Score, joker: Joker): Score

  override def toString: String

  /**
   * Gets the name of the combination
   */
  def getName: String

  /**
   * Gets the base points (chips) for this combination
   */
  def getChips: Int

  /**
   * Gets the point multiplier for this combination
   */
  def getMultiplier: Int

  /**
   * Accepts a visitor.
   *
   * @param visitor The visitor that will perform an operation on this combination.
   */
  def accept(visitor: PokerCombinationVisitor): Unit


}