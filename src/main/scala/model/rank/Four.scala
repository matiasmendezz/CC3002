package model.rank
import model.rank.ranktype._
/**
 * Represents the Four-card rank in game.
 * The Four is a regular rank in the game.
 *
 * @note Fours are valued at 4 points in the scoring system
 * @note Fours are classified as even cards
 */
class Four extends AbstractRank(
  _name = "Four",
  _value = 4,
  _rankType = new Even()
)