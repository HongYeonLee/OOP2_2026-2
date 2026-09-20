package week1.짱구;

public class 짱구테스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		할머니 a = new 할머니();
		엄마 b = new 엄마();
		짱구 c = new 짱구();
		
		a.요리하기();
		b.요리하기();
		b.청소하기();
		
		//짱구
		c.청소하기();
		c.요리하기();
		c.할머니처럼요리하기();
		c.열심히공부하기();
		c.공부하기();
		
		//엄마가 짱구의 핸드폰을 압수한 후의 c의 공부하기는
		b.핸드폰뺏기(c);
		c.공부하기();
		
		//엄마가 압수한 핸드폰을 짱구에게 다시 set
		c.핸드폰뺏기(b);
		c.공부하기();
		
	}

}
