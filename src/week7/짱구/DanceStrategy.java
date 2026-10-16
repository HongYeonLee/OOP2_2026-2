package week7.짱구;

public class DanceStrategy implements IBehaviorStrategy{

	@Override
	public void behave(String context) {
		// TODO Auto-generated method stub
		System.out.println(context + " 상황? 상관없다!! ");
		System.out.println("엉덩이를 씰룩씰룩! 부리부리 춤을 춥니다 + 방귀 공격 뿡뿡! (엄마, 아빠 기절)");
	}

}
