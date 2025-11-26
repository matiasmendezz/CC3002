package model

import controller.observer.Subject
import exceptions.*
import model.Card
import model.combination.{PokerCombination, StraightFlush}
import model.evaluation.HandEvaluator
import model.joker.Joker

import scala.collection.mutable.ArrayBuffer

/** A class representing a player's hand in the card game.
 *
 * Each player has a hand composed of up to 8 cards and 2 jokers. The hand is the
 * core component that players use to interact with the game, allowing them to play
 * and discard cards.
 *
 * Game rules specify that a player can play a set of cards 3 times and discard 3 times.
 * Both actions must involve between 1 and 5 cards per action.
 *
 * @param _cards The collection of cards in the player's hand (maximum 8)
 * @param _jokers The joker cards affecting the player's hand (maximum 2)
 */
class Hand(var _cards: ArrayBuffer[Card],
           var _jokers: ArrayBuffer[Joker]) extends Subject {
  private val evaluator = new HandEvaluator
  //counter for plays made
  private var playsCount = 0
  // Counter for discards made
  private var discardsCount = 0

  /** Adds a single card to the hand.
   *
   * @param card The card to be added to the hand
   * @throws MaxCardsExceededException if the hand already has 8 cards
   */
  def addCard(card: Card): Unit = {
    if (_cards.size >= 8) {
      throw new MaxCardsExceededException(_cards.size)
    }
    _cards += card
  }

  /** Removes and returns a card from the hand at the specified index.
   *
   * @param index The index of the card to remove
   * @return The removed card
   * @throws InvalidCardIndexException if the index is out of bounds
   */
  def removeCardByIndex(index: Int): Card = {
    if (index < 0 || index >= _cards.size) {
      throw new InvalidCardIndexException(index, _cards.size)
    }
    _cards.remove(index)
  }

  /** Adds a single joker to the hand.
   *
   * @param joker The joker to be added to the hand
   * @throws MaxJokersExceededException if the hand already has 2 jokers
   */
  def addJoker(joker: Joker): Unit = {
    if (_jokers.size >= 2) {
      throw new MaxJokersExceededException(_jokers.size)
    }
    _jokers += joker
  }

  /** Removes and returns a joker from the hand at the specified index.
   *
   * @param index The index of the joker to remove
   * @return The removed joker
   * @throws InvalidJokerIndexException if the index is out of bounds
   */
  def removeJokerByIndex(index: Int): Joker = {
    if (index < 0 || index >= _jokers.size) {
      throw new InvalidJokerIndexException(index, _jokers.size)
    }
    _jokers.remove(index)
  }


  /** Plays a hand by removing cards at the specified indices.
   *
   * @param cardIndexes The list of indices of cards to be played from the hand
   * @return The list of cards that were played (removed from the hand)
   * @throws MaxPlaysExceededException if already played 3 times
   * @throws InvalidPlayCountException if attempting to play more than 5 cards or less than 1 card
   * @throws InvalidIndicesForPlayException if any index is out of range
   */
  def playHand(cardIndexes: ArrayBuffer[Int]): ArrayBuffer[Card] = {
    if (playsCount >= 3) {
      throw new MaxPlaysExceededException(playsCount)
    }
    if (cardIndexes.size > 5 || cardIndexes.size < 1) {
      throw new InvalidPlayCountException(cardIndexes.size)
    }

    val invalidIndexes = cardIndexes.filter(i => i < 0 || i >= _cards.size)
    if (invalidIndexes.nonEmpty) {
      throw new InvalidIndexesForPlayException(invalidIndexes, _cards.size)
    }

    // Use discardHand to remove the cards
    val playedCards = discardHand(cardIndexes)
    playsCount += 1

    if (playsCount >= 3) {
      notifyObservers()
    }
    playedCards
  }

  /** Discards cards from the hand at the specified indices.
   *
   * @param cardIndexes The list of indices of cards to be discarded
   * @return The list of cards that were discarded
   * @throws MaxDiscardsExceededException if already discarded 3 times
   * @throws InvalidDiscardCountException if attempting to discard more than 5 cards or less than 1 card
   * @throws InvalidIndicesForDiscardException if any index is out of range
   */
  def discardHand(cardIndexes: ArrayBuffer[Int]): ArrayBuffer[Card] = {
    // Check if already discarded 3 times
    if (discardsCount >= 3) {
      throw new MaxDiscardsExceededException(discardsCount)
    }

    if (cardIndexes.size > 5 || cardIndexes.size < 1) {
      throw new InvalidDiscardCountException(cardIndexes.size)
    }

    val invalidIndexes = cardIndexes.filter(i => i < 0 || i >= _cards.size)
    if (invalidIndexes.nonEmpty) {
      throw new InvalidIndexesForDiscardException(invalidIndexes, _cards.size)
    }


    val discardedCards = ArrayBuffer[Card]()
    for (i <- cardIndexes.indices.reverse) {
      val index = cardIndexes(i)
      discardedCards += _cards.remove(index)
    }

    discardsCount += 1
    discardedCards
  }


  /** Returns the cards in the hand. */
  def getCards: ArrayBuffer[Card] = {
    _cards
  }

  /** Updates the cards in the hand.
   *
   * @param newCards The new set of cards.
   * @throws MaxCardsExceededException if attempting to set more than 8 cards
   */
  def setCards(newCards: ArrayBuffer[Card]): Unit = {
    if (newCards.size > 8) {
      throw new MaxCardsExceededException(newCards.size)
    }
    _cards = newCards
  }

  /** Returns the jokers in the hand. */
  def getJokers: ArrayBuffer[Joker] = {
    _jokers
  }

  /** Updates the jokers in the hand.
   *
   * @param newJokers The new set of jokers.
   * @throws MaxJokersExceededException if attempting to set more than 2 jokers
   */
  def setJokers(newJokers: ArrayBuffer[Joker]): Unit = {
    if (newJokers.size > 2) {
      throw new MaxJokersExceededException(newJokers.size)
    }
    _jokers = newJokers
  }

  /** Returns the number of plays remaining. */
  def getPlaysLeft: Int = 3 - playsCount

  /** Returns the number of discards remaining. */
  def getDiscardsLeft: Int = 3 - discardsCount

  /**
   * Determines the best poker combination for a given set of cards
   * by delegating the task to the HandEvaluator.
   *
   * @param cards The cards that were played.
   * @return The best PokerCombination that the cards form.
   */
  def bestMatch(cards: ArrayBuffer[Card]): PokerCombination = {
    evaluator.findBestCombination(cards)
  }

  def applyScoreHand(playedCards: ArrayBuffer[Card]): Score = {
    // Score system
    // 1. Find the best valid poker combination using the correct evaluator.
    val bestPokerCombination = this.bestMatch(playedCards)
    //2. Set the new chips and multipliers with the poker combination's effect
    var newChips = bestPokerCombination.getChips
    var newMultipliers = bestPokerCombination.getMultiplier
    //3. Set a temporal Score
    var tempScore = new Score(newChips, newMultipliers)
    // 4. Apply the joker's effect on the poker combination
    for (joker <- this.getJokers){
      tempScore = joker.applyScorePokerCombination(tempScore, bestPokerCombination)
    }
    // 5. Apply the joker/s effect on every card and add the chip's card value
    for (card <- playedCards){
      tempScore .setChips(tempScore.getChips+card.getRank.getValue)
      tempScore = card.applyScore(tempScore, this.getJokers)
    }
    
    tempScore

  }

}

