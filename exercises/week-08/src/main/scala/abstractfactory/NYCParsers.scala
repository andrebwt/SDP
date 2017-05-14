package abstractfactory

case class NYCOrderXMLParser() extends XMLParser {
  override def parse: String = "NYC Parsing Order XML..."
}

case class NYCResponseXMLParser() extends XMLParser {
  override def parse: String = "NYC Response XML Message"
}

case class NYCFeedbackXMLParser() extends XMLParser {
  override def parse: String = "NYC Feedback XML Message"
}

case class NYCErrorXMLParser() extends XMLParser {
  override def parse: String = "NYC Error XML Message"
}