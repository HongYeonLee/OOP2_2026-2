package week1.람다식;

//접근제한자 생략, 이 패키지안에서만 사용 가능
interface Hello{
	
	//추상메소드
	void sayHello();
}

interface Square{
	//추상메소드
	int calc(int x);
}

interface Calculator{
	//추상메소드
	int operate(int a, int b);
	
}


public class LamdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello h = () -> System.out.println("안녕하세요!"); //메소드 구현
		h.sayHello();//메소드 호출, 실제 실행은 람다식에서 정의한 동작 수행
		
		
		Square s = (x) -> x*x; //메소드 구현
		System.out.println(s.calc(10));
		
		Calculator c = (x, y) -> x+y;
		System.out.println(c.operate(10, 20));
	}

}
