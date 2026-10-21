package week8.battle;

public class Player {
	String name;
	int hp;
	int power;
	String img;
	String img2;
	
	public Player(String name, int hp, int power, String img, String img2) {
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.img	 = img;
		this.img2 = img2;
	}
	
	//target의 hp를 나의 power만큼 깎는다
	public void attack(Player target) {
		target.hp -= this.power;
		System.out.println(this.name + " ===> " + target.name + "공격");
		
	}
	
	//본인의 hp를 10만큼 채운다
	public void heal() {
		this.hp += 10;
		System.out.println(this.name + "의 hp를 10만큼 치유합니다");
	}
	
	
}
