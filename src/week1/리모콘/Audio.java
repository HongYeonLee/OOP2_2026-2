package week1.리모콘;

public class Audio implements Remotable{
	private int volumn = 5; //기본 볼륨 5
	
	public void Audio() {
		
	}
	
	public void Audio(int vol) {
		this.volumn = vol;
		showVolumn();
	}
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 끕니다.");
	}

	@Override
	public void mute() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 mute 합니다.");
		this.setVolum(0);
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
		System.out.printf("Audio의 볼륨: %d \n", this.getVolum());
		System.out.println("--------------------");
	}

}
