package bookmystay.repository;

import bookmystay.model.RoomType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoomAllocationRepository {

    // Stores all booked room ids
    private final Set<String> bookedRooms = new HashSet<>();

    // Stores allocated rooms by room type
    private final Map<RoomType, Set<String>> allocatedRooms =
            new HashMap<>();

    public boolean isBooked(String roomId) {
        return bookedRooms.contains(roomId);
    }

    public void allocateRoom(RoomType roomType,
                             String roomId) {

        bookedRooms.add(roomId);

        allocatedRooms
                .computeIfAbsent(roomType,
                        room -> new HashSet<>())
                .add(roomId);
    }

    public Set<String> getAllocatedRooms(RoomType roomType) {

        return allocatedRooms.getOrDefault(
                roomType,
                new HashSet<>());

    }

    public void displayAllocatedRooms() {

        System.out.println();

        System.out.println("===== Allocated Rooms =====");

        allocatedRooms.forEach((type, rooms) -> {

            System.out.println();

            System.out.println(type);

            System.out.println("-------------------");

            rooms.forEach(System.out::println);

        });

    }
}