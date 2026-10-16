package week7.요리교실;

// 해물토마토파스타 클래스
public class SeafoodTomatoPastaClass extends CookingClass {
	@Override
	protected void prepareIngredients() {
		System.out.println("재료: 파스타면, 새우, 오징어, 토마토소스, 마늘, 올리브 오일을 준비하세요");
	}
	
	@Override
	protected void preCook() {
		// TODO Auto-generated method stub
		System.out.println("--새우와 오징어의 껍짓을 벗기고, 오징어를 통으로 먹기좋게 썰어요");
		System.out.println("마늘은 다지지않고 얇게 썰어요");
		
	}

	@Override
	protected void mainCook() {
		// TODO Auto-generated method stub
		System.out.println("--파스타 면을 삶아서 준비해요.");
		System.out.println("--올리브오일에 마늘을 넣어 볶다가 해물을 넣어 좀 더 볶은 후 ");
        System.out.println("--토마토소스를 넣어 끓여요. 삶은 면과 섞어요.");
		
	}
	
	 @Override
	 protected void plate() {
	    System.out.println("--접시에 돌돌 말아 담고, 파슬리로 마무리!");
	 }

}
