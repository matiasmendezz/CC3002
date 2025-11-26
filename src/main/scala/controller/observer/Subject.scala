package controller.observer

import controller.observer.Observer

/**
 * A trait for objects that can be observed.
 * It manages a list of observers and notifies them of changes.
 */
trait Subject {
  private var observers: List[Observer] = Nil

  /**
   * Registers a new observer.
   * @param observer The observer to add.
   */
  def addObserver(observer: Observer): Unit = {
    observers = observer :: observers
  }

  /**
   * Notifies all registered observers by calling their update() method.
   */
  def notifyObservers(): Unit = {
    observers.foreach(_.update())
  }
}