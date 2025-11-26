package model.combination

import model.Score
import model.joker.Joker

/**
 * An abstract base class that provides a foundational implementation for all poker combinations.
 *
 *
 * It inherits the common state (name, chips, multiplier) from the  trait PokerCombination
 *
 * @param name The display name of the poker combination (e.g., "Straight", "Four of a Kind").
 * @param chips The base chip value awarded by the combination.
 * @param multiplier The score multiplier for the combination.
 */
abstract class AbstractPokerCombination(
                                         name: String,
                                         chips: Int,
                                         multiplier: Int
                                       ) extends PokerCombination(name, chips, multiplier) {

  /**
   * Provides a default implementation for applying a Joker's effect. It's means by default a
   * poker combination does not have a special interaction with a Joker.
   *
   * This method returns the score unmodified.
   *
   * @param score The current score object to be potentially modified.
   * @param joker The Joker whose effect is being applied.
   * @return The original, unmodified Score object.
   */
  def applyScore(score: Score, joker: Joker): Score = {
    score
  }

  override def toString: String = s"$name (${chips} chips, multiplier x${multiplier})"

  /**
   * Gets the name of the combination
   */
  def getName: String = name

  /**
   * Gets the base points (chips) for this combination
   */
  def getChips: Int = chips

  /**
   * Gets the point multiplier for this combination
   */
  def getMultiplier: Int = multiplier

}