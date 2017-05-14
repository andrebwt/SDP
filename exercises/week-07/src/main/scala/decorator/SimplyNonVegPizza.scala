package decorator

class SimplyNonVegPizza extends Pizza {

  def getDesc: String = this.getClass.getName.drop(10) + " (" + this.getPrice.toString + ") "

  def getPrice: Double = 350
}
