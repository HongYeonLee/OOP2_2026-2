package week6.Decorator;

public class BeverageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. 에소프레소
		Beverage espresso = new Espresso(); //팩토리 메소드 패턴과 결합 가능
		System.out.println(espresso.getDescription() + " | 가격: " + espresso.cost() + "원\n");
		
		//2. 라떼 (에소프레소 + 우유)
		Beverage latte = new Milk(new Espresso());
		System.out.println(latte.getDescription() + " | 가격: " + latte.cost() + "원\n");
		
		//3. 바닐라 라떼 (에스프레소 + 우유 + 바닐라 시럽)
        Beverage vanillaLatte = new VanillaSyrup(new Milk(new Espresso()));
        System.out.println(vanillaLatte.getDescription() + " | 가격: " + vanillaLatte.cost() + "원\n");

        //4. 아이스 바닐라 라떼 (에스프레소 + 우유 + 바닐라 시럽 + 얼음)
        Beverage iceVanillaLatte = new Ice(new VanillaSyrup(new Milk(new Espresso())));
        System.out.println(iceVanillaLatte.getDescription() + " | 가격: " + iceVanillaLatte.cost() + "원\n");
        
        //5. 아이스 바닐라 초코 라떼 (에소프레소 + 우유 + 초코 시럽 + 얼음)
        Beverage iceVanillaChocoLatte = new Ice(new ChocoSyrup(new VanillaSyrup(new Milk(new Espresso()))));
        System.out.println(iceVanillaChocoLatte.getDescription() + " | 가격: " + iceVanillaChocoLatte.cost() + "원\n");
        
	}

}
