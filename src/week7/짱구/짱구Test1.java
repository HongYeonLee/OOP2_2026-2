package week7.짱구;

public class 짱구Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		짱구 짱구 = new 짱구();
		
		// 전략이 없을 때
		짱구.encounterSituation("무념 무상...");
		
		// 1.엄마가 심부름을 시키려고 하는 상황
		짱구.setStrategy(new SleepStrategy());
		짱구.encounterSituation("엄마가 귀찮은 심부름을 시키려고 할 때");

		// 2.훈이가 괴롭힘을 당하는 정의로운 상황
		짱구.setStrategy(new ActionMaskStrategy());
		짱구.encounterSituation("훈이가 덩치 큰 아이들에게 괴롭힘을 당할 때");
		
		// 3. 개구쟁이 짱구. 유치원에서 장난치는 상황! 
		짱구.setStrategy(new DanceStrategy());
		짱구.encounterSituation("유치원에서 친구들이랑 춤추고 놀 때");
		
	}

}
