package week6.FactoryMethod;

public abstract class ShipFactory {
	//객체 생성 전처리를 포함한 메소드, 상속 불가, 수정 불가 final
	final Ship orderShip(String email) {
		//객체 생성 전처리
		validate(email);
		
		//팩토리 메소드: 하위 공장 클래스에서 구현
		Ship ship = createShip();
		
		//객체 생성 후처리
		sendEmail(email, ship);
		
		return ship;
	}
	
	//전처리 메소드
	private void validate(String email) {
		if (email == null) {
			throw new IllegalArgumentException("이메일은 남겨주세요");
		}
	}
	
	//팩토리 메소드, 구현은 하위 클래스에서
	abstract protected Ship createShip();
	
	//후처리 메소드
	private void sendEmail(String email, Ship ship) {
		System.out.printf(ship.getName() + "을(를) 만들었습니다. " + email +"로 전송합니다 ");
		
	}
}
