package model.rank

import model.rank.ranktype._
/**
 * Represents the Nine-card rank in game.
 * The Nine is a regular rank in the game.
 *
 * @note Nines are valued at 9 points in the scoring system
 * @note Nines are classified as odd cards
 */
class Nine extends AbstractRank(
  _name = "Nine",
  _value = 9,
  _rankType = new Odd()
)