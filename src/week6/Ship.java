package week6;

public class Ship {
	String name, color, capacity;
	
	public Ship() {
	}
	
	@Override
	public String toString() {
		return String.format("이 선박의 정보: {이름: %s, 색상: %s, 용량: %s(톤)", name, color, capacity);
	}
}
