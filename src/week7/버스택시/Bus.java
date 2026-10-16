package week7.버스택시;

// 구체적인 교통수단 클래스
public class Bus extends Transport{
	 public Bus(FareStrategy fareStrategy){
	     super("버스", fareStrategy);
	 }
}
