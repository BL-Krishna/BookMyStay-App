import bookmystay.model.Reservation;
import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.BookingRepository;
import bookmystay.repository.InventoryRepository;
import bookmystay.repository.RoomAllocationRepository;
import bookmystay.service.BookingService;
import bookmystay.service.InventoryService;
import bookmystay.service.SearchService;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryRepository inventoryRepository =
                new InventoryRepository();

        BookingRepository bookingRepository =
                new BookingRepository();

        RoomAllocationRepository allocationRepository =
                new RoomAllocationRepository();

        InventoryService inventoryService =
                new InventoryService(inventoryRepository);

        SearchService searchService =
                new SearchService(inventoryRepository);

        BookingService bookingService =
                new BookingService(
                        bookingRepository,
                        inventoryRepository,
                        allocationRepository
                );

        inventoryService.addRoom(
                new Room(
                        RoomType.SINGLE,
                        2,
                        1800,
                        "WiFi, AC"
                )
        );

        inventoryService.addRoom(
                new Room(
                        RoomType.DOUBLE,
                        1,
                        3000,
                        "WiFi, TV"
                )
        );

        inventoryService.addRoom(
                new Room(
                        RoomType.SUITE,
                        1,
                        7000,
                        "WiFi, TV, Jacuzzi"
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "Krrish",
                        RoomType.SINGLE,
                        2
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "Rahul",
                        RoomType.SINGLE,
                        1
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "Ajay",
                        RoomType.DOUBLE,
                        3
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "Priya",
                        RoomType.SUITE,
                        2
                )
        );

        bookingService.displayWaitingQueue();

        bookingService.processNextBooking();

        bookingService.processNextBooking();

        bookingService.processNextBooking();

        bookingService.processNextBooking();

        bookingService.displayAllocatedRooms();

        inventoryService.displayInventory();

        searchService.displayAvailableRooms();

    }

}