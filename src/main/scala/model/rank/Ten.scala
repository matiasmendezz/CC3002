package model.rank

import model.rank.ranktype._
/**
 * Represents the Ten-card rank in game.
 * The Ten is a regular rank in the game.
 *
 * @note Tens are valued at 10 points in the scoring system
 * @note Tens are classified as even cards
 */
class Ten extends AbstractRank(
  _name = "Ten",
  _value = 10,
  _rankType = new Even()
)