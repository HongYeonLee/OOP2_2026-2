package week6.CoffeeMaker2.menu;

import java.util.LinkedHashMap;
import java.util.Map;

import week6.CoffeeMaker2.recipes.CoffeeRecipe;

public class Menu {
	//컬렉션을 이용한 메뉴 이름과 가격 저장
	private Map<String, Integer> prices = new LinkedHashMap<>();
	//컬렉션을 이용한 메뉴 이름과 레피시(객체) 저장
	private Map<String, CoffeeRecipe> recipes = new LinkedHashMap<>();
	
	//새로운 메뉴 추가
	public void addMenu(String name, int price, CoffeeRecipe coffeeRecipe) {
		prices.put(name, price);
		recipes.put(name, coffeeRecipe);
	}
	
	public boolean hasMenu(String name) {
		return recipes.containsKey(name);
	}
	
	public int getPrice(String name) {
		return prices.get(name);
	}
	
	public CoffeeRecipe findReciepe(String name) {
		return recipes.get(name);
	}
	
}
