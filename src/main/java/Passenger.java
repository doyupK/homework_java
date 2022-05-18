public class Passenger {
    static int count = 0;
    String name;
    int hasMoney;
    int passengerKey;
    {
        ++count;                    //인스턴스가 생성될 떄마다 count증가
        passengerKey = count;       //객체 고유 번호지정
    }
    Taxi takeTaxiInfo;


    public Passenger(String name, int hasMoney) {
        this.name = name;
        this.hasMoney = hasMoney;
    }

    void takeBus(Bus bus){
        boolean result;
        result = bus.take(bus.fares);
        if(result) {
            this.hasMoney -= bus.fares;
            System.out.println(bus.number + "번 버스 탑승.");
        }
    }

    void takeTaxi(Passenger passenger,Taxi taxi, String destination, int destinationDistance) {
        boolean result;
        BoardingInfo boarding = new BoardingInfo(passenger, taxi, destination, destinationDistance);
        result = taxi.take(boarding);
        if (result) {
            this.takeTaxiInfo = taxi;
            System.out.println(taxi.number + "번 택시에 탑승합니다.");

        }

    }

    void payment(int fare){
        this.hasMoney -= fare;
        System.out.println("요금 "+fare+"을 지불하고 잔액은 "+this.hasMoney+"원 입니다.");
    }
}