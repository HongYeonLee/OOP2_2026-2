package week6.FactoryMethod;

public class ContainerShipFactory extends ShipFactory{
	private static ContainerShipFactory instance = null;
	
	//생성자 private
	private ContainerShipFactory() {}
	
	//클래스로 바로 호출할거니 static
	public static ContainerShipFactory getInstance() {
		if (instance == null) {
			instance = new ContainerShipFactory();
		}
		return instance;
	}
	
	@Override
	public Ship createShip() {
		// TODO Auto-generated method stub
		return new ContainerShip("화물선", "녹색", "20");
	}
	
}
