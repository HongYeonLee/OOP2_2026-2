package week6.CoffeeMaker2.recipes;

import week6.CoffeeMaker2.machines.CoffeeMachine;

public class DripCoffeeRecipe implements CoffeeRecipe{
    private final CoffeeMachine dripCoffeeMachine;
  
    public DripCoffeeRecipe(CoffeeMachine dripCoffeeMachine){
    	this.dripCoffeeMachine = dripCoffeeMachine;
    }
    @Override
    public String prepare(){
        return dripCoffeeMachine.brew();
    }
}

