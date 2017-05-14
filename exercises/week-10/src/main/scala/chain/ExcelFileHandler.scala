package chain

case class ExcelFileHandler(s: String) extends Handler {
  override def setHandler(handler: Handler): Unit = ???

  override def process(file: File): Unit = ???

  override def getHandlerName(): String = ???
}
