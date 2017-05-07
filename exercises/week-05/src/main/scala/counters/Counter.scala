package counters

class Counter(val count: Int) {

  def inc(n: Int = 1) : Counter = new Counter(count + n)

  def dec(n: Int = 1) : Counter = new Counter(count - n)

  def adjust(added: Adder) : Counter = new Counter(added.add(count))

}
