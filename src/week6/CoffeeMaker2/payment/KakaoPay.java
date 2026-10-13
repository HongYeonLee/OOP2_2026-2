package week6.CoffeeMaker2.payment;

public class KakaoPay implements PaymentMethod{

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println(amount + "원을 카카오페이로 결제합니다");
	}

}
