package week7.버스택시;

//요금 계산 전략 인터페이스
public interface FareStrategy {
	int calculateFare(int distanceKm);
}
