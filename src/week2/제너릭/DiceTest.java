package week2.제너릭;

import java.util.Scanner;

public class DiceTest {
	
	static  Scanner input = new Scanner(System.in);	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dice dice = null;
		String s = "";
		int num = 0;
		
		System.out.println("주사위 타입을 입력하세요: 1. 색깔  2. 숫자");
		System.out.print("선택: ");
		int type = input.nextInt(); //사용자 입력받음
		
		input.nextLine(); //엔터 먹기
		System.out.print("주사위를 세팅합니다: ");
		
		if (type == 1) { // 색깔
			dice = new Dice<String>(); //String 타입의 제너릭 클래스로 객체 만듦
			dice.setDiceToColor(); //무지개 색으로 초기화, 리스트에 무지개색 담김
		}
		
		if (type == 2) { //숫자
			dice = new Dice<Integer>(); //Integer 타입의 제너릭 클래스로 객체 만듦
			dice.setDiceToNum(6); //숫자 6개, 1 ~ 6으로 리스트에 담음
		}
		
		System.out.println(dice.list); //리스트의 요소 보여주기
		dice.구르기();
		System.out.println("주사위를 굴려서 나온 값은 " + dice.result + "입니다.");
	}

}
