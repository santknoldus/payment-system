package kup.knoldus.PaymentSystem

object PaymentSystemApp extends App {
  private val paymentSystem = new PaymentSystem

  // Add a new credit card payment method
  private val creditCard = CreditCard("1234567890123456", "05/25", "123")
  paymentSystem.addPaymentMethod(creditCard)

  // Add a new paypal payment method
  private val payPal = PayPal("sant@example.com")
  paymentSystem.addPaymentMethod(payPal)

  // Add a new Internet Banking payment method
  private val netBanking = NetBanking("sant@112")
  paymentSystem.addPaymentMethod(netBanking)

  // Add a new UPI payment method
  private val upi = UPI("sant@upi")
  paymentSystem.addPaymentMethod(upi)

  // Process a payment
  paymentSystem.processPayment(creditCard, 100.0)
  paymentSystem.processPayment(upi, 50.0)
  paymentSystem.processPayment(payPal, 150.0)

  // List all payment methods
  val paymentMethods = paymentSystem.listPaymentMethods()
  println("Available payment methods:")
  paymentMethods.foreach(println)
}