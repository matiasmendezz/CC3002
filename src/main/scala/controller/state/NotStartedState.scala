package controller.state

import controller.GameController

/**
 * Represents the initial state of the game, before `startGame` is called.
 * This state's primary responsibility is to handle the transition from an
 * uninitialized game to an active one.
 */
class NotStartedState extends AbstractGameState {
  override val stateName = "Not Started"

  /**
   * Overrides the default `startGame` behavior to correctly handle game initialization.
   *
   * @param controller The main GameController instance, which this state will modify.
   * @param targetScore The score the player needs to achieve to win.
   */
  override def startGame(controller: GameController, targetScore: Int): Unit = {
    controller.initializeGame(targetScore)

    // Changes the state object to change behavior
    controller.state = new AwaitingActionState()
  }
}