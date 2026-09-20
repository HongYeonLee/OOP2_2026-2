package week2.Lab;

public class 동물 {
	private String name;
	
	public 동물() {
		
	}
	
	public 동물(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public String toString() {
        return name; // 객체를 출력할 때 name이 반환되도록 설정, 기본 toString() 메소드는 클래스이름@16진수해시코드 출력
    }
	
}
