package abstractfactory


case class LondonFactory() extends AbstractParserFactory {

  override def getParserInstance(parserType: String): XMLParser = parserType.toUpperCase() match {

    case "LONDONORDER" => LondonOrderXMLParser()
    case "LONDONRESPONSE" => LondonResponseXMLParser()
    case "LONDONFEEDBACK" => LondonFeedbackXMLParser()
    case "LONDONERROR" => LondonErrorXMLParser()
  }
}
