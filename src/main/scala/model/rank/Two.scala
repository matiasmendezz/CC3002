package model.rank

import model.rank.ranktype._
/**
 * Represents the Two-card rank in game.
 * The Two is a regular rank in the game.
 *
 * @note Twos are valued at 2 points in the scoring system
 * @note Twos are classified as even cards
 */
class Two extends AbstractRank(
  _name = "Two",
  _value = 2,
  _rankType = new Even()) {
  
  
  
}