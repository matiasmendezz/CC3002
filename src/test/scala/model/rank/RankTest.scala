package model.rank

import munit.FunSuite
import model.Score
import model.joker.{EvenSteven, Joker, ScaryFace}
import model.rank.ranktype.*

class RankTest extends FunSuite {

  val testKing: King = new King()
  val testFour: Four = new Four()
  val testThree: Three = new Three()


  val scaryFaceJoker = new ScaryFace()
  val evenStevenJoker = new EvenSteven()




  test("Rank getters should return correct properties") {
    assertEquals(testKing.getName, "King")
    assertEquals(testKing.getValue, 10)
    assert(testKing.getRankType.isInstanceOf[Face])
    assertEquals(testKing.toString, "King")
  }



  test("applyScore should call ScaryFace Joker for a 'Face' rank") {
    val initialScore = new Score(10, 2)
    val finalScore = testKing.applyScore(initialScore, scaryFaceJoker)

    assertEquals(finalScore.getChips, 10 + 30, "Chips should increase by 30")
    assertEquals(finalScore.getMultiplier, 2, "Multiplier should be unchanged")
  }

  test("applyScore should call EvenSteven Joker for an 'Even' rank") {
    val initialScore = new Score(10, 2)
    val finalScore = testFour.applyScore(initialScore, evenStevenJoker)
    assertEquals(finalScore.getChips, 10, "Chips should be unchanged")
    assertEquals(finalScore.getMultiplier, 2 + 4, "Multiplier should increase by 4")
  }

  test("applyScore should NOT call any Joker for an 'Odd' rank (testing the 'else' branch)") {
    val initialScore = new Score(50, 5)
    val finalScore = testThree.applyScore(initialScore, scaryFaceJoker)

    assertEquals(finalScore.getChips, initialScore.getChips, "Chips must remain unchanged for an Odd rank")
    assertEquals(finalScore.getMultiplier, initialScore.getMultiplier, "Multiplier must remain unchanged for an Odd rank")
  }
}