package week1.싱글턴;
//싱글톤으로 만들기!
public class 하늘 {
	//하늘 객체가 생성되었는지 저장하는 변수
	//하늘 타입, 공유해서 쓸거니까 static, 외부 바로 접근 불가, 변수명 instance
	//처음 세팅값을 아예 바꾸기 싫으면 final 붙여서 상수화
	private static 하늘 instance = null;
	
	//public 생성자 --> 외부에서 계속 호출 가능 --> private 생성자로 변경
	private 하늘() {
		System.out.println("하늘 객체를 만듭니다.");
	}
	
	//하늘 객체가 생성되지 않았다면 새로 만들고 저장함
	//이미 생성되었다면 기존에 만들어진 값을 return
	//리턴 타입이 하늘 객체인 메소드, 공유해서 쓸거니까 static, 외부에서 바로 접근 가능
	public static 하늘 getInstance() {
		if (instance == null) {
			instance = new 하늘();
		}
		return instance;
	}
}
