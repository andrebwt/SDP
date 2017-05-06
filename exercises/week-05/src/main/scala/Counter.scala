
class Counter(val count: Int) {

  def inc: Counter = new Counter(count + 1)

  def dec: Counter = new Counter(count - 1)

}