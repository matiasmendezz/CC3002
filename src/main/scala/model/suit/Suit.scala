package model.suit

import model.Score
import model.joker.Joker

/**
 * Trait representing card suits in the Malatro card game.
 *
 * This trait defines the essential interface for suits used throughout the game.
 *
 * The implementation includes four card suits:
 * - Hearts
 * - Diamonds
 * - Clubs
 * - Spades
 *
 */
trait Suit {
  /** The name of the suit. */
  val _name : String

  /**
   * Public getter for the name of this suit.
   *
   * @return A string representing the name of the suit.
   */
  def getName: String


  /**
   * Applies a Joker's effect to the score, based on this specific suit.
   *
   *
   * @param score The current score to be potentially modified.
   * @param joker The Joker whose effect is being applied.
   * @return A new Score object, which may be modified the original.
   */
  def applyScore(score: Score, joker: Joker): Score

}