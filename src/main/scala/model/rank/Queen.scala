package model.rank

import model.rank.ranktype._
/**
 * Represents the Queen card rank in game.
 * The Queen is a face card in the standard deck.
 *
 * @note Queens are valued at 10 points in the scoring system
 * @note Queens are classified as face cards
 */
class Queen extends AbstractRank(
  _name = "Queen",
  _value = 10,
  _rankType = new Face()) {
  /** The ordinal position of this rank (12 in deck order) */
  override val _order: List[Int] = List(12)
}