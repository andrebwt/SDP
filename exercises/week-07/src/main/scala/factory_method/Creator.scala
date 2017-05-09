package factory_method

abstract class Creator {

  def build(productType: String): Product

}
