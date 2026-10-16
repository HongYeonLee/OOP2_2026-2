package week7.요리교실;

// 1. 부모 추상 클래스 (레시피 뼈대 정의) 
public abstract class RamenRecipe {
	// 템플릿 메소드: 전체 실행 흐름을 제어합니다. (자식이 바꾸지 못하게 final 선언)
	public final void cookRamen() {
		boilWater(); //물 끓이기
		putNoodleAndSoup(); //면이랑 스프넣기
		addExtraTopping(); //자식들이 다르게 구현할 부분
		serve(); //내오기
	}
	
	private void boilWater() {
		System.out.println("1. 물을 550ml 넣고 끓인다");
	}
	
	private void putNoodleAndSoup() {
		System.out.println("2. 면과 분말 스프, 건더기 스프를 넣는다");
	}
	
	//추상 메소드: 자식 클래스가 반드시 구현해야 함
	protected abstract void addExtraTopping();
	
	private void serve() {
		System.out.println("4. 그릇에 담아 맛있게 먹는다\n");
	}
}
