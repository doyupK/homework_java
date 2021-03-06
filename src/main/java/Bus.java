public class Bus extends Transport{
    int maxPassenger;               // 최대 승객
    int currentPassenger;           // 현재 승객
    int fares;                      // 요금
    int income;                     // 금일 수입
    String status= "운행";          //초기값 "운행"

    public Bus(int maxPassenger, int fares, int suppliedGas) {
        this.maxPassenger = maxPassenger;
        this.fares = fares;
        this.suppliedGas = suppliedGas;
    }

    void ride(){    // 1= 운행 / 0 = 차고지
        if(this.suppliedGas >= 20) this.status = "운행";
        else {
            System.out.println("연료가 20 미만입니다. 연료 보충을 한 뒤 운행 해주세요.");
            this.status = "차고지";
        }
    }

    void setSuppliedGas(int liter){         // 주유량이 10 미만이면 메시지 출력
        this.suppliedGas = liter;
        if(this.suppliedGas<10) System.out.println("주유가 더 필요합니다");

    }
    void changeSpeed(int speed){
        if(this.suppliedGas<10){
            System.out.println("속도 변경 불가, 주유량을 확인해주세요");
        }
        else{
            System.out.println("속도 변경 "+this.currentSpeed+"==>"+speed);
            this.currentSpeed = speed;
        }
    }

    boolean take(int fares){
        if(this.status.equals("운행")) {
            if (currentPassenger < maxPassenger) {
                this.currentPassenger += 1;
                this.income += fares;
                return true;
            } else {
                System.out.println("현재 " + this.number + "번 버스는 승객 만원으로 탑승 불가합니다.");
                return false;
            }
        }
        else{
            System.out.println("현재 " + this.number + "번 버스는 차고지이므로 탑승 불가합니다.");
            return false;
        }
    }

    @Override
    void showInfo(){
        if(status.equals("운행")) {
            System.out.println(number + "번 버스는 현재 "
                    + this.status + " 상태이며 요금은 " + fares + "원 이고, 현재 승객은" + currentPassenger + "명 입니다. 남은 연료는 "+
                    this.suppliedGas+" 입니다.");
        } else if (status.equals("차고지")) {
            System.out.println("현재 차고지에 대기중입니다.");
        }

    }

    void endService(){
        System.out.println("차고지에 도착했습니다.");
        System.out.println("금일 수입은 "+this.fares+"원이고, 잔여 연료는 "+this.suppliedGas+"입니다.");
        if(this.suppliedGas < 10){
            System.out.println("연료 보충이 필요합니다.");
        }
        this.status = "차고지";
    }

}
