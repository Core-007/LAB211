//Chứa thông tin chuyến bay
public class FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private String timePickUp; // Để đơn giản, ta lưu thời gian dưới dạng chuỗi

    public FlightInformation(String flightNumber, String seatNumber, String timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = "";
    }

    // Getter và Setter
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getTimePickUp() {
        return timePickUp;
    }

    public void setTimePickUp(String timePickUp) {
        this.timePickUp = timePickUp;
    }
}
