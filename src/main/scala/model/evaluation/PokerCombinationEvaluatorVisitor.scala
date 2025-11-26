package model.evaluation

import model.Card
import model.combination._ // Import all combination classes and the visitor trait
import scala.collection.mutable.ArrayBuffer

/**
 * A visitor that implements the logic for finding the best poker combination
 * from a given set of cards.
 *
 * @param cards The hand of cards to be evaluated.
 */
class PokerCombinationEvaluatorVisitor(cards: ArrayBuffer[Card]) extends PokerCombinationVisitor {

  /**
   * Store the best combination found so far.
   */
  private var bestMatchFound: Option[PokerCombination] = None

  /**
   * A method containing the core evaluation logic
   *
   * @param combo The PokerCombination to evaluate against the cards.
   */
  private def evaluate(combo: PokerCombination): Unit = {
    if (bestMatchFound.isEmpty && combo.matches(cards)) {
      bestMatchFound = Some(combo)
    }
  }

  // --- Visit Method Implementations ---

  override def visit(combo: StraightFlush): Unit = evaluate(combo)

  override def visit(combo: FourOfAKind): Unit = evaluate(combo)

  override def visit(combo: FullHouse): Unit = evaluate(combo)

  override def visit(combo: Flush): Unit = evaluate(combo)

  override def visit(combo: Straight): Unit = evaluate(combo)

  override def visit(combo: ThreeOfAKind): Unit = evaluate(combo)

  override def visit(combo: TwoPair): Unit = evaluate(combo)

  override def visit(combo: Pair): Unit = evaluate(combo)

  override def visit(combo: HighCard): Unit = evaluate(combo)

  
  /**
   * Getter 
   * Method that gets the result of the evaluation after the visiting process is complete.
   *
   * @return An Option[PokerCombination] containing the best-ranked match.
   */
  override def getBestMatch: Option[PokerCombination] = bestMatchFound
}