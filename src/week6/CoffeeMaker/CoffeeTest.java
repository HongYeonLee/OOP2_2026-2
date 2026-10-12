package week6.CoffeeMaker;

public class CoffeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 머신과 거품기 생성
		CoffeeMachine espressoMachine = new EspressoMachine();
		CoffeeMachine dripCoffeeMachine = new DripCoffeeMachine();
		MilkFrother milkFrother = new MilkFrother();
		
		// 테스트 메뉴로 에소프레소 준비 생성
		Coffee espresso = new Espresso(espressoMachine);
		System.out.println(espresso.prepare());
		
		// 라떼 생성
		Coffee latte = new Latte(espresso, milkFrother);
		System.out.println(latte.prepare());
		
		// IoC와 DI를 적용하여 라떼 만들기
		CoffeeMaker coffeeMaker = new CoffeeMaker(); // 커피에게 커피를 만들라고 지시할 역할
		coffeeMaker.setCoffee(new Latte(espresso, milkFrother)); // 만들 커피 지정
		coffeeMaker.makeCoffee(); // 커피메이커야 커피 만들어줘 -> 커피메이커: 커피야 커피 만들어 -> 커피: 만들어짐
		
		// 1. 드립머신으로 아메리카노 만들기
		coffeeMaker.setCoffee(new Americano(dripCoffeeMachine));
		coffeeMaker.makeCoffee();
		
		
		// 2. 새로운 메뉴 추가하기
		coffeeMaker.setCoffee(new VanillaLatte(new Latte(espresso, milkFrother))); //만들 커피 지정
		coffeeMaker.makeCoffee();
		
	}

}
