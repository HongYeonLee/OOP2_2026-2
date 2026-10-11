package week6.Decorator;

//ConcreteDecorator D: 초코 시럽 (+ 500원)
public class ChocoSyrup extends EspressoDecorator {
	 public ChocoSyrup(Beverage beverage) {
	     super(beverage);
	     System.out.println("초코 시럽을 넣습니다");
	 }
	
	 @Override
	 public String getDescription() {
	     return beverage.getDescription() + " + 초코 시럽";
	 }
	
	 @Override
	 public int cost() {
	     return beverage.cost() + 500;
	 }
}
