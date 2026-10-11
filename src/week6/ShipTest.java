package week6;

public class ShipTest {
	
	public static Ship orderShip(String name) {
		if (name == null) {
			throw new IllegalArgumentException("배 이름을 지어주세요.");
		}
		
		Ship ship = new Ship();
		ship.name = name;
		
		if (name.equals("화물선")) {
			ship.color = "빨강";
			ship.capacity = "20";
		}
		
		if (name.equals("유조선")) {
			ship.color = "초록";
			ship.capacity = "15";
		}
		
		System.out.println(name + "을(를) 만들었습니다.");
		
		return ship;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ship 화물선 = orderShip("화물선");
		System.out.println(화물선);
		
		Ship 유조선 = orderShip("유조선");
		System.out.println(유조선);
	}

}
