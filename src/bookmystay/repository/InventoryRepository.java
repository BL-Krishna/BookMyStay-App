package bookmystay.repository;

import bookmystay.model.Room;
import bookmystay.model.RoomType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryRepository {

    private final Map<RoomType, Room> inventory = new HashMap<>();

    public void save(Room room) {

        inventory.put(room.getRoomType(), room);

    }

    public Room findByRoomType(RoomType roomType) {

        return inventory.get(roomType);

    }

    public boolean exists(RoomType roomType) {

        return inventory.containsKey(roomType);

    }

    public Collection<Room> findAll() {

        return inventory.values();

    }

    public void delete(RoomType roomType) {

        inventory.remove(roomType);

    }

}