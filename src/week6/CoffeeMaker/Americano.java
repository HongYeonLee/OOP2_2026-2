package week6.CoffeeMaker;

public class Americano implements Coffee {
    private final CoffeeMachine espressoMachine;
    //private final CoffeeMachine dripCoffeeMachine; //드립커피 머신을 사용할 수도 있다

    // 생성자에게 의존성 주입 - DI
    // 머신이 커피를 준비하는게 아니라, 커피가 의존성 주입으로 머신을 준비한다
    // 에소프레소는 어떤 머신을 사용할지 스스로 결정하지 않고 외부에서 주입받는다 - IoC
    public Americano(CoffeeMachine espressoMachine){
    	this.espressoMachine = espressoMachine;
    }
    
    @Override
    public String prepare(){
    	System.out.print("아메리카노 준비: ");
        return espressoMachine.brew() + " + 뜨거운 물";
    }

}
