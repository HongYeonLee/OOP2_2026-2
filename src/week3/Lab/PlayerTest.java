package week3.Lab;

public class PlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Thread 상속해서 스레드 만들기
		Thread p1 = new Player1("짱구", "호호이~", 20); //name, sound, time 순
		Thread p2 = new Player1("맹구", "콧물돌리기 ! !", 20); //name, sound, time 순
		Thread p3 = new Player1("흰둥이", "멍멍멍멍!", 20); //name, sound, time 순
	
		//Runnable 구현해서 스레드 만들기
		Thread th1 = new Thread(new Player2("**짱구", "호호이~", 10));
		Thread th2 = new Thread(new Player2("**맹구", "콧물돌리기 ! !", 10));
		Thread th3 = new Thread(new Player2("**흰둥이", "멍멍멍멍!", 10));
		
		//Thread의 이름 가져오기
		System.out.println(p1.getName()); //Thread-0
		System.out.println(p2.getName()); //Thread-1
		System.out.println(p3.getName()); //Thread-2
		
		System.out.println(th1.getName()); //Thread-3
		System.out.println(th2.getName()); //Thread-4
		System.out.println(th3.getName()); //Thread-5
		
		//Thread의 이름 지정하기
		th1.setName("**짱구"); //Thread-3 -> **짱구 
		System.out.println(th1.getName());
		
		p1.start();
		p2.start();
		p3.start();
		
		th1.start();
		th2.start();
		th3.start();
	}

}
