package test;

import bookmystay.model.Reservation;
import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.BookingRepository;
import bookmystay.repository.InventoryRepository;
import bookmystay.repository.RoomAllocationRepository;
import bookmystay.service.BookingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingAllocationTest {

    @Test
    void shouldAllocateUniqueRoomIds() {

        InventoryRepository inventoryRepository =
                new InventoryRepository();

        inventoryRepository.save(
                new Room(
                        RoomType.SINGLE,
                        2,
                        1800,
                        "WiFi"
                )
        );

        BookingService bookingService =
                new BookingService(
                        new BookingRepository(),
                        inventoryRepository,
                        new RoomAllocationRepository()
                );

        bookingService.requestBooking(
                new Reservation(
                        "A",
                        RoomType.SINGLE,
                        1
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "B",
                        RoomType.SINGLE,
                        1
                )
        );

        bookingService.processNextBooking();

        bookingService.processNextBooking();

        assertEquals(
                0,
                inventoryRepository
                        .findByRoomType(RoomType.SINGLE)
                        .getAvailableRooms()
        );

    }

}