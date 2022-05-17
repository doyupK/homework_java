class Bus{
    static int count=0;
    int maxPassenger;       // 최대 승객
    int CurrentPassenger;   // 현재 승객
    int fares;            // 요금
    int busNumber;          //각 인스턴스 고유 번호
    {
        ++count;            //인스턴스가 생성될 떄마다 count증가
        busNumber = count;  //객체 고유 번호지정
    }
    int suppliedGas;
    int currentSpeed;
    String status= "운행";    //초기값 "운행"

    public Bus(int maxPassenger, int fares, int suppliedGas) {
        this.maxPassenger = maxPassenger;
        this.fares = fares;
        this.suppliedGas = suppliedGas;
    }

    void ride(String ride){    // 1= 운행 / 0 = 차고지
        if(ride == "운행" && this.suppliedGas >= 10) this.status = "운행";
        else this.status = "차고지행";
    }
    void setSuppliedGas(int liter){ // 주유량이 10 미만이면 메시지 출력
        this.suppliedGas = liter;
        if(liter<10) System.out.println("주유가 필요합니다");
        if(this.suppliedGas == 0){
            this.status = "차고지행";
        }
    }
    void changeSpeed(int speed){
        if(this.suppliedGas<10){
            System.out.println("주유량을 확인해주세요");
        }
        else{
            this.currentSpeed = speed;
        }
    }
}

public class Main {
    public static void main(String[] args){
        Bus dyk = new Bus(20,200,20);
        System.out.println("bus No==> "+dyk.busNumber);
        Bus kkk = new Bus(10,100,30);
        System.out.println("bus No==> "+kkk.busNumber);


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

    }
}
