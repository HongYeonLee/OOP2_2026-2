package week6.CoffeeMaker;

// 커피 제작 의뢰기: IoC와 DI 적용
// IoC 적용: CoffeeMaker는 어떤 커피를 만들지 스스로 결정하지 않는다. 외부에서 setter를 통해 주입받는다 -> 선택적 의존성 
public class CoffeeMaker {
    private Coffee coffee;
    
    // setter DI
    public void setCoffee(Coffee coffee){
    	this.coffee = coffee;
    }
    
    // 다형성과 IoC가 결합한 구조로 커피에게 스스로 커피를 만들라고 하는 구조
    // 커피머신은 커피에 의존한다. 즉, 커피 만들기 기능은 커피에 위임한 상태이다
    // makeCoffee를 보면 제어권이 커피메이커에 있는 듯하지만, 결국 coffee.prepare()를 호출
    // 제어권은 커피 구현체에게로 넘어간다
    public void makeCoffee() {
    	System.out.println(coffee.prepare());
    }
}
