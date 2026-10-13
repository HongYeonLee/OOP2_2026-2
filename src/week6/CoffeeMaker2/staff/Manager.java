package week6.CoffeeMaker2.staff;

import week6.CoffeeMaker2.menu.Menu;
import week6.CoffeeMaker2.payment.PaymentMethod;
import week6.CoffeeMaker2.recipes.CoffeeRecipe;

public class Manager {
	private Menu menu;
	private Barista brista;
	
	//생성자 주입
	public Manager(Menu menu, Barista brista) {
		this.menu = menu;
		this.brista = brista;
	}
	
	//주문 받기 (결제하기, 바리스타에게 제조 요청)
	public void takeOrder (String name, PaymentMethod paymentMethod) {
		//주문받은 커피가 메뉴에 있는지 확인
		if (!menu.hasMenu(name)) {
			System.out.println(name + " 메뉴는 없습니다");
			return;
		}
		
		int price = menu.getPrice(name); // 메뉴 이름으로 가격 가져오기
		CoffeeRecipe coffee = menu.findReciepe(name); // 커피레시피 가져오기
		brista.serve(coffee); // 바리스타에게 제조 맡기기
		System.out.println(name + " 나왔습니다!");
		paymentMethod.pay(price); // 결제하기
		System.out.println("==========================");
	}
}
