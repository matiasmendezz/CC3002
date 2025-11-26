package controller.state
import controller.GameController

/**
 * It defines all possible actions that a player can trigger, which will be
 * handled differently depending on the current state of the game.
 */
trait GameState {
  /**
   * Action to initialize the game.
   * @param controller The main GameController instance.
   * @param targetScore The score the player needs to achieve to win.
   */
  def startGame(controller: GameController, targetScore: Int): Unit

  /**
   * Action to play a set of cards from the player's hand.
   * @param controller The main GameController instance.
   * @param cardIndices A list of 0-based indices for the cards to play.
   */
  def playHand(controller: GameController, cardIndices: List[Int]): Unit

  /**
   * Action to discard a set of cards from the player's hand.
   * @param controller The main GameController instance.
   * @param cardIndices A list of 0-based indices for the cards to discard.
   */
  def discardCards(controller: GameController, cardIndices: List[Int]): Unit
}