package bookmystay.service;

import bookmystay.exception.RoomNotFoundException;
import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.InventoryRepository;

public class SearchService {

    private final InventoryRepository repository;

    public SearchService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void displayAvailableRooms() {

        System.out.println("\n===== AVAILABLE ROOMS =====");

        repository.findAll()
                .stream()
                .filter(room -> room.getAvailableRooms() > 0)
                .forEach(room -> {

                    System.out.println("----------------------------");
                    System.out.println("Room Type : " + room.getRoomType());
                    System.out.println("Available : " + room.getAvailableRooms());
                    System.out.println("Price     : ₹" + room.getPricePerNight());
                    System.out.println("Amenities : " + room.getAmenities());

                });
    }

    public void displayRoomDetails(RoomType roomType) {

        Room room = repository.findByRoomType(roomType);

        if (room == null) {
            throw new RoomNotFoundException(roomType + " room not found.");
        }

        System.out.println("\n===== ROOM DETAILS =====");

        System.out.println("Room Type : " + room.getRoomType());
        System.out.println("Available : " + room.getAvailableRooms());
        System.out.println("Price     : ₹" + room.getPricePerNight());
        System.out.println("Amenities : " + room.getAmenities());

    }

    public boolean isRoomAvailable(RoomType roomType) {

        Room room = repository.findByRoomType(roomType);

        if (room == null) {
            throw new RoomNotFoundException(roomType + " room not found.");
        }

        return room.getAvailableRooms() > 0;
    }
}