package abstractfactory

case class NYCFactory() extends AbstractParserFactory {

  override def getParserInstance(parserType: String): XMLParser = parserType.toUpperCase match {

    case "NYCORDER" => NYCOrderXMLParser()
    case "NYCRESPONSE" => NYCResponseXMLParser()
    case "NYCFEEDBACK" => NYCFeedbackXMLParser()
    case "NYCERROR" => NYCErrorXMLParser()


  }

}
