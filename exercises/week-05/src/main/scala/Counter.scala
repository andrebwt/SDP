
class Counter(val count: Int) {

  def inc(n: Int = 1) : Counter = new Counter(count + n)

  def dec(n: Int = 1) : Counter = new Counter(count - n)

}
