public class Taxi extends Transport{
    String destination;               // 목적지
    int meterFares;                   // 거리당 요금
    int basicFares;                   // 요금
    int income;                       // 금일 수입
    String status= "일반";            //초기값 "일반"
    int passengerKey;                      // 승객 정보

    public Taxi(int basicFares, int meterFares, int suppliedGas) {
        this.basicFares = basicFares;
        this.meterFares = meterFares;
        this.suppliedGas = suppliedGas;
    }

    void ride(String ride){    // 1= 운행 / 0 = 차고지
        if(this.suppliedGas >= 10) this.status = "운행중";
        else this.status = "일반";
    }

    void setSuppliedGas(int liter){ // 주유량이 10 미만이면 메시지 출력
        this.suppliedGas = liter;
        if(liter<10) System.out.println("주유가 필요합니다");
        if(this.suppliedGas == 0){
            this.status = "차고지행";
        }
    }

    void changeSpeed(int speed){
        System.out.println("속도를 변경합니다. "+this.currentSpeed+"==>"+speed);
        this.currentSpeed = speed;
    }

    boolean take(int fares, String destination, int passengerKey){
        if (this.status.equals("일반")){
            this.income += fares;
            this.destination = destination;
            this.status="운행중";
            this.passengerKey = passengerKey;
            System.out.println(this.number+"번 택시 : 승객이 탑승 하였습니다");
            return true;
        }
        else {
            System.out.println(this.number+"번 택시는 운행 중이므로 승차가 불가합니다.");
            return false;
        }
    }

    void arrive(Passenger passenger){
        int sum = this.meterFares;
        System.out.println("목적지에 도착했습니다.");
        passenger.payment(this.meterFares+this.basicFares);
        this.income += sum;
        this.status = "일반";
        this.destination ="";
    }
    @Override
    void showInfo(){
        if(status.equals("운행중")) {
            System.out.println(this.number + "번 택시는 현재 "
                    + this.status + " 상태이며 목적지 " + this.destination + "로 이동 중입니다.");
        }
        else System.out.println(this.number+"번 택시는 현재 대기 상태입니다.");

    }
}
