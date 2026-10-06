package week3.Lab;

//Thread 클래스를 상속받아서 스레드 만들기
public class Player1 extends Thread{
	String name;
	String sound;
	int time;
	
	//생성자
	public Player1 (String name, String sound, int time) {
		this.name = name;
		this.sound = sound;
		this.time = time;
	}
	
	//스레드에서 할 일 정의
	public void run() {
		int i = 0;
		while (true) {
			if (i == time) break;
			System.out.printf("%d %s %s \n", (i + 1), name, sound);
			i++;
		}
		
		System.out.println(name + "끝");
	}
}
