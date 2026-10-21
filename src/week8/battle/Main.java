package week8.battle;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player("p1", 100, 10, "블위.png", "블위2.png"); //이름, 체력, power, 이미지 이름
		Player p2 = new Player("p2", 100, 30, "헐크.png", "헐크2.png");
	
		View view = new View(p1, p2);
		view.setVisible(true);
	}

}
