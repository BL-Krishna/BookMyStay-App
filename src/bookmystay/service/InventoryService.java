package bookmystay.service;

import bookmystay.exception.RoomNotFoundException;
import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.InventoryRepository;

public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void addRoom(Room room) {
        repository.save(room);
    }

    public void updateInventory(RoomType roomType,
                                int newCount) {

        Room room = repository.findByRoomType(roomType);

        if (room == null) {
            throw new RoomNotFoundException(roomType + " room not found.");
        }

        room.setAvailableRooms(newCount);
    }

    public boolean checkAvailability(RoomType roomType) {

        Room room = repository.findByRoomType(roomType);

        if (room == null) {
            throw new RoomNotFoundException(roomType + " room not found.");
        }

        return room.getAvailableRooms() > 0;
    }

    public Room getRoom(RoomType roomType) {

        Room room = repository.findByRoomType(roomType);

        if (room == null) {
            throw new RoomNotFoundException(roomType + " room not found.");
        }

        return room;
    }

    public void displayInventory() {

        System.out.println("\n========= HOTEL INVENTORY =========");

        repository.findAll().forEach(System.out::println);
    }
}