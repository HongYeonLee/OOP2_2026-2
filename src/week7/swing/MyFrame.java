package week7.swing;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	// 생성자에서 기본 틀 만들기
	public MyFrame() {
		this.setSize(300, 300); // 300x300 프레임 만들기
		this.setVisible(true);
	}
	
	public MyFrame(String str) {
		this();
		this.setTitle(str);
	}
	
	// 초기화 함수
	public void init() {
		
	}
	
	// 두개의 진입점
	public static void main(String[] args) {
		new MyFrame();
		new MyFrame("프레임에서 테스트");
	}
}
