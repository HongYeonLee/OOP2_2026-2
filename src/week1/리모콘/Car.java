package week1.리모콘;

public class Car implements Remotable{
	private int volumn = 5;
	
	public void Car() {
		
	}
	
	public void Car(int vol) {
		this.volumn = vol;
		showVolumn();
	}
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		시동켜기();
	}
	
	public void 시동켜기() {
		System.out.println("Car의 시동을 켭니다");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		시동끄기();
		
	}
	
	public void 시동끄기() {
		System.out.println("Car의 시동을 끕니다");
	}


	@Override
	public int getVolum() {
		// TODO Auto-generated method stub
		return this.volumn;
	}

	@Override
	public void setVolum(int vol) {
		// TODO Auto-generated method stub
		this.volumn = vol;
		showVolumn();
		
	}

	public void showVolumn() {
		// TODO Auto-generated method stub
		System.out.println("--------------------");
		System.out.printf("Car의 볼륨: %d \n", this.getVolum());
		System.out.println("--------------------");
	}

	@Override
	public void mute() {
		// TODO Auto-generated method stub
		System.out.println("Car를 mute 합니다.");
		this.setVolum(0);
		
	}
	
	

}
