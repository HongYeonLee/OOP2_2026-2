package week6.CoffeeMaker2;

import week6.CoffeeMaker2.machines.CoffeeMachine;
import week6.CoffeeMaker2.machines.DripCoffeeMachine;
import week6.CoffeeMaker2.machines.EspressoMachine;
import week6.CoffeeMaker2.machines.MilkFrother;
import week6.CoffeeMaker2.machines.SteamFrother;
import week6.CoffeeMaker2.menu.Menu;
import week6.CoffeeMaker2.recipes.CoffeeRecipe;
import week6.CoffeeMaker2.recipes.DripCoffeeRecipe;
import week6.CoffeeMaker2.recipes.EspressoRecipe;
import week6.CoffeeMaker2.staff.Barista;
import week6.CoffeeMaker2.staff.Manager;
import week6.CoffeeMaker2.toppings.Ice;
import week6.CoffeeMaker2.toppings.Milk;
import week6.CoffeeMaker2.toppings.VanillaSyrup;
import week6.CoffeeMaker2.toppings.Water;

public class Cafe {
	
	public static Manager open() {	
		//1. 커미머신 설정
		CoffeeMachine espressoMachine = new EspressoMachine();
		CoffeeMachine dripCoffeeMachine = new DripCoffeeMachine();
		MilkFrother milkFrother = new SteamFrother();
		
		//2. 메뉴판 설정
		Menu menu = createMenu(espressoMachine, dripCoffeeMachine, milkFrother);
		
		//3. 직원 설정
		return new Manager(menu, new Barista());
		
	}
	
	private static Menu createMenu(CoffeeMachine espressoMachine, CoffeeMachine dripCoffeeMachine, MilkFrother milkFrother) {
        CoffeeRecipe espresso = new EspressoRecipe(espressoMachine);
        CoffeeRecipe dripCoffe = new DripCoffeeRecipe(dripCoffeeMachine);
        
        //데코레이터 패턴 적용
        CoffeeRecipe americano = new Water(espresso);
        CoffeeRecipe icedAmericano = new Ice(americano);
        CoffeeRecipe latte = new Milk(espresso, milkFrother);
        CoffeeRecipe vanillaLatte = new VanillaSyrup(latte);
        CoffeeRecipe icedVanillaLatte = new Ice(vanillaLatte);

        Menu menu = new Menu();
        menu.addMenu("에스프레소", 1000, espresso);
        menu.addMenu("드립커피", 1500, dripCoffe);
        menu.addMenu("아메리카노", 2000, americano);
        menu.addMenu("아이스 아메리카노", 2000, icedAmericano);
        menu.addMenu("라떼", 3000, latte);
        menu.addMenu("바닐라 라떼", 3500, vanillaLatte);
        menu.addMenu("아이스 바닐라 라떼", 4000, icedVanillaLatte);

        return menu;
		
	}
}
