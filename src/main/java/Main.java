public class Main {
    public static void main(String[] args){
        Taxi taxi_1 = new Taxi(200,10,100,10);
        Taxi taxi_2 = new Taxi(300,20,9,10);
        Bus bus_1 = new Bus(20,1000,100);
        Passenger dyk = new Passenger("dyk",10000);

        dyk.takeTaxi(dyk, taxi_2, "서울역", 20);
        System.out.println(dyk.hasMoney);

        dyk.takeTaxi(dyk, taxi_1, "서울역",20);
        taxi_2.setSuppliedGas(20);
        taxi_1.arrive();

        System.out.println(dyk.hasMoney);
        dyk.takeTaxi(dyk, taxi_2, "안양역", 20);

        taxi_2.arrive();
        System.out.println(dyk.hasMoney);

        taxi_1.endService();
        dyk.takeBus(bus_1);
        bus_1.showInfo();
        taxi_1.showInfo();
        taxi_2.showInfo();
        dyk.takeTaxi(dyk,taxi_1,"수원역",23);



    }
}
