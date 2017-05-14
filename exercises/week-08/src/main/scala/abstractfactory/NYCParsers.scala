package abstractfactory

case class NYCOrderXMLParser() extends XMLParser {
  override def parse: String = "NYC Parsing Order XML...\nNYC Order XML Message"
}

case class NYCResponseXMLParser() extends XMLParser {
  override def parse: String = "NYC Parsing Response XML...\nNYC Response XML Message"
}

case class NYCFeedbackXMLParser() extends XMLParser {
  override def parse: String = "NYC Parsing Feedback XML...\nNYC Feedback XML Message"
}

case class NYCErrorXMLParser() extends XMLParser {
  override def parse: String = "NYC Parsing Error XML...\nNYC Error XML Message"
}