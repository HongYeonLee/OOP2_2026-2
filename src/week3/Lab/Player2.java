package week3.Lab;

//Runnable 인터페이스 이용하기
public class Player2 implements Runnable{
	String name;
	String sound;
	int time;
	
	//생성자
	public Player2 (String name, String sound, int time) {
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
