package model.joker

import model.Score
import model.rank.Rank

/** The Even Steven Joker implementation.
 *
 * This Joker adds +4 to the multiplier for each even-ranked card in the player's hand.
 */
class EvenSteven extends AbstractJoker(_name = "Even Steven"){
  /**
   * Applies the Even Steven's effect based on the rank of a played card.
   *
   *
   * If the rank's type is not "Even", the original score is returned unmodified.
   *
   * @param score The current score to be potentially modified.
   * @param rank  The rank of the card being evaluated.
   * @return A new `Score` object with an increased multiplier if the rank is even
   */
  override def applyScoreRank(score: Score, rank: Rank): Score = {
    val typeRank = rank.getRankType.getName
    if (typeRank == "Even") {
      new Score(score.getChips, score.getMultiplier + 4)
    } else {
      score
    }
  }
}