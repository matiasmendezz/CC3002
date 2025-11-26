package controller.state

import munit.FunSuite
import controller.GameController
import exceptions.InvalidActionException
import scala.collection.mutable.ArrayBuffer

class AwaitingActionStateTest extends FunSuite {

  test("AwaitingActionState should have correct stateName") {
    val state = new AwaitingActionState()
    assertEquals(state.stateName, "AwaitingAction")
  }

  test("playHand should execute game logic and reduce plays left") { 
    val controller = new GameController()
    controller.startGame(100) 

    val initialPlaysLeft = controller.getPlayer.get.hand.getPlaysLeft 


    assert(controller.state.isInstanceOf[AwaitingActionState])

    try {
      controller.playHand(List(0, 1, 2, 3, 4))

      val playsAfter = controller.getPlayer.get.hand.getPlaysLeft
      assertEquals(playsAfter, initialPlaysLeft - 1, "Plays left should decrease by 1 after a play") 

    } catch {
      case e: InvalidActionException =>
        fail(s"playHand should be allowed in AwaitingActionState, but threw: ${e.getMessage}")
      case other: Throwable =>
        fail(s"An unexpected error occurred during playHand: ${other.getMessage}")
    }
  }

 
}