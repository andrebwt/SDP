package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator(pizza: Pizza) {

  override def getDesc: String = this.getClass.getName.drop(10) + " (" + this.getPrice.toString + ") "

  override def getPrice: Double = 20.72
}
