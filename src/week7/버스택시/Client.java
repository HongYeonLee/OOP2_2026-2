package week7.버스택시;

public class Client{
    public static void main(String[] args){
        TransportCard myCard = new TransportCard();
        int moveDistanceKm = 5; // 이동 예정 거리: 5km
        int busWaitTimeMinutes = 25; // 버스 대기 시간: 25분

        Transport selectedTransport;

        // 상황 판단: 버스 대기 시간이 20분 이상이면 택시, 아니면 버스 선택
        if (busWaitTimeMinutes >= 20) {
            System.out.println("버스가 20분 이상 지연되어 택시를 이용합니다.");
            selectedTransport = new Taxi(new TaxiFareStrategy());
        } else {
            System.out.println("버스를 이용합니다.");
            selectedTransport = new Bus(new BusFareStrategy());
        }

        // 동일한 교통카드로 선택된 교통수단 요금 결제
        // 택시 5km 이동 시: 2,500원 + (3km * 700원) = 4,600원 출력
        myCard.pay(selectedTransport, moveDistanceKm);
    }
}
