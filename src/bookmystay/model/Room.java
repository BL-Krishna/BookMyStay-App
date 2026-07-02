package bookmystay.model;

public class Room {

    private RoomType roomType;

    private int availableRooms;

    private double pricePerNight;

    private String amenities;

    public Room(RoomType roomType,
                int availableRooms,
                double pricePerNight,
                String amenities) {

        this.roomType = roomType;
        this.availableRooms = availableRooms;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {

        return "Room{" +
                "roomType=" + roomType +
                ", availableRooms=" + availableRooms +
                ", pricePerNight=" + pricePerNight +
                ", amenities='" + amenities + '\'' +
                '}';
    }
}
