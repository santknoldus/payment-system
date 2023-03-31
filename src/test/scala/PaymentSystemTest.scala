package kup.knoldus.PaymentSystem

import org.scalatest.funsuite.AnyFunSuite

class PaymentSystemTest extends AnyFunSuite {

  test("addPaymentMethod should add a payment method to the list of payment methods") {
    val paymentSystem = new PaymentSystem()
    assert(paymentSystem.paymentMethods.isEmpty)

    val creditCard = CreditCard("1234567812345678", "12/24", "123")
    paymentSystem.addPaymentMethod(creditCard)
    assert(paymentSystem.paymentMethods == List(creditCard))

    val paypal = PayPal("user@example.com")
    paymentSystem.addPaymentMethod(paypal)
    assert(paymentSystem.paymentMethods == List(paypal, creditCard))
  }

  test("listPaymentMethods should return all added payment methods") {
    val paymentSystem = new PaymentSystem()
    val creditCard = CreditCard("1234567812345678", "12/24", "123")
    val paypal = PayPal("user@example.com")

    assert(paymentSystem.listPaymentMethods() == List())

    paymentSystem.addPaymentMethod(creditCard)
    assert(paymentSystem.listPaymentMethods() == List(creditCard))

    paymentSystem.addPaymentMethod(paypal)
    assert(paymentSystem.listPaymentMethods() == List(paypal, creditCard))
  }

  test("processPayment should succeed for an added payment method") {
    val paymentSystem = new PaymentSystem()
    val creditCard = CreditCard("1234567812345678", "12/24", "123")
    paymentSystem.addPaymentMethod(creditCard)

    val amount = 10.0
    assert(paymentSystem.processPayment(creditCard, amount) == s"Payment processed of amount $amount thru your ${creditCard.name}")
  }

  test("processPayment should fail for a non-added payment method") {
    val paymentSystem = new PaymentSystem()
    val creditCard = CreditCard("1234567812345678", "12/24", "123")

    val amount = 10.0
    assert(paymentSystem.processPayment(creditCard, amount) == "Payment failed")
  }
}
