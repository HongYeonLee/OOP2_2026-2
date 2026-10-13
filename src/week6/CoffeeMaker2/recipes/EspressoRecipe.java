package week6.CoffeeMaker2.recipes;

import week6.CoffeeMaker2.machines.CoffeeMachine;

public class EspressoRecipe implements CoffeeRecipe {
    private final CoffeeMachine espressoMachine;
    
    // 생성자에게 의존성 주입 - DI
    // 머신이 커피를 준비하는게 아니라, 커피가 의존성 주입으로 머신을 준비한다
    // 에소프레소는 어떤 머신을 사용할지 스스로 결정하지 않고 외부에서 주입받는다 - IoC
    public EspressoRecipe(CoffeeMachine espressoMachine){
    	this.espressoMachine = espressoMachine;
    }
    
    @Override
    public String prepare(){
        return espressoMachine.brew();
    }

}
