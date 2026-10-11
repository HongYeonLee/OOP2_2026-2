package week6.Decorator;

//ConcreteDecorator B: 바닐라 시럽 (+ 500원)
public class VanillaSyrup extends EspressoDecorator {
	 public VanillaSyrup(Beverage beverage) {
	     super(beverage);
	     System.out.println("바닐라 시럽을 넣습니다");
	 }
	
	 @Override
	 public String getDescription() {
	     return beverage.getDescription() + " + 바닐라 시럽";
	 }
	
	 @Override
	 public int cost() {
	     return beverage.cost() + 500;
	 }
}
