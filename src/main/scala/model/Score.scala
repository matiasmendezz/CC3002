package model

/** A class that represents a player's score in the card game.
 *
 * Scoring is determined by two components:
 * - Chips: The base points earned for a hand
 * - Multiplier: A factor that amplifies the base points
 *
 * The total score is calculated by multiplying chips by the multiplier.
 *
 * @param chips The base score points earned from a hand or play.
 * @param multiplier A factor that multiplies the chips to calculate the final score.
 *                  Higher multipliers significantly increase the value of earned chips.
 */
class Score(var chips: Int, var multiplier: Int) {
  /** Calculates the total score by multiplying chips by the multiplier.
   *
   * @return The total score value (chips * multiplier).
   */
  def totalScore: Int = chips * multiplier

  /** Returns the base score points (chips). */
  def getChips: Int = {
    return chips
  }

  /** Updates the base score points (chips).
   *
   * @param newChips The new chips value.
   */
  def setChips(newChips: Int): Unit = {
    chips = newChips
  }

  /** Returns the current multiplier factor. */
  def getMultiplier: Int = {
    return multiplier
  }

  /** Updates the multiplier factor.
   *
   * @param newMultiplier The new multiplier value.
   */
  def setMultiplier(newMultiplier: Int): Unit = {
    multiplier = newMultiplier
  }

}