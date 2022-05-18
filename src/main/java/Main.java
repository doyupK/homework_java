public class Main {
    public static void main(String[] args){
        Taxi taxi_1 = new Taxi(200,10,30,10);
        Passenger dyk = new Passenger("dyk",10000);
        dyk.takeTaxi(dyk, taxi_1, "서울역",20);
        taxi_1.arrive();
        System.out.println(dyk.hasMoney);
    }
}
