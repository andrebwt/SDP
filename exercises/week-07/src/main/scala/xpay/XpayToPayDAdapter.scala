package xpay

// Client calls methods on XpayToPayDAdapter object
// Adapter translates them into calls on the Xpayimpl
class XpayToPayDAdapter(xpayObj: Xpay) extends PayD {

  def getCustCardNo: String = xpayObj.getCreditCardNo

  def setCustCardNo(custCardNo: String) = xpayObj.setCreditCardNo(custCardNo)

  def getCardOwnerName: String = xpayObj.getCustomerName

  def setCardOwnerName(cardOwnerName: String) = xpayObj.setCustomerName(cardOwnerName)

  def getCardExpMonthDate: String = xpayObj.getCardExpMonth

  def setCardExpMonthDate(cardExpMonthDate: String) = xpayObj.setCardExpMonth(cardExpMonthDate)

  def getCVVNo: Integer = xpayObj.getCardCVVNo.toInt

  def setCVVNo(cVVNo: Integer) = xpayObj.setCardCVVNo(cVVNo.toShort)

  def getTotalAmount: Double = xpayObj.getAmount

  def setTotalAmount(totalAmount: Double) = xpayObj.setAmount(totalAmount)

}
