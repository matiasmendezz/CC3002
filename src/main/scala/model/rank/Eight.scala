package model.rank
import model.rank.ranktype._
/**
 * Represents the Eight-card rank in game.
 * The Eight is a regular rank in the game.
 *
 * @note Eights are valued at 8 points in the scoring system
 * @note Eights are classified as even cards
 */
class Eight extends AbstractRank(
  _name = "Eight",
  _value = 8,
  _rankType = new Even()
)