package week6.CoffeeMaker;

public class Latte implements Coffee {
	//에소프레소 머신 또는 에소프레소를 주입받는다
	//private fianl CoffeeMachine espressoMachine;
    private Coffee espresso; //에소프레소 구성
    private MilkFrother milkFrother; //우유 구성
    
    //생성자에서 의존성 주입 - DI
    public Latte(Coffee espresso, MilkFrother milkFrother){
    	this.espresso = espresso;
    	this.milkFrother = milkFrother;
    }
    
    @Override
    public String prepare(){
    	System.out.print("라떼 준비: ");
        return espresso.prepare() + " + " + milkFrother.frothMilk();
    }

}
