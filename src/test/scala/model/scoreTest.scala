package model

import munit.FunSuite

class scoreTest extends FunSuite {
  var score: Score = _


  override def beforeEach(context: BeforeEach): Unit = {

    score = new Score(0, 1)
  }

  test("Score should initialize with correct chips and multiplier") {
    score = new Score(100, 2)
    assertEquals(score.chips, 100)
    assertEquals(score.multiplier, 2)
  }

  test("Score should calculate total score correctly") {

    score = new Score(50, 3)
    assertEquals(score.totalScore, 150)

    score = new Score(0, 5)
    assertEquals(score.totalScore, 0)

    score = new Score(10, 1)
    assertEquals(score.totalScore, 10)

    score = new Score(75, 4)
    assertEquals(score.totalScore, 300)
  }

  test("Score should handle zero and negative values") {
    // Prueba con valores de chips y multiplicador en diferentes escenarios
    score = new Score(0, 0)
    assertEquals(score.totalScore, 0)

    score = new Score(-50, 2)
    assertEquals(score.totalScore, -100)

    score = new Score(100, -3)
    assertEquals(score.totalScore, -300)

    score = new Score(-75, -4)
    assertEquals(score.totalScore, 300)
  }
  test("setChips should update chips value and recalculate totalScore") {
    val score = new Score(10, 5)
    assertEquals(score.totalScore, 50)

    score.setChips(20)

    assertEquals(score.getChips, 20)
    assertEquals(score.getMultiplier, 5)
    assertEquals(score.totalScore, 100)

    score.setChips(0)

    assertEquals(score.getChips, 0)
    assertEquals(score.totalScore, 0)
  }

  test("setMultiplier should update multiplier value and recalculate totalScore") {
    val score = new Score(30, 2)
    assertEquals(score.totalScore, 60)

    score.setMultiplier(10)

    assertEquals(score.getMultiplier, 10)
    assertEquals(score.getChips, 30)
    assertEquals(score.totalScore, 300)

    score.setMultiplier(-3)

    assertEquals(score.getMultiplier, -3)
    assertEquals(score.totalScore, -90)
  }
}