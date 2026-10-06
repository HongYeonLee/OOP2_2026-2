package week4;

public class PigTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 각자 다른 시간으로 놀지만 집에는 같이 옴
		// join을 쓰면 먼저 끝난 스레드들은 어떤 상태에 들어가 있는거지?
		
		//스레드 생성
		Pig pig1 = new Pig("첫째");
		Pig pig2 = new Pig("둘째");
		Pig pig3 = new Pig("셋째");
		
		//스레드 시작
		pig1.start();
		pig2.start();
		pig3.start();
		
		try {
			pig1.join(); //첫째가 집에 올 때까지 대기
			pig2.join(); //둘째가 집에 올 때까지 대기
			pig3.join(); //셋째가 집에 올 때까지 대기
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("아기돼지삼형제: 엄마! 우리 모두 같이 도착했어요~");
		System.out.println("엄마돼지: 모두 왔구나! 문 열어줄게~");
	}

}
