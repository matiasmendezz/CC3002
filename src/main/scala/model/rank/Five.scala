package model.rank
import model.rank.ranktype._
/**
 * Represents the Five-card rank in game.
 * The Five is a regular rank in the game.
 *
 * @note Fives are valued at 5 points in the scoring system
 * @note Fives are classified as odd cards
 */
class Five extends AbstractRank(
  _name = "Five",
  _value = 5,
  _rankType = new Odd()
)