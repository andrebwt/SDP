package abstractfactory

case class NYCFactory() extends AbstractParserFactory {

  override def getParserInstance(parserType: String): XMLParser = parserType.toUpperCase match {

    case "NYCORDER" => LondonOrderXMLParser()
    case "NYCRESPONSE" => LondonResponseXMLParser()
    case "NYCFEEDBACK" => LondonFeedbackXMLParser()
    case "NYCERROR" => LondonErrorXMLParser()


  }

}
