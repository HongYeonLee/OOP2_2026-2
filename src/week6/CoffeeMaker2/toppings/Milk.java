package week6.CoffeeMaker2.toppings;

import week6.CoffeeMaker2.machines.MilkFrother;
import week6.CoffeeMaker2.recipes.CoffeeDecorator;
import week6.CoffeeMaker2.recipes.CoffeeRecipe;

public class Milk extends CoffeeDecorator{
	private final MilkFrother milkFrother;
	
	// 부모 생성자에 대신 주입
	public Milk(CoffeeRecipe base, MilkFrother milkFrother) {
		super(base);
		this.milkFrother = milkFrother;
	}

	@Override
	public String prepare() {
		// 부모 필드 이용
		return coffee.prepare() + milkFrother.frothMilk();
	}

}
