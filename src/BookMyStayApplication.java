import bookmystay.model.Reservation;
import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.*;
import bookmystay.service.*;

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

        BookingHistoryRepository historyRepository =
                new BookingHistoryRepository();

        BookingHistoryService bookingHistoryService =
                new BookingHistoryService(
                        historyRepository);

        BookingService bookingService =
                new BookingService(
                        bookingRepository,
                        inventoryRepository,
                        allocationRepository,
                        bookingHistoryService
                );

        ServiceRepository serviceRepository =
                new ServiceRepository();
        ServiceManagementService serviceManagementService =
                new ServiceManagementService(
                        serviceRepository);
        Reservation reservation =
                new Reservation(

                        "RES001",

                        "Krrish",

                        RoomType.SINGLE,

                        2

                );

        bookingService.requestBooking(
                reservation);
        serviceManagementService.addBreakfast(
                "RES001");

        serviceManagementService.addSpa(
                "RES001");

        serviceManagementService.addAirportPickup(
                "RES001");

        serviceManagementService.displayServices(
                "RES001");

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
                        "RES001",
                        "Krrish",
                        RoomType.SINGLE,
                        2
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "RES002",
                        "Rahul",
                        RoomType.SINGLE,
                        1
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "RES003",
                        "Ajay",
                        RoomType.DOUBLE,
                        3
                )
        );

        bookingService.requestBooking(
                new Reservation(
                        "RES004",
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

        bookingHistoryService.displayBookingHistory();

        bookingHistoryService.searchReservation(
                "RES001");

        bookingHistoryService.searchCustomer(
                "Krrish");

        bookingHistoryService.cancelReservation(
                "RES002");

        bookingHistoryService.displayBookingHistory();
    }

}