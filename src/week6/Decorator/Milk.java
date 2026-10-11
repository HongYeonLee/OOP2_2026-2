package week6.Decorator;

//ConcreteDecorator A: 우유 (+ 500원)
public class Milk extends EspressoDecorator{
	public Milk(Beverage beverage) {
		super(beverage);
		System.out.println("우유 스팀을 칩니다");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " + 우유";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return beverage.cost() + 500;
	}

}
