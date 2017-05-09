package factory_method

case class ConcreteProduct() extends Product {

  val name = "Xbox"

  override def doSomething = println(s"Hello, you built an $name!")

}
