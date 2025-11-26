package model
import model.joker.Joker
import model.rank.*
import model.suit.*

import scala.collection.mutable.ArrayBuffer
/**
 * Represents a standard card with a rank and suit.
 *
 * A Card is an immutable entity in the Balatro game that combines
 * a rank (such as numeric values 2-10, face cards, or Ace) with
 * a suit (Clubs, Diamonds, Hearts, or Spades).
 *
 * @param _rank the rank of the card (e.g., 2, 3, Jack, Queen, King, Ace)
 * @param _suit the suit of the card (Clubs, Diamonds, Hearts, or Spades)
 *
 */
class Card(var _rank: Rank, var _suit: Suit) {
  /** Returns the current rank of the card. */
  def getRank: Rank = {
    _rank
  }

  /** Updates the rank of the card.
   *
   * @param newRank the new rank to assign
   */
  def setRank(newRank: Rank): Unit = {
    _rank = newRank
  }

  /** Returns the current suit of the card. */
  def getSuit: Suit = {
    _suit
  }

  /** Updates the suit of the card.
   *
   * @param newSuit the new suit to assign
   */
  def setSuit(newSuit: Suit): Unit = {
    _suit = newSuit
  }
  
  override def toString: String = s"${_rank.getName} of ${_suit.getName}"

  /**
   * Calculates the updated score after applying the effects of a list of Jokers
   * to the card.
   *
   * This method  iterates through each Joker in the provided list and applies
   * its effects based on this card's own rank and suit.
   *
   *
   * @param score The score before the jokers effects are considered.
   * @param jokers       A list of Jokers.
   * @return A new `Score` object with Joker effects applied for this card.
   */
  def applyScore(score: Score, jokers: ArrayBuffer[Joker]): Score = {
    var currentScore = score

    for (joker <- jokers) {
      currentScore = this.getRank.applyScore(currentScore, joker)
      currentScore = this.getSuit.applyScore(currentScore, joker)
    }
    // Return the final score
    currentScore
  }

  /**
   * Overrides the default equals method to compare cards by value.
   * Two cards are considered equal if they have the same rank and suit.
   */
  override def equals(obj: Any): Boolean = {
    obj match {
      case that: Card =>
        this.getRank == that.getRank && this.getSuit == that.getSuit
      case _ => false
    }
  }

  /**
   * Overrides the default hashCode method.
   */
  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    result = prime * result + (if (getRank == null) 0 else getRank.hashCode())
    result = prime * result + (if (getSuit == null) 0 else getSuit.hashCode())
    result
  }


}