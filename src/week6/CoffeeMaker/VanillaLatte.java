package week6.CoffeeMaker;

public class VanillaLatte implements Coffee{
	private Coffee latte;
	
	//생성자 주입 DI, IoC
	public VanillaLatte(Coffee latte) {
		this.latte = latte;
	}
	
	@Override
	public String prepare() {
		// TODO Auto-generated method stub
		System.out.print("바닐라 라떼 준비: ");
		return latte.prepare() + " + 바닐라 시럽";
	}

}
