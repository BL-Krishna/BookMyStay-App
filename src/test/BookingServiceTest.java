package test;

import bookmystay.model.Reservation;
import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.BookingRepository;
import bookmystay.repository.InventoryRepository;
import bookmystay.service.BookingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    @Test
    void testBookingQueueFIFO() {

        BookingRepository bookingRepository =
                new BookingRepository();

        InventoryRepository inventoryRepository =
                new InventoryRepository();

        inventoryRepository.save(

                new Room(

                        RoomType.SINGLE,

                        5,

                        1500,

                        "WiFi"

                )

        );

        BookingService bookingService =
                new BookingService(

                        bookingRepository,

                        inventoryRepository

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

        assertEquals(

                2,

                bookingRepository.size()

        );

    }
}