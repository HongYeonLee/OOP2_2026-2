package week7.버스택시;

//기본 택시 요금 전략 (2km까지 2,500원, 이후 1km당 700원)
public class TaxiFareStrategy implements FareStrategy{
 @Override
 public int calculateFare(int distanceKm){
     if (distanceKm <= 2) {
         return 2500;
     }
     return 2500 + (distanceKm - 2) * 700;
 }
}
