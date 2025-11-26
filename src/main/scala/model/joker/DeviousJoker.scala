package model.joker

import model.Score
import model.combination.{PokerCombination, Straight}

/** The Devious Joker implementation.
 *
 * This Joker adds +100 chips when the player's hand contains a Straight.
 */
class DeviousJoker extends AbstractJoker(_name = "Devious Joker") {

  /** Applies this Joker's effect to modify a score.
   *
   *
   * @param score The original score to be modified
   * @return A new Score object with the Joker's effects applied
   */
  def applyScorePokerCombination(score: Score, pokerCombination: Straight): Score = {
    new Score(score.getChips+100, score.getMultiplier)
  }

}