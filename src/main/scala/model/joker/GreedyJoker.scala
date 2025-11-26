package model.joker

import model.Score
import model.suit.Suit

/** The Greedy Joker implementation.
 *
 * This Joker adds +3 to the multiplier for each Diamond card in the player's hand.
 */
class GreedyJoker extends AbstractJoker(_name = "Greedy Joker"){

  /**
   * Applies the Greedy Joker's effect based on the suit of a played card.
   *
   * This method checks if the provided suit has the name "Diamond". If the condition is valid,
   * creates and returns a new `Score` object with the multiplier increased by 3.
   *
   * For any other suit, the Joker has no effect and return the original score
   * @param score The current score to be potentially modified.
   * @param suit  The suit of the card being evaluated. 
   * @return A new `Score` object with an increased multiplier if the suit is a Diamond
   */
  override def applyScoreSuit(score: Score, suit: Suit): Score = {
    if (suit.getName == "Diamond"){
      new Score(score.getChips, score.getMultiplier+3)
    } else {
      score
    }
  }
}