package week3;

public class MyThread extends Thread{
	public void run() {
		this.work();
	}
	
	//100회동안 0.5초씩 쉬어가면서 출력
	public void work() {
		for (int i = 0; i < 100; i++) {
			System.out.println("thread로 만든 " + (i));
			//1000 = 1초
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
