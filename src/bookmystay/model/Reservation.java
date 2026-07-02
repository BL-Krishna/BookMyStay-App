package bookmystay.model;

public class Reservation {

    private String customerName;

    private RoomType roomType;

    private int nights;

    public Reservation(String customerName,
                       RoomType roomType,
                       int nights) {

        this.customerName = customerName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String getCustomerName() {
        return customerName;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {

        return "Reservation{" +
                "customerName='" + customerName + '\'' +
                ", roomType=" + roomType +
                ", nights=" + nights +
                '}';
    }
}