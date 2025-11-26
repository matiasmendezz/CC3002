package controller.observer

/**
 * A trait for objects that need to be notified of changes from a Subject.
 */
trait Observer {
  /**
   * Called by the Subject to notify of a state change.
   */
  def update(): Unit
}

