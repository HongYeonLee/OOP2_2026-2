package week3.Lab;

import java.util.Random;

public class Horse implements Runnable{
	String name;
	private int sleepTime;
	private final static Random generator = new Random();
	
	//생성자
	public Horse(String name) {
		this.name = name;
		sleepTime = generator.nextInt(3000); //객체의 sleep 시간 설정
	}
	
	//스레드에서 할 일 정의
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + "말이 경주를 완료했습니다");
	}
}
