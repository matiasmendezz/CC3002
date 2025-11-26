package model.rank

import model.rank.ranktype._
/**
 * Represents the Three-card rank in game.
 * The Three is a regular rank in the game.
 *
 * @note Threes are valued at 3 points in the scoring system
 * @note Threes are classified as odd cards
 */
class Three extends AbstractRank(
  _name = "Three",
  _value = 3,
  _rankType = new Odd()
)