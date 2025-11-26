package model.combination

/**
 * This trait allows for performing operations on the hierarchy of `PokerCombination` objects
 * without modifying the classes of those objects.
 *
 */
trait PokerCombinationVisitor {

  def visit(combo: StraightFlush): Unit

  def visit(combo: FourOfAKind): Unit

  def visit(combo: FullHouse): Unit

  def visit(combo: Flush): Unit

  def visit(combo: Straight): Unit

  def visit(combo: ThreeOfAKind): Unit

  def visit(combo: TwoPair): Unit

  def visit(combo: Pair): Unit

  def visit(combo: HighCard): Unit
  

  /**
   * Retrieves the result of the operation after the visitor has visited the object structure.
   * For the evaluator this would return the best combination that was found during the visit.
   *
   * @return An `Option` containing the resulting `PokerCombination`, or `None` if no suitable result was produced.
   */
  def getBestMatch: Option[PokerCombination]

}