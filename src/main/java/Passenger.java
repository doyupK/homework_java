public class Passenger {
    static int count = 0;
    String name;
    int hasMoney;
    int passengerKey;
    {
        ++count;                    //인스턴스가 생성될 떄마다 count증가
        passengerKey = count;       //객체 고유 번호지정
    }

    public Passenger(String name, int hasMoney) {
        this.name = name;
        this.hasMoney = hasMoney;
    }

    void takeBus(Bus bus){
        bus.take(bus.fares);
        this.hasMoney -= bus.fares;
        System.out.println(bus.number +"번 버스에 탑승합니다.");
    }

    void takeTaxi(Taxi taxi, String destination) {
        boolean result;
        result = taxi.take(taxi.basicFares, destination);
        if (result) {
            this.hasMoney -= taxi.basicFares;
            System.out.println(taxi.number + "번 택시에 탑승합니다.");
        }

    }
}