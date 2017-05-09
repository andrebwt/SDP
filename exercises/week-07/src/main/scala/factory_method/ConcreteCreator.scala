package factory_method

object ConcreteCreator extends Creator {

  override def build(productType: String): Product = productType match {
    case "xbox" => ConcreteProduct()
    case "playstation" => AlternativeConcreteProduct()
    case _ => null
  }
}