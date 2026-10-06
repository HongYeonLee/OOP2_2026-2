package week5;

public class Player {
	private Weapon weapon; // 무기만 알고 있음 (추상)
	
	public Player (Weapon weapon) { //생성시 주입받음. 의존성 주입
		this.weapon = weapon;
	}
	
	void attack() {
		weapon.use(); // 어떠한 무기를 받더라도 같은 방식으로 공격
	}

}
