package model.rank

import model.rank.ranktype._
/**
 * Represents the Seven-card rank in game.
 * The Seven is a regular rank in the game.
 *
 * @note Sevens are valued at 7 points in the scoring system
 * @note Sevens are classified as odd cards
 */
class Seven extends AbstractRank(
  _name = "Seven",
  _value = 7,
  _rankType = new Odd()
)