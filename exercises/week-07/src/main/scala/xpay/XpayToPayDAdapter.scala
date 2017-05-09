package xpay

// Client calls methods on XpayToPayDAdapter object
// Adapter translates them into calls on the
class XpayToPayDAdapter(xpayObj: Xpay) extends PayD {

  def getCustCardNo: String = xpayObj.getCreditCardNo

  def setCustCardNo(custCardNo: String) = ???

  def getCardOwnerName: String = ???

  def setCardOwnerName(cardOwnerName: String) = ???

  def getCardExpMonthDate: String = ???

  def setCardExpMonthDate(cardExpMonthDate: String) = ???

  def getCVVNo: Integer = ???

  def setCVVNo(cVVNo: Integer) = ???

  def getTotalAmount: Double = ???

  def setTotalAmount(totalAmount: Double) = ???

}
