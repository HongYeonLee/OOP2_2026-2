package week6.FactoryMethod;

public class Ship {
	String name, color, capacity;
	
	public Ship() {
	}
	
	@Override
	public String toString() {
		return String.format("이 선박의 정보: {이름: %s, 색상: %s, 용량: %s(톤)", name, color, capacity);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	
}
