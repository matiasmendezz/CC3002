package model.rank
import model.rank.ranktype._
/**
 * Represents the King card rank in the game.
 * The King is a face card in the standard deck.
 *
 * @note Kings are valued at 10 points in the scoring system
 * @note Kings are classified as face cards
 */
class King extends AbstractRank(
  _name = "King",
  _value = 10,
  _rankType = new Face()) {
  /** The ordinal position of this rank (13 in deck order) */
  override val _order: List[Int] = List(13)
}