package model.rank
import model.rank.ranktype._

/**
 * Represents the Jack card rank in the game.
 * The Jack is a face card ranked in the game.
 *
 * @note Jacks are valued at 10 points in the scoring system
 * @note Jacks are classified as face cards
 */
class Jack extends AbstractRank(
  _name = "Jack",
  _value = 10,
  _rankType = new Face()) {
  /** The possible ordinal positions of this rank (11 in deck order) */
  override val _order: List[Int] = List(11)
}