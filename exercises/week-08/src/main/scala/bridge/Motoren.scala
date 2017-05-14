package bridge

case class Motoren(product: Product, s: String) extends Car(product, s) {

  val pName = product.productName

  override def assemble: Unit = println(s"Assembling $pName for $s")

  override def produceProduct: Unit = {

    product.produce
    println(s"Modifying product $pName according to $s")
  }

  override def printDetails: Unit = println(s"Car: $s, Product: $pName")
}
