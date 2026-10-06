package week5;

import java.util.Arrays;

public class SmartHomeSwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Device light = new Light();
		Device cm = new CoffeMachine();
		Device ac = new AC();
		
		//초기 세팅, 의존성 주입
		SmartHomeSwitch switchPanel = new SmartHomeSwitch(Arrays.asList(light, cm, ac));
		switchPanel.operateAll("on");
		switchPanel.operateAll("off");
	}

}
