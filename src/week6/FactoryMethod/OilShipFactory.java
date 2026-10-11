package week6.FactoryMethod;

public class OilShipFactory extends ShipFactory{
	private static OilShipFactory instance = null;
	
	//생성자 private
	private OilShipFactory() {}
	
	//클래스로 바로 호출할거니 static
	public static OilShipFactory getInstance() {
		if (instance == null) {
			instance = new OilShipFactory();
		}
		return instance;
	}

	@Override
	public Ship createShip() {
		// TODO Auto-generated method stub
		return new OilShip("유조선", "빨강", "15");
	}

}
