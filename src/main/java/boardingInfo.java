class BoardingInfo {
//    택시 정보
    String destination;
    int destinationDistance;
    Passenger passenger;
    Taxi taxi;


    public BoardingInfo(Passenger passenger, Taxi taxi, String destination, int destinationDistance) {
        this.taxi = taxi;
        this.passenger = passenger;
        this.destination = destination;
        this.destinationDistance = destinationDistance;
    }

    public void boardingPayment(int charge){
        this.passenger.hasMoney -= charge;
    }
}
