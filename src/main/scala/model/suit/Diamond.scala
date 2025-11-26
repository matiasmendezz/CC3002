package model.suit

import model.Score
import model.joker.Joker

/**
 * Implementation of the Diamonds suit for the Malatro card game.
 *
 * The Diamonds suit is one of the four suits in Malatro.
 *
 */
class Diamond extends AbstractSuit(_name="Diamond"){

  /**
   * Overrides the default `applyScore` method to enable special Joker interactions.
   *
   * This mechanism allows a Joker to identify that the
   * suit being processed is a Diamond and apply the effect.
   *
   * @param score The current score object to be potentially modified.
   * @param joker The active Joker whose effect is being applied.
   * @return A new Score object, which may be modified by the Joker.
   */

  override def applyScore(score: Score, joker: Joker) : Score = {
    joker.applyScoreSuit(score, this)

  }
}
