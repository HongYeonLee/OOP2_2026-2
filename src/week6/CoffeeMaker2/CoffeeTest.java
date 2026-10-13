package week6.CoffeeMaker2;

import week6.CoffeeMaker2.payment.CreditCard;
import week6.CoffeeMaker2.payment.KakaoPay;
import week6.CoffeeMaker2.payment.PaymentMethod;
import week6.CoffeeMaker2.staff.Manager;

public class CoffeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager = Cafe.open();
		PaymentMethod card = new CreditCard();
		PaymentMethod kakaopay = new KakaoPay();
		
		//에스프레소 주문, 카드 사용
		manager.takeOrder("에스프레소", card);
		//드립 커피 주문, 카카오페이
		manager.takeOrder("드립커피", kakaopay);
		//라떼 주문, 카드 사용
		manager.takeOrder("라떼", card);
		//아메리카노 주문, 카카오페이
		manager.takeOrder("아메리카노", kakaopay);
		//바닐라 라떼 주문, 카카오페이
		manager.takeOrder("바닐라 라떼", kakaopay);
		//아이스 바닐라 라떼 주문, 카드
		manager.takeOrder("아이스 바닐라 라떼", card);
		//없는 메뉴 주문하기
		manager.takeOrder("녹차 라떼", card);
		
	}

}
