package week6.Decorator;

public class Espresso implements Beverage{
	public Espresso() {
		System.out.println("에소프레소를 추출합니다");
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "에소프레소";
	}

	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 1000;
	}

}
