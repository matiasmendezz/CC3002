package controller.state

import controller.GameController

/**
 * The main gameplay state. In this state, the player is expected to play a hand.
 * The game remains in this state until the Observer pattern detects the end of plays.
 */
class AwaitingActionState extends AbstractGameState {
  override val stateName = "AwaitingAction"

  /**
   * Handles the action of playing a hand.
   * It delegates the actual execution to a private method in the GameController.
   */
  override def playHand(controller: GameController, cardIndices: List[Int]): Unit = {
    controller.executePlayHand(cardIndices)
  }
  
}