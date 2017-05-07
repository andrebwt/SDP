package counters

case class CaseCounter(count: Int = 0) {

  // now using copy method to get an instance of the class
  def inc(n: Int = 1) : CaseCounter = this.copy(count + n)

  def dec(n: Int = 1) : CaseCounter = this.copy(count - n)

  def adjust(added: Adder) : CaseCounter = this.copy(added.add(count))

}
