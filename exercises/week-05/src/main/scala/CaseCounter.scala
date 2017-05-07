
case class CaseCounter(count: Int = 0) {

  def inc(n: Int = 1) : CaseCounter = new CaseCounter(count + n)

  def dec(n: Int = 1) : CaseCounter = new CaseCounter(count - n)

}
