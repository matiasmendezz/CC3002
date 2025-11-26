package controller

import munit.FunSuite
import controller.GameController
import controller.state.{AwaitingActionState, NotStartedState}
import exceptions.InvalidActionException

class NotStartedStateTest extends FunSuite {

  test("NotStartedState should have correct stateName") {
    val state = new NotStartedState()
    assertEquals(state.stateName, "Not Started")
  }

  test("startGame should successfully initialize the game and transition state") {
    val controller = new GameController()


    assert(controller.state.isInstanceOf[NotStartedState])

    controller.startGame(5000)


    assert(controller.state.isInstanceOf[AwaitingActionState])

    assert(controller.getPlayer.isDefined)
    assert(controller.getPlayer.get.hand.getCards.nonEmpty)
  }

}


