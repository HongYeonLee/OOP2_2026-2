package week6.CoffeeMaker2.payment;

public class CreditCard implements PaymentMethod{

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println(amount + "원을 카드로 결제합니다");
	}

}
