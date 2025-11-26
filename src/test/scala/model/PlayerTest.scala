package model

import model.rank.Ace
import model.suit.Spade
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer


class PlayerTest extends FunSuite {
  
  val dummyHand: Hand = new Hand(ArrayBuffer.empty, ArrayBuffer.empty)


  test("A new Player should have a default totalScore of 0") {
    val player = new Player(hand = dummyHand)
    assert(player.totalScore == 0)
  }
  
  test("A new Player can be initialized with a specific starting score") {
    val player = new Player(hand = dummyHand, totalScore = 100)
    
    assert(player.totalScore == 100)
  }


  test("A new Player should hold the hand provided during construction") {
    val specificHand = new Hand(ArrayBuffer(new Card(new Ace, new Spade)), ArrayBuffer.empty)
    
    val player = new Player(hand = specificHand)
    
    assertEquals(player.hand, specificHand)
    assert(player.hand.getCards.nonEmpty)
  }
  
  test("The totalScore of a Player should be mutable") {
    val player = new Player(hand = dummyHand, totalScore = 50)
    
    assert(player.totalScore == 50)
    
    player.totalScore += 25
    
    assert(player.totalScore == 75)
  }
}