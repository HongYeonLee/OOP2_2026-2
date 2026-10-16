package week7.짱구;

public class 짱구 {
	private IBehaviorStrategy currentStrategy;
	
	//setter 주입
	public void setStrategy(IBehaviorStrategy strategy) {
		this.currentStrategy = strategy;
		//심플 클래스 이름을 출력하여 전략 이름 표시
		System.out.println("\n--- 짱구의 매너전략(마음가짐) 변경: " + strategy.getClass());
	}
	
	public void encounterSituation(String situation) {
		System.out.println("\n[상황 발생]: " + situation);
		if (currentStrategy == null) {
			System.out.println("짱구: 아무 생각이 없어요...전략이 없으니 그냥 놀래~!");
			return;
		}
		//전략 패턴 적용: 설정된 전략에게 행동을 위임
		currentStrategy.behave(situation);
	}
}
