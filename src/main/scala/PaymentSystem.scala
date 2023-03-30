package kup.knoldus.PaymentSystem

sealed trait PaymentMethod {
  val name: String
}

case class CreditCard(number: String, expiry: String, cvv: String) extends PaymentMethod {
  override val name: String = "Credit Card"
}

case class PayPal(email: String) extends PaymentMethod {
  override val name: String = "PayPal"
}

case class NetBanking(userID: String) extends PaymentMethod {
  override val name: String = "Internet Banking"
}

case class UPI(virtualPaymentAddress: String) extends PaymentMethod {
  override val name: String = "UPI"
}

class PaymentSystem {
  var paymentMethods: List[PaymentMethod] = List()

  // to add payment method in the list of payment method
  def addPaymentMethod(paymentMethod: PaymentMethod): Unit = {
    paymentMethods = paymentMethod :: paymentMethods
  }

  // to display all payment methods available
  def listPaymentMethods(): List[PaymentMethod] = paymentMethods

  // to process payment
  def processPayment(paymentMethod: PaymentMethod, amount: Double): Unit = {
    if (paymentMethods.contains(paymentMethod))
      println(s"Payment processed of amount $amount thru your ${paymentMethod.name}")
    else println("Payment failed")
  }
}