package week6.FactoryMethod;

public class BattleShipFactory extends ShipFactory{
	private static BattleShipFactory instance = null;
	
	//생성자 private
	private BattleShipFactory() {}
	
	//클래스로 바로 호출할거니 static
	public static BattleShipFactory getInstance() {
		if(instance == null) {
			instance = new BattleShipFactory();
		}
		return instance;
	}
	
	@Override
	public Ship createShip() {
		// TODO Auto-generated method stub
		return new BattleShip("전함", "검정", "10");
	}
	
}
