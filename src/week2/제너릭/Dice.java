package week2.제너릭;

import java.util.ArrayList;

//T 타입의 주사위 객체를 만들 수 있도록 제너릭 클래스로 선언한다
//제너릭 클래스를 사용하게 되면, 클래스 내에서의 <T>는 전부 똑같은 데이터 타입이다
public class Dice<T> {
	T result = null; //구르기 결과를 저장할 변수, 색깔 타입 주사위면 색깔 저장, 숫자 타입 주사위면 숫자 저장
	ArrayList<T> list; //주사위 면에 적힌 값들을 저장할 리스트, 색깔 타입 주사위면 색깔(String), 숫자 타입 주사위면 Integer. 이 타입은 Dice 객체를 생성될 때 사용자가 입력한 값으로 결정됨
	//일반 배열은 제너릭을 사용할 수 없다.
	
	//생성자, 리스트 초기화
	public Dice() {
		list = new ArrayList<>();
	}
	
	public Dice(T t) {
		this(); //Dice() 호출
		result=t;  //result 변수 초기화
		showType();//무슨 타입의 주사위인지 보이기
	}
	
	public void showType() {
		System.out.println("이 주사위는 " + result.getClass().getSimpleName()); //T가 무슨 타입(클래스)인지 가져오는데 그냥 가져오면 길고 복잡하니까 줄여서 가져옴
	}
	
	public void 구르기() {
		int randNum = (int)(Math.random() * 1000) % list.size(); //주사위를 굴러서 나올 면 정하기
		result = list.get(randNum); //result는 T 타입
	}
		
	//주사위를 색깔 주사위로 설정하기
	public void setDiceToColor() {
		System.out.println("주사위를 무지개색으로 세팅합니다.");
		String colors = "빨간색 주황색 노랑색 초록색 파랑색 남색 보라색";
		String[] ar = colors.split(" "); //구분자를 빈칸으로 주어 colors에 있는 문자열들을 자른 후 ar 배열에 넣음
		for (String s : ar) {
			list.add((T)s); //list.add(s) 불가, 클래스를 작성하는 시점에서는 T가 무엇이 될지 모르기에 함부로 String을 ArrayList<T> list에 넣을 수 없음. Dice<Integer>를 할 수도 있으니까
		}
	}
	
	//주사위를 숫자 주사위로 설정하기
		public void setDiceToNum(int size) {
			System.out.printf("주사위를 Integer %d개로 세팅합니다.\n", size);
			for (Integer i = 0; i < size; i++) {
				Integer num = i + 1; //컬렉션 list에 넣어주기 위해 int가 아니라 Integer
				list.add((T)num); //list.add(num) 불가
			}
		}
}
