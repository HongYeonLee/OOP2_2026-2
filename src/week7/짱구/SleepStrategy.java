package week7.짱구;

public class SleepStrategy implements IBehaviorStrategy{

	@Override
	public void behave(String context) {
		// TODO Auto-generated method stub
		System.out.println(context + " 상황...으음...Zzz..");
		System.out.println("눈을 감고 큰 소리로 코를 골아 상황을 회피합니다");
	}

}
