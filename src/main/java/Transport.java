public abstract class Transport {
    static int count = 0;
    int suppliedGas;                  //주유량
    int currentSpeed;                 //현재 속도
    String status;
    int number;                       //각 인스턴스 고유 번호
    {
        ++count;                      //인스턴스가 생성될 떄마다 count증가
        number = count;               //객체 고유 번호지정
    }


    void showInfo(){}

}
