package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject {
  def subscribeObserver(observer: Observer) = subscribers += observer

  def unSubscribeObserver(observer: Observer) = subscribers.filter((keep: Observer) => keep != observer)

  def notifyObservers() = subscribers.foreach(_.update(subjectDetails))

  def subjectDetails: String = title
}
