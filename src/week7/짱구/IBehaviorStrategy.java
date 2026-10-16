package week7.짱구;

// 전략 인터페이스
// 짱구의 행동 전략 정의
// 결제 방식에 전략패턴을 적용했던 것처럼, PaymentMethod 인터페이스에 해당
public interface IBehaviorStrategy {
	//특정 상황(context)에서 짱구의 행동을 정의한다
	void behave(String context);
}
