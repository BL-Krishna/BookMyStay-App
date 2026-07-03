package bookmystay.model;

public class Reservation {

    private String customerName;

    private RoomType roomType;

    private int nights;

    private String allocatedRoomId;

    private String reservationId;

    private ReservationStatus status;

    public Reservation(String reservationId,
                       String customerName,
                       RoomType roomType,
                       int nights) {

        this.reservationId = reservationId;
        this.customerName = customerName;
        this.roomType = roomType;
        this.nights = nights;
        this.status = ReservationStatus.PENDING;
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

    public String getAllocatedRoomId() {
        return allocatedRoomId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setAllocatedRoomId(String allocatedRoomId) {
        this.allocatedRoomId = allocatedRoomId;
    }
    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Reservation{" +
                "customerName='" + customerName + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", roomType=" + roomType +
                ", nights=" + nights +
                ", allocatedRoomId='" + allocatedRoomId + '\'' +
                ", status=" + status +
                '}';
    }
}