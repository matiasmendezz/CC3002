package model.joker

import model.Score
import model.combination.PokerCombination
import model.rank.Rank
import model.suit.Suit

/**
 * An abstract base class that provides a foundational implementation for Jokers.
 *
 *Each Joker possesses one or more effects that can significantly impact the final score.
 *
 * @param _name The display name of the Joker.
 */
abstract class AbstractJoker(val _name: String) extends Joker {

  /**
   * Provides a default implementation for applying effects based on a poker combination.
   * By default, a Joker does not react to any specific combination.
   *
   * @param score The original score.
   * @param pokerCombination The achieved combination.
   * @return The original, unmodified score.
   */
  override def applyScorePokerCombination(score: Score, pokerCombination: PokerCombination): Score = {
    score
  }

  /**
   * Provides a default implementation for applying effects based on a card's rank.
   * By default, a Joker does not react to any specific rank.
   *
   * @param score The original score.
   * @param rank The rank of the card.
   * @return The original, unmodified score.
   */
  override def applyScoreRank(score: Score, rank: Rank): Score = {
    score
  }

  /**
   * Provides a default implementation for applying effects based on a card's suit.
   * By default, a Joker does not react to any specific suit.
   *
   * @param score The original score.
   * @param suit The suit of the card.
   * @return The original, unmodified score.
   */
  override def applyScoreSuit(score: Score, suit: Suit): Score = {
    score
  }

  /** Returns the name of this joker. */
  def getName: String = {
    _name
  }
}