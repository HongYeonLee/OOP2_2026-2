package week1.리모콘;

import week1.싱글턴.하늘;

public class RemoteController implements Remotable{
	Remotable rc = null; //리모컨으로 조종할 대상
	
	//싱글턴 처리
	private static RemoteController instance = null;
	
	private RemoteController() {
		System.out.println("리모콘 객체를 만듭니다.");
	}
	
	public static RemoteController getInstance() {
		if (instance == null) {
			instance = new RemoteController();
		}
		return instance;
	}
	
	public void changeMode(TV tv) {
		System.out.println("TV를 조종합니다");
		this.rc = tv;
	}
	
	public void changeMode(Audio au) {
		System.out.println("Audio를 조종합니다");
		this.rc = au;
	}
	
	public void changeMode(Car car) {
		System.out.println("Car를 조종합니다");
		this.rc = car;
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		this.rc.turnOn();
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		this.rc.turnOff();
	}

	@Override
	public void mute() {
		// TODO Auto-generated method stub
		this.rc.mute();
		
	}

	@Override
	public void setVolum(int vol) {
		// TODO Auto-generated method stub
		this.rc.setVolum(vol);
	}

	@Override
	public int getVolum() {
		// TODO Auto-generated method stub
		return this.rc.getVolum();
	}
}
