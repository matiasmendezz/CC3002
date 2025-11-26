package exceptions

import scala.collection.mutable.ArrayBuffer

/**
 * Base exception for Hand class-related errors.
 */
class HandException(message: String) extends RuntimeException(message)

/**
 * Thrown when attempting to add a card to a hand that already has the maximum number of cards (8).
 * @param currentCards The current number of cards in the hand.
 */
class MaxCardsExceededException(val currentCards: Int)
  extends HandException(s"Cannot add card. Hand already has $currentCards cards, max 8.")

/**
 * Thrown when attempting to add a joker to a hand that already has the maximum number of jokers (2).
 * @param currentJokers The current number of jokers in the hand.
 */
class MaxJokersExceededException(val currentJokers: Int)
  extends HandException(s"Cannot add joker. Hand already has $currentJokers jokers, max 2.")

/**
 * Thrown when attempting to remove a card with an invalid index.
 * @param index The invalid index.
 * @param handSize The current size of the hand (number of cards).
 */
class InvalidCardIndexException(val index: Int, val handSize: Int)
  extends HandException(s"Invalid card index: $index. Hand size is $handSize.")

/**
 * Thrown when attempting to access or remove a joker with an invalid index.
 * @param index The invalid index.
 * @param jokerCount The current number of jokers.
 */
class InvalidJokerIndexException(val index: Int, val jokerCount: Int)
  extends HandException(s"Invalid joker index: $index. Joker count is $jokerCount.")

/**
 * Thrown when attempting to play a set of cards more times than allowed (3).
 * @param playsAttempted The number of plays already made (not counting the current one).
 */
class MaxPlaysExceededException(val playsAttempted: Int)
  extends HandException(s"Cannot play cards. Maximum number of plays (3) exceeded. Attempted: ${playsAttempted + 1}.")

/**
 * Thrown when attempting to discard cards more times than allowed (3).
 * @param discardsAttempted The number of discards already made (not counting the current one).
 */
class MaxDiscardsExceededException(val discardsAttempted: Int)
  extends HandException(s"Cannot discard cards. Maximum number of discards (3) exceeded. Attempted: ${discardsAttempted + 1}.")

/**
 * Thrown when attempting to play a number of cards outside the allowed range (1-5).
 * @param count The number of cards attempted to play.
 */
class InvalidPlayCountException(val count: Int)
  extends HandException(s"Invalid number of cards to play: $count. Must be between 1 and 5.")

/**
 * Thrown when attempting to discard a number of cards outside the allowed range (1-5).
 * @param count The number of cards attempted to discard.
 */
class InvalidDiscardCountException(val count: Int)
  extends HandException(s"Invalid number of cards to discard: $count. Must be between 1 and 5.")

/**
 * Thrown when attempting to play cards using a list of indexes that contains one or more invalid indices.
 * @param invalidIndexes The indices that are out of range or incorrect.
 * @param handSize The current size of the hand (number of cards).
 */
class InvalidIndexesForPlayException(val invalidIndexes: ArrayBuffer[Int], val handSize: Int)
  extends HandException(s"Invalid indices provided for playing cards: ${invalidIndexes.mkString(", ")}. Hand size is $handSize.")

/**
 * Thrown when attempting to discard cards using a list of indices that contains one or more invalid indices.
 * @param invalidIndexes The indices that are out of range or incorrect.
 * @param handSize The current size of the hand (number of cards).
 */
class InvalidIndexesForDiscardException(val invalidIndexes: ArrayBuffer[Int], val handSize: Int)
  extends HandException(s"Invalid indices provided for discarding cards: ${invalidIndexes.mkString(", ")}. Hand size is $handSize.")

