package controller

import model._
import model.joker._
import controller.observer.Observer
import controller.state._
import exceptions.InvalidActionException
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 *
 * This class implements:
 * 1. The State Pattern: It holds a reference to the current gameState and
 *    delegates all player actions to it. The state objects themselves handle
 *    transitions and logic validity.
 *
 * 2. The Observer Pattern: It acts as an Observer, listening to the Hand
 *    the Subject to be notified when the game ends
 */
class GameController extends Observer {

  // The current state of the game, initialized to NotStartedState.
  var state: GameState = new NotStartedState()

  private var player: Option[Player] = None
  private var deck: Option[Deck] = None
  private var scoreToBeat: Int = 0



  /**
   * Starts a new game. Public event triggered by the user.
   * Delegates the action to the current state object.
   */
  def startGame(targetScore: Int): Unit = try {
    state.startGame(this, targetScore)
  } catch { case e: Exception => println(s"Error: ${e.getMessage}") }

  /**
   * Plays a hand. Public event triggered by the user.
   * Delegates the action to the current state object.
   */
  def playHand(cardIndexes: List[Int]): Unit = try {
    state.playHand(this, cardIndexes)
  } catch { case e: Exception => println(s"Error: ${e.getMessage}") }

 
  /**
   * The Hand calls this method when it runs out of plays.
   * It checks the final score and transitions the game to a terminal GameOverState.
   */
  override def update(): Unit = {
    println("--- Not more plays! Checking final score... ---")
    val finalScore = player.get.totalScore
    if (finalScore >= scoreToBeat) {
      this.state = new GameOverState(s"You won!! Final Score: $finalScore / $scoreToBeat")
    } else {
      this.state = new GameOverState(s"You lost :( Final Score: $finalScore / $scoreToBeat")
    }
  }


  /**
   * Handles the actual setup of the game model.
   * Called by NotStartedState. This version randomly selects 2 Jokers.
   */
  private[controller] def initializeGame(targetScore: Int): Unit = {
    this.deck = Some(new Deck())
    deck.get.shuffle()

    // 1. Define all available Jokers in the game.
    val allPossibleJokers: List[Joker] = List(
      new GreedyJoker(),
      new DeviousJoker(),
      new EvenSteven(),
      new ScaryFace()
    )

    // 2. Shuffle the list of all jokers and take the first 2.
    // This gives us a random pair for the start of the game.
    val initialJokers = ArrayBuffer.from(Random.shuffle(allPossibleJokers).take(2))

    // 3. Create the hand with the randomly selected Jokers.
    val playerHand = new Hand(deck.get.draw(8), initialJokers)
    playerHand.addObserver(this)

    this.player = Some(new Player(playerHand))
    this.scoreToBeat = targetScore

    println(s"Game started. Target score: $targetScore.")
    println(s"Your Jokers for this round are: ${initialJokers.map(_.getName).mkString(" and ")}.")
  }

  /**
   * Executes the logic for playing a hand.
   * Called by AwaitingActionState.
   */
  private[controller] def executePlayHand(cardIndices: List[Int]): Unit = {
    val p = player.get
    val playedCards = p.hand.playHand(ArrayBuffer.from(cardIndices)) 
    val turnScore = p.hand.applyScoreHand(playedCards)
    p.totalScore += turnScore.totalScore
    
    val newCards = deck.get.draw(playedCards.size)
    p.hand.getCards.appendAll(newCards)

    // Log the results of the turn for the player to see
    val bestMatch = p.hand.bestMatch(playedCards) 
    println(s"Played a ${bestMatch.getName}. Score this turn: ${turnScore.totalScore}. Total score: ${p.totalScore}")
    println(s"Plays left: ${p.hand.getPlaysLeft}, Discards left: ${p.hand.getDiscardsLeft}")
  }
  

  /** Provides access to the player object for the View. */
  def getPlayer: Option[Player] = player

  /** Returns the name of the current state. */
  def getCurrentStateName: String = state.getClass.getSimpleName
}