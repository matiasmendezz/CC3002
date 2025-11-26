package model.rank

import model.Score
import model.joker.Joker
import model.rank.ranktype.* // Asumo esta importación

/**
 * A trait class that represents a card rank in the malatro game.
 */
trait Rank {
  /** The name of the rank. */
  val _name: String

  /** The numerical value (chips) associated with this rank in the game. */
  val _value: Int

  /** The order is by default a list containing only the value, except for special cases like ace, jack..*/
  val _order: List[Int]

  /** The type of rank that represent, could be odd, even or face. */
  val _rankType: RankType

  /** Returns the name of the rank. */
  def getName: String

  /** Returns the numerical value (chips) of the rank. */
  def getValue: Int

  /** Returns the order list for this rank. */
  def getOrder: List[Int]

  /** Returns the type of this rank (odd, even or face). */
  def getRankType: RankType

  /**
   * Returns a string representation of the rank.
   *
   * @return The name of the rank as a string.
   */
  override def toString: String



  /**
   * Applies a Joker's effect to the score, based on this rank.
   *
   * @param score The current score to be potentially modified.
   * @param joker The Joker whose effect is being applied.
   * @return A new Score object, which may be modified to the original.
   */
  def applyScore(score: Score, joker: Joker): Score

}