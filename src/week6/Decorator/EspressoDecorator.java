package week6.Decorator;

public abstract class EspressoDecorator implements Beverage{
	protected Beverage beverage; //감싸고 있는 음료 객체
	
	public EspressoDecorator(Beverage beverage) {
		this.beverage = beverage;
	}
}
