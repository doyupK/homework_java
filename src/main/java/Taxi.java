public class Taxi extends Transport {
    String destination;               // 목적지
    int distanceFares;                   // 거리당 요금
    int basicFares;                   // 요금
    int sumFares;                     // 요금 합계
    int income;                       // 금일 수입
    String passengerName;                 // 승객 정보
    int standardDistance;
    int destinationDistance;
    BoardingInfo boardingInfo;

    public Taxi(int basicFares, int distanceFares, int suppliedGas, int standardDistance) {
        this.basicFares = basicFares;
        this.distanceFares = distanceFares;
        this.status = "일반";  //초기값 일반 /    일반or운행중
        this.suppliedGas = suppliedGas;
        this.standardDistance = standardDistance;
    }

    void startService(String ride) {    // 1= 운행 / 0 = 차고지
        if (this.suppliedGas >= 10) this.status = "운행중";
        else this.status = "일반";
    }

    void setSuppliedGas(int liter) { // 주유량이 10 미만이면 메시지 출력
        this.suppliedGas = liter;
        if (liter < 10) System.out.println("주유가 필요합니다");
        if (this.suppliedGas == 0) {
            this.status = "차고지행";
        }
    }

    void changeSpeed(int speed) {
        System.out.println("속도를 변경합니다. " + this.currentSpeed + "==>" + speed);
        this.currentSpeed = speed;
    }

    boolean take(BoardingInfo boardingInfo) {
        if (this.status.equals("일반")) {
            if (this.suppliedGas > 10) {
                this.passengerName = boardingInfo.passenger.name;
                this.destination = boardingInfo.destination;
                this.destinationDistance = boardingInfo.destinationDistance;
                this.boardingInfo = boardingInfo;
                this.status = "운행중";

                System.out.println(this.number + "번 택시 : " + this.passengerName + " 승객이 탑승 하였습니다");
                return true;
            } else {
                System.out.println(this.number + "번 택시는 연료 부족으로 승차가 불가합니다.");
                return false;
            }
        }
        else if (this.status.equals("운행중")) {
            System.out.println(this.number + "번 택시는 운행 중이므로 승차가 불가합니다.");
            return false;
        }
        else if (this.status.equals("차고지")) {
            System.out.println(this.number + "번 택시는 마감 했으므로 승차가 불가합니다.");
            return false;
        }
        else return false;

    }


    void arrive(){
        int charge = this.distanceCharge();
        this.fuel();
        System.out.println("목적지에 도착했습니다. 요금은 "+charge+"원 입니다.");
        boardingInfo.boardingPayment(charge);
        this.income += charge;
        this.status = "일반";
        this.destination ="";
    }
    @Override
    void showInfo(){
        if(status.equals("운행중")) {
            System.out.println(this.number + "번 택시는 현재 "
                    + this.status + " 상태이며 목적지 " + this.destination + "로 이동 중입니다.");
        }
        else if(this.status.equals("일반")) System.out.println(this.number+"번 택시는 현재 대기(일반) 상태입니다.");
        else if(this.status.equals("차고지")) System.out.println(this.number+"번 택시는 현재 운행 마감 상태입니다.");
    }

    int distanceCharge(){
        this.sumFares = boardingInfo.destinationDistance * this.distanceFares + this.basicFares;
        return sumFares;
    }

    void endService(){
        System.out.println(this.number+"번 택시 마감");
        System.out.println(this.number+"번 택시의 금일 수입은 "+this.income+"원이고, 잔여 연료는 "+this.suppliedGas+"입니다.");
        this.status = "차고지";
    }

    void fuel(){
        this.suppliedGas -= boardingInfo.destinationDistance * 3;   // 거리*3(연비)
        if(this.suppliedGas == 0){
            this.status ="차고지";
        }
        else if(this.suppliedGas < 10){
            System.out.println("연료 보충이 필요합니다.");
        }
    }
}
