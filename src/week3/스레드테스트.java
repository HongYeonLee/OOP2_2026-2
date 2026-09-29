package week3;

public class 스레드테스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new MyThread(); //얘는 Thread 클래스 상속받았으니까
		t1.start();
		
		Thread t2 = new Thread(new MyRunnable()); //의존성 주입
		t2.start();
		
		//익명 클래스 이용, Thread 클래스에 매개변수로 전달
		Thread t3 = new Thread(
				new Runnable() {
					public void run() {
						for (int i = 0; i < 100; i++) {
							System.out.println("익명 클래스로 만든 스레드 " + i);
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
				
		);
		
		t3.run();
		
		Thread t4 = new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("람다식으로 만든 스레드 " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t4.run();
	}

}
