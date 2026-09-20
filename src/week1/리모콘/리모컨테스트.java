package week1.리모콘;

public class 리모컨테스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteController rc = RemoteController.getInstance();
		
		TV tv = new TV();
		Audio au = new Audio();
		Car car = new Car();
		
		//tv 조종
		rc.changeMode(tv);
		rc.turnOn();
		rc.setVolum(7);
		rc.turnOff();
		
		//audio 조종
		rc.changeMode(au);
		rc.turnOn();
		rc.mute();
		rc.turnOff();
		
		//car 조종
		rc.changeMode(car);
		rc.turnOn();
		rc.turnOff();
		
		
	}

}
