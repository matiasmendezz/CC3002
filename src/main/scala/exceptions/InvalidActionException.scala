package exceptions

/**
 * A custom exception thrown when an action is attempted in a game state
 * where that action is not permitted.
 *
 *
 * @param message A descriptive message explaining why the action was invalid.
 */
class InvalidActionException(message: String) extends Exception(message)