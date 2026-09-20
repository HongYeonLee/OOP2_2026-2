package week1.짱구;

public class 엄마 extends 할머니{
	private String 일기장;
	public 핸드폰 핸드폰압수bag;
	
	public void 요리하기() {
		System.out.println("스파게티를 만들어요");
	}
	
	public void 청소하기() {
		System.out.println("구석구석 청소해요");
	}
	
	public void 할머니처럼요리하기() {
		//new 할머니().요리하기();
		
		super.요리하기();
	}
	
	public void 핸드폰뺏기(짱구 짱) {
		//짱구의 핸드폰을 가져와서 저장하고, 짱구의 폰에는 null을 대입합니다.
		System.out.println("짱구의 핸드폰을 뺏습니다");
		this.핸드폰압수bag = 짱.getPhone();
		짱.setPhone(null);
	}
}
