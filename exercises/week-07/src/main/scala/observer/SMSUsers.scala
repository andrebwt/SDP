package observer

class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String) = println(desc)

  def subscribe() = s.subscribeObserver(this)

  def unSubscribe() = s.unSubscribeObserver(this)
}
