package week7.요리교실;

public class RamenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RamenRecipe 신라면 = new 신라면();
		System.out.println("=== 신라면 조리 시작 ===");
		신라면.cookRamen(); // 부모의 템플릿 메소드 실행
		
		RamenRecipe 불닭볶음면 = new 불닭볶음면();
		System.out.println("=== 불닭볶음면 조리 시작 ===");
		불닭볶음면.cookRamen();
	}

}
