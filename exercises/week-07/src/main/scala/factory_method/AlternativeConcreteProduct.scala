package factory_method

case class AlternativeConcreteProduct() extends Product {

  val name = "Playstation"

  override def doSomething = println(s"Hello, you built a $name!")

}
