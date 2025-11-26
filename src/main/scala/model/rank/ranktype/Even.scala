package model.rank.ranktype

/**  Represents an Even rank type.
 * This class extends RankType to classify elements with even rank
 */
class Even extends RankType {
  /** Name of the rank type */
  val name = "Even"

  /** Returns string representation of the rank type
   * @return name of the rank type
   */
  override def toString: String = name
}
