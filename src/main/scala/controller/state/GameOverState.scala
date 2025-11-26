package controller.state

/**
 * A terminal state representing the end of the game.
 * No player actions are valid in this state.
 *
 * @param message The final message to display to the player (e.g., "You won!").
 */
class GameOverState(message: String) extends AbstractGameState {
  override val stateName = "GameOver"
  println(s"--- GAME OVER --- \n$message")
}