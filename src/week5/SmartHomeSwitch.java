package week5;

import java.util.List;

// 스마트홈 스위치는 추상화에만 의존하여 여러개의 device 연결
public class SmartHomeSwitch {
	private final List<Device> devices;
	
	public SmartHomeSwitch(List<Device> devices) {
		this.devices = devices;
	}
	
	public void operateAll(String command) {
		for (Device dev : devices) {
			if (command.equals("on")) {
				dev.turnOn();
			}
			else {
				dev.turnOff();
			}
			
		}
	}
	
	public void operateByType(Class<? extends Device> type, String command) { //상위 타입 제한, Class는 Device와 그 하위 타입의 클래스만 가능
		for (Device dev : devices){
			if (type.isInstance(dev)) {
				if(command.equals("on")) {
					dev.turnOn();
				}
				else {
					dev.turnOff();
				}
			}
		}
	}
}
