package model.rank

import model.Score
import model.joker.Joker
import model.rank.ranktype.*

/**
 * An abstract base class that provides a foundational implementation for card ranks.
 *
 * This class handles the storage and retrieval of common rank properties,
 * reducing code duplication across concrete rank classes.
 *
 * @param _name The name of the rank.
 * @param _value The numerical value (chips) associated with this rank in the game.
 * @param _rankType The type of rank that represent, could be odd, even or face.
 */
abstract class AbstractRank(
                             val _name: String,
                             val _value: Int,
                             val _rankType: RankType
                           ) extends Rank {

  /**
   * The order is by default a list containing only the value.
   * Special cases like Ace must override this value.
   */
  override val _order: List[Int] = List(_value)

  /** Returns the name of the rank. */
  override def getName: String = {
    _name
  }

  /** Returns the numerical value (chips) of the rank. */
  override def getValue: Int = {
    _value
  }

  /** Returns the type of this rank (odd, even or face). */
  override def getRankType: RankType = {
    _rankType
  }

  /** Returns the order list for this rank. */
  override def getOrder: List[Int] = {
    _order
  }

  /**
   * Returns a string representation of the rank.
   *
   * @return The name of the rank as a string.
   */
  override def toString: String = _name


  /**
   * Applies a Joker's effect to the score, based on this rank.
   * Ba joker does not have an effect on a rank if is his rank type
   * equal to odd. For face, and even we can have different effects depending 
   * on the joker card..
   * This method returns the score unmodified.
   *
   * @param score The current score to be potentially modified.
   * @param joker The Joker whose effect is being applied.
   * @return A new Score object, which may be modified to the original.
   */

  override def applyScore(score: Score, joker: Joker): Score = {
    if (this.getRankType.getName == "Face" || this.getRankType.getName == "Even"){
      joker.applyScoreRank(score, this)
    } else {
      score
    }
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Rank => this.getName == that.getName
      case _ => false
    }
  }

  override def hashCode(): Int = {
    _name.hashCode()
  }
}