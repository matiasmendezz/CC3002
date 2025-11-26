package model.rank
import model.rank.ranktype._
/**.
 * Represents the Ace card rank in the game.
 * The Ace is a special rank that can be considered as either the lowest card (1)
 * or the highest card (14) in certain contexts.
 *
 * @note Aces are valued at 11 points in the scoring system
 * @note Aces are classified as odd cards
 */
class Ace extends AbstractRank(
                       _name = "Ace",
                       _value = 11,
                       _rankType = new Odd()){
  /** The possible ordinal positions of this rank (1 for low Ace, 14 for high Ace) */
  override val _order: List[Int] = List(1, 14)

}