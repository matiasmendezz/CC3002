package model.joker

import model.Score
import model.rank.Rank

/**
 * The Scary Face Joker implementation.
 *
 * This Joker activates its effect for each card played that is a face card
 * When activated, it adds a bonus of +30 chips to the score.
 */
class ScaryFace extends AbstractJoker(_name = "Scary Face") {

  /**
   * Applies the Scary Face's effect based on the rank of a played card.
   *
   *
   * If the rank's type is not "Face", the original score is returned unmodified.
   *
   * @param score The current score to be potentially modified.
   * @param rank The rank of the card being evaluated.
   * @return A new `Score` object with increased chips if the rank is a face card
   */
  override def applyScoreRank(score: Score, rank: Rank): Score = {
    val typeRank = rank.getRankType.getName

    if (typeRank == "Face") {
      new Score(score.getChips + 30, score.getMultiplier)
    } else {
      score
    }
  }
}