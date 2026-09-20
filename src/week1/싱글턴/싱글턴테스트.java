package week1.싱글턴;

public class 싱글턴테스트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//생성자가 private이니까 바로 접근 불가능
		//하늘 sky1 = new 하늘(); 
		하늘 sky1 = 하늘.getInstance(); //static이라 클래스 이름으로 바로 접근 가능
		하늘 sky2 = 하늘.getInstance();
		하늘 sky3 = 하늘.getInstance();
		
		//가상메모리상의 주소가 전부 같음
		System.out.println(sky1);
		System.out.println(sky1);
		System.out.println(sky1);
	}

}
