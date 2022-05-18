public class Main {
    public static void main(String[] args){
        Bus dyk = new Bus(20,200,20);
        System.out.println("bus No==> "+dyk.number);
        Bus kkk = new Bus(10,100,30);
        System.out.println("bus No==> "+kkk.number);
        Taxi taxi_1 = new Taxi(500,50,20);
        Passenger doyupKim = new Passenger("doyupKim", 2000);
        System.out.println(doyupKim.passengerKey);
        System.out.println(doyupKim.hasMoney);
        System.out.println(doyupKim.passengerKey);
        doyupKim.takeTaxi(taxi_1,"서울역");
        System.out.println(doyupKim.hasMoney);
        taxi_1.showInfo();
        dyk.setSuppliedGas(20);
        dyk.changeSpeed(40);
        System.out.println(dyk.status);
        dyk.setSuppliedGas(9);
        dyk.setSuppliedGas(0);
        System.out.println(dyk.status);
        dyk.changeSpeed(20);
        System.out.println(dyk.suppliedGas);
        dyk.ride("운행");
        System.out.println(dyk.status);
        dyk.setSuppliedGas(20);
        dyk.ride("운행");
        System.out.println(dyk.status);
        dyk.ride("차고지행");
        dyk.showInfo();
        taxi_1.arrive(doyupKim);

    }
}
