package controller.state

import controller.GameController
import exceptions.InvalidActionException 

/**
 * An abstract base class providing default implementations for all GameState actions.
 * By default, any action is invalid and will throw an exception. Concrete state classes
 * will extend this.
 */
abstract class AbstractGameState extends GameState {
  /** A name for the state, useful for debugging and error messages. */
  val stateName: String

  // A common prefix for error messages.
  private val errorMsgPrefix = "Cannot perform action in"

  /**
   * Default implementation for `startGame`. Throws an exception because this action
   * should only be valid in the `NotStartedState`.
   */
  override def startGame(controller: GameController, targetScore: Int): Unit =
    throw new InvalidActionException(s"$errorMsgPrefix '$stateName' state.")

  /**
   * Default implementation for `playHand`. Throws an exception.
   */
  override def playHand(controller: GameController, cardIndices: List[Int]): Unit =
    throw new InvalidActionException(s"$errorMsgPrefix '$stateName' state.")

  /**
   * Default implementation for `discardCards`. Throws an exception.
   */
  override def discardCards(controller: GameController, cardIndices: List[Int]): Unit =
    throw new InvalidActionException(s"$errorMsgPrefix '$stateName' state.")
}