package week4;

import javax.swing.JFrame;

//상속 회피하기, JFrame과 의존 관계
public class myView2 {
	JFrame view = new JFrame();
	
	public myView2() {
		view.setSize(500, 2000); //this 안쓰는 이유?
		view.setVisible(true);
		
	}
}
