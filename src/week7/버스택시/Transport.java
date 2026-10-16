package week7.버스택시;

// 교통수단 추상 클래스 (요금 계산 전략을 캡슐화하여 소유)
public abstract class Transport{
	 private String name;
	 private FareStrategy fareStrategy;
	
	 public Transport(String name, FareStrategy fareStrategy){
	     this.name = name;
	     this.fareStrategy = fareStrategy;
	 }
	
	 // 운행 중 상황 변경 시 요금 전략 동적 교체 가능
	 public void setFareStrategy(FareStrategy fareStrategy){
	     this.fareStrategy = fareStrategy;
	 }
	
	 public String getName(){
	     return name;
	 }
	
	 public int calculateFare(int distanceKm){
	     return fareStrategy.calculateFare(distanceKm);
	 }
}