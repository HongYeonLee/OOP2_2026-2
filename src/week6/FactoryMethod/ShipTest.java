package week6.FactoryMethod;

public class ShipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ship 화물선 = ContainerShipFactory.getInstance().orderShip("hongyeonLee");
		System.out.println(화물선);
		
		Ship 유조선 = OilShipFactory.getInstance().orderShip("hongyeonLee");
		System.out.println(유조선);
		
		Ship 전함 = BattleShipFactory.getInstance().orderShip("hongyeonLee");
		System.out.println(전함);
	}

}
