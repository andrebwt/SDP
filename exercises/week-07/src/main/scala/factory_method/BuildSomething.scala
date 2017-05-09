package factory_method


object BuildSomething extends App {

  val testProduct = ConcreteCreator.build("xbox")
  val testAlternative = ConcreteCreator.build("playstation")

  testProduct.doSomething
  testAlternative.doSomething

}
