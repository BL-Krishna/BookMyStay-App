import bookmystay.model.Reservation;
import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.BookingRepository;
import bookmystay.repository.InventoryRepository;
import bookmystay.service.BookingService;
import bookmystay.service.InventoryService;
import bookmystay.service.SearchService;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryRepository inventoryRepository =
                new InventoryRepository();

        BookingRepository bookingRepository =
                new BookingRepository();

        InventoryService inventoryService =
                new InventoryService(inventoryRepository);

        SearchService searchService =
                new SearchService(inventoryRepository);

        BookingService bookingService =
                new BookingService(

                        bookingRepository,

                        inventoryRepository

                );

        inventoryService.addRoom(

                new Room(

                        RoomType.SINGLE,

                        2,

                        1800,

                        "WiFi"

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

        bookingService.displayWaitingQueue();

        bookingService.processNextBooking();

        bookingService.processNextBooking();

        bookingService.processNextBooking();

        inventoryService.displayInventory();

    }
}