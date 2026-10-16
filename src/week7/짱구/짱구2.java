package week7.짱구;

public class 짱구2 {
	private IBehaviorStrategy currentStrategy;
	
	//상황에 따라서 알아서 전략 선택하기, 단순 단어 포함 여부로 결정
	public void encounterSituation(String context) {
		if (context.contains("심부름") || context.contains("귀찮")) {
			currentStrategy = new SleepStrategy();
		}
		else if (context.contains("울고") || context.contains("괴롭힘")) {
			currentStrategy = new ActionMaskStrategy();
		}
		else if (context.contains("춤") || context.contains("놀")) {
			currentStrategy = new DanceStrategy();
		}
		else {
			//여기서 사용하는 람다식은 IBehaviorStrategy의 behave 함수를 구현한 것, behave 함수에 매개변수로 context를 줌
			currentStrategy = (ctx) -> {
				System.out.println(context + " 상황이요? 짱구는 아무 생각이 없습니다");
			};
		}
		//새 전략이 추가되면 조건문 추가
		
		
		currentStrategy.behave(context);
	}
}
