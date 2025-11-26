package model.suit

import model.Score
import model.joker.Joker

/**
 * An abstract base class that provides a foundational implementation for card suits.
 *
 * This class implements the `Suit` trait and serves to reduce code duplication.
 * It handles the storage of the `name` property and provides default implementations
 * for the `getName` and `applyScore` methods.
 *
 * Concrete suit objects will extend this class.
 *
 * @param _name The name of the suit, used to implement the `name` val from the trait.
 */
abstract class AbstractSuit(val _name: String) extends Suit {

  /**
   * Public getter for the name of this suit.
   * This provides a concrete implementation inherited by all subclasses.
   *
   * @return A string representing the name of the suit.
   */
  override def getName: String = {
    _name
  }

  /**
   * Provides a default implementation for applying a Joker's effect.
   *
   * By default, a suit does not have a special interaction with a Joker.
   * This method returns the score unmodified
   *
   * @param score The current score object.
   * @param joker The Joker whose effect is being applied.
   * @return The original, unmodified `Score` object.
   */
  override def applyScore(score: Score, joker: Joker): Score = {
    score 
  }

  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Suit => this.getName == that.getName
      case _ => false
    }
  }

  override def hashCode(): Int = {
    _name.hashCode()
  }
}