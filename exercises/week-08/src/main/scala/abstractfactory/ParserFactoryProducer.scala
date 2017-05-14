package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String): AbstractParserFactory = s match {

    case "LondonFactory" => LondonFactory()
    case "NYCFactory" => NYCFactory()
    case _ => throw new Exception(s"Error: $s is and invalid factory name.")
  }
}
