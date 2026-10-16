package week7.요리교실;

public class CookingClassTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CookingClass pastaClass = new SeafoodTomatoPastaClass();
		pastaClass.cook();
		
		System.out.println("----------------");
		
		CookingClass riceClass = new TomatoEggFriedRiceClass();
		riceClass.cook();
	}

}
