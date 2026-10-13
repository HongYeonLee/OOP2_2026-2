package week6.CoffeeMaker2.staff;

import week6.CoffeeMaker2.recipes.CoffeeRecipe;

// 커피 제작 의뢰기: IoC와 DI 적용
// IoC 적용: CoffeeMaker는 어떤 커피를 만들지 스스로 결정하지 않는다. 외부에서 매개변수를 통해 주입받는다
public class Barista {
    private CoffeeRecipe coffee;
    
    // 다형성과 IoC가 결합한 구조로 커피에게 스스로 커피를 만들라고 하는 구조
    // 커피머신은 커피에 의존한다. 즉, 커피 만들기 기능은 커피에 위임한 상태이다
    // serve를 보면 제어권이 바리스타에게 있는 듯하지만, 결국 coffee.prepare()를 호출
    // 제어권은 커피 구현체에게로 넘어간다
    public void serve(CoffeeRecipe coffee) {
    	System.out.println("바리스타가 커피를 준비 중입니다~");
    	System.out.println(coffee.prepare());
    }
}
