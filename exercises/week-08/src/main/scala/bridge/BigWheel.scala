package bridge

// TODO

case class BigWheel(product: Product, s: String) extends Car(product, s) {
  override def assemble: Unit = ???

  override def produceProduct: Unit = ???

  override def printDetails: Unit = ???
}
