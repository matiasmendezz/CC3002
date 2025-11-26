package controller

import munit.FunSuite
import controller.GameController
import controller.state.GameOverState
import exceptions.InvalidActionException

import scala.collection.mutable.ArrayBuffer

class GameOverStateTest extends FunSuite {

  val dummyController = new GameController()
  val testMessage = "Game over, you lose!"

  test("GameOverState should be initialized with the correct stateName") {
    val state = new GameOverState(testMessage)
    assertEquals(state.stateName, "GameOver")
  }

  test("startGame should throw InvalidActionException in GameOverState") {
    val state = new GameOverState(testMessage)
    intercept[InvalidActionException] {
      state.startGame(dummyController, 1000)
    }
  }

  test("playHand should throw InvalidActionException in GameOverState") {
    val state = new GameOverState(testMessage)
    intercept[InvalidActionException] {
      state.playHand(dummyController, List(0, 1, 2))
    }
  }

  test("discardCards should throw InvalidActionException in GameOverState") {
    val state = new GameOverState(testMessage)
    intercept[InvalidActionException] {
      state.discardCards(dummyController, List(0, 1))
    }
  }
}