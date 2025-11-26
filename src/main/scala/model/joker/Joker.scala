package model.joker

import model.Score
import model.combination.PokerCombination
import model.rank.Rank
import model.suit.Suit

/**
 * A trait defining the public contract for any Joker card in the game.
 *
 * Jokers are special cards that aren't played as part of the poker hand, but remain
 * active and modify the scoring rules. Unlike regular cards, Jokers affect how
 * the final score of a hand is calculated by altering either the chips value or
 * the multiplier based on the cards in the player's hand.
 *
 * Each Joker possesses one or more effects that can significantly impact the final score.
 *
 */
trait Joker {

  /**
   * The display name of the Joker.
   */
  val _name: String

  /**
   * Applies the Joker's effect based on a specific poker combination.
   *
   *
   * @param score The current score to be potentially modified.
   * @param pokerCombination The specific poker combination that was achieved.
   * @return A new Score object, which may be modified to the original.
   */
  def applyScorePokerCombination(score: Score, pokerCombination: PokerCombination): Score

  /**
   * Applies the Joker's effect based on the rank of a played card.
   *
   * This method is called for each card in the played hand,
   * letting the Joker react to specific ranks
   *
   * @param score The current score to be potentially modified.
   * @param rank The rank of the card being evaluated.
   * @return A new Score object, which may be modified to the original.
   */
  def applyScoreRank(score: Score, rank: Rank): Score

  /**
   * Applies the Joker's effect based on the suit of a played card.
   *
   * This method allows the Joker to react to specific suits 
   *
   * @param score The current score to be potentially modified.
   * @param suit The suit of the card being evaluated.
   * @return A new Score object, which may be modified  to the original.
   */
  def applyScoreSuit(score: Score, suit: Suit): Score

  /** Returns the name of this joker. */
  def getName: String

}

