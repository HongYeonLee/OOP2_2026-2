package week7.요리교실;

public abstract class CookingClass {
	//템플릿 메소드, 자식이 못바꾸게 final 처리
	public final void cook() {
		System.out.println("<<<< 오늘의 요리 : " + this.getClass().getSimpleName() + ">>>>");
		prepareIngredients();
		preCook();
		mainCook();
		plate(); // 공통 메소드
		serve(); // 공통 메소드
	}
	
	//공통 단계
	protected void plate() {
		System.out.println("요리의 완성은 plating! 예쁘게 담아서 눈을 즐겁게 해요!");
	}
	
	protected void serve() {
		System.out.println(this.getClass().getSimpleName() + "요리를 제공합니다. 맛있게 먹어요~ 냠냠!");
	}
	
	// 변형 단계로 하위클래스 마다 다르게 구현
	protected void prepareIngredients() {
		System.out.println("재료를 준비합니다!");
	}
	
	protected abstract void preCook(); // 전처리, 씻기, 썰기, 재우기
	protected abstract void mainCook(); // 메인 조리
	
}
