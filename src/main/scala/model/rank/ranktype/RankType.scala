package model.rank.ranktype


/**
 * Trait for different types of ranks.
 *
 * This trait defines a common interface for rank classifications.
 *
 * In the current implementation, this trait is used to represent three rank types:
 * - Even: For cards with even-numbered values
 * - Odd: For cards with odd-numbered values
 * - Face: For face cards (jack, king, queen)
 */
trait RankType {
  /**
   * The name of the ranktype.
   */
   val name: String

   /** Returns the current name of the ranktype. 
    */
   
   def getName: String = {
    name
  } 
}