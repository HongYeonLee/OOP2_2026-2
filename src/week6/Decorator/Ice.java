package week6.Decorator;

//ConcreteDecorator C: 얼음 (+ 300원)
public class Ice extends EspressoDecorator {
	 public Ice(Beverage beverage) {
	     super(beverage);
	     System.out.println("얼음을 넣습니다");
	 }
	
	 @Override
	 public String getDescription() {
	     return beverage.getDescription() + " + 얼음";
	 }
	
	 @Override
	 public int cost() {
	     return beverage.cost() + 300;
	 }
}
