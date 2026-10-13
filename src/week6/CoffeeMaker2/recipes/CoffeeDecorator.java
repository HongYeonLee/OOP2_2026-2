package week6.CoffeeMaker2.recipes;

public abstract class CoffeeDecorator implements CoffeeRecipe{
	protected CoffeeRecipe coffee;
	
	public CoffeeDecorator(CoffeeRecipe coffee) {
		this.coffee = coffee;
	}
}
