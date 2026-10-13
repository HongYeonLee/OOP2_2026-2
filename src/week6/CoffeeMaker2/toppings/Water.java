package week6.CoffeeMaker2.toppings;

import week6.CoffeeMaker2.recipes.CoffeeDecorator;
import week6.CoffeeMaker2.recipes.CoffeeRecipe;

public class Water extends CoffeeDecorator{

	public Water(CoffeeRecipe coffee) {
		super(coffee);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String prepare() {
		// TODO Auto-generated method stub
		return coffee.prepare() + " + 물 추가";
	}

}
