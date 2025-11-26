package model.rank.ranktype

/**  Represents an Odd rank type.
 * This class extends RankType to classify elements with odd rank
 */
class Odd extends RankType {
  /** Name of the rank type */
  val name = "Odd"

  /** Returns string representation of the rank type
   * @return name of the rank type
   */
  override def toString: String = name
}