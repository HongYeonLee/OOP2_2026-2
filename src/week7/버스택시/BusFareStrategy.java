package week7.버스택시;

// 기본 버스 요금 전략 (거리 무관 1,200원)
public class BusFareStrategy implements FareStrategy{

	@Override
	public int calculateFare(int distanceKm) {
		// TODO Auto-generated method stub
		return 1200;
	}

}
