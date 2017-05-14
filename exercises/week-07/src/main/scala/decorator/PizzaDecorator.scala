package decorator

abstract class PizzaDecorator(pizza: Pizza) extends Pizza {

  def getDesc: String = pizza.getDesc

  def getPrice: Double = pizza.getPrice

}