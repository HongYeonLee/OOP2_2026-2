package week4;

public class Pig extends Thread{
	private final String name;
	int time;
	
	//생성자
	public Pig(String name) {
		this.name = name;
		this.time = (int)(Math.random() * 7000) + 3000; //3000 ~ 10000 리턴, 시간으로 따지면 3 ~ 10초
	}
	
	//스레드에서 할 일 정의
	@Override
	public void run() {
		System.out.println("(☆ (●●) ☆)" + name + ": 밖에서 놀다 올게요~" + (time/1000) + "초 동안 놀거에요!");
		
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("(^ (●●) -) = ☆" + name + ": 집 앞에 도착했어요!");
	}

}
