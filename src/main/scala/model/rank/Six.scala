package model.rank

import model.rank.ranktype._
/**
 * Represents the Six-card rank in game.
 * The Six is a regular rank in the game.
 *
 * @note Sixes are valued at 6 points in the scoring system
 * @note Sixes are classified as even cards
 */
class Six extends AbstractRank(
  _name = "Six",
  _value = 6,
  _rankType = new Even()
)