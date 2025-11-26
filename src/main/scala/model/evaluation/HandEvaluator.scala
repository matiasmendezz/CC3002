package model.evaluation

import model.Card
import model.combination._
import scala.collection.mutable.ArrayBuffer

/**
 * The orchestrator for the hand evaluation process.
 * This class uses the Visitor pattern by creating a visitor and
 * directing it to visit all combinations in a ranked order.
 */
class HandEvaluator {

  /**
   * A ranked list of all possible poker combinations, from highest to lowest.
   * The order is critical for the evaluation logic to work correctly.
   */
  private val allCombinations: List[PokerCombination] = List(
    new StraightFlush(),
    new FourOfAKind(),
    new FullHouse(),
    new Flush(),
    new Straight(),
    new ThreeOfAKind(),
    new TwoPair(),
    new Pair(),
    new HighCard(List(
      new StraightFlush(),
      new FourOfAKind(),
      new FullHouse(),
      new Flush(),
      new Straight(),
      new ThreeOfAKind(),
      new TwoPair(),
      new Pair()
    ))
  )

  /**
   * Finds the best poker combination for a given set of cards.
   *
   * @param cards The cards to evaluate.
   * @return The best possible PokerCombination.
   */
  def findBestCombination(cards: ArrayBuffer[Card]): PokerCombination = {
    val visitor = new PokerCombinationEvaluatorVisitor(cards)

    // Guide the visitor through all combinations in the correct order.
    for (combo <- allCombinations) {
      combo.accept(visitor)
    }

    // Get the final result from the visitor.
    visitor.getBestMatch.getOrElse(
      throw new IllegalStateException("Finder failed: HighCard should always match.")
    )
  }
}