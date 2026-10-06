package week3.Lab;

public class HorseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Horse("질풍"));
		Thread t2 = new Thread(new Horse("번개"));
		Thread t3 = new Thread(new Horse("적토마"));
		
		t1.start();
		t2.start();
		t3.start();
	}

}
