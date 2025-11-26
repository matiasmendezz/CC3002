package model

import model.Hand

/**
 * Represents a player in the Malatro game.
 * This class holds the player's hand (containing cards and jokers) and their
 * cumulative score throughout the game.
 *
 * @param hand The player's Hand object. It manages the player's cards, jokers,
 *             and actions like playing or discarding.
 * @param totalScore The player's current total score, which is updated after
 *                   each hand is played. Defaults to 0.
 */
class Player(val hand: Hand, var totalScore: Int = 0)