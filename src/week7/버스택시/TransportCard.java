package week7.버스택시;

//공통 교통카드 클래스
public class TransportCard {
    public void pay(Transport transport, int distanceKm){
        int fare = transport.calculateFare(distanceKm);
        System.out.println(transport.getName() + " 이용 (" + distanceKm + "km) -> 결제 요금: " + fare + "원");
    }
}
