package bookmystay.service;

import bookmystay.model.Reservation;
import bookmystay.model.ReservationStatus;
import bookmystay.model.Room;
import bookmystay.repository.BookingRepository;
import bookmystay.repository.InventoryRepository;
import bookmystay.repository.RoomAllocationRepository;
import bookmystay.util.RoomIdGenerator;

public class BookingService {

    private final BookingRepository bookingRepository;

    private final InventoryRepository inventoryRepository;

    private final RoomAllocationRepository allocationRepository;

    private final BookingHistoryService bookingHistoryService;

    public BookingService(
            BookingRepository bookingRepository,
            InventoryRepository inventoryRepository,
            RoomAllocationRepository allocationRepository,
            BookingHistoryService bookingHistoryService) {

        this.bookingRepository = bookingRepository;
        this.inventoryRepository = inventoryRepository;
        this.allocationRepository = allocationRepository;
        this.bookingHistoryService = bookingHistoryService;

    }
    public void requestBooking(Reservation reservation) {

        Room room =
                inventoryRepository.findByRoomType(
                        reservation.getRoomType());

        if (room == null) {

            System.out.println("Room Type Not Found.");

            return;
        }

        if (room.getAvailableRooms() <= 0) {

            System.out.println(
                    "No rooms available for "
                            + reservation.getRoomType());

            return;
        }

        bookingRepository.addReservation(reservation);

        System.out.println(
                reservation.getCustomerName()
                        + " added to booking queue.");

    }

    public void processNextBooking() {

        Reservation reservation =
                bookingRepository.processReservation();

        if (reservation == null) {

            System.out.println("Booking Queue Empty.");

            return;

        }

        Room room =
                inventoryRepository.findByRoomType(
                        reservation.getRoomType());

        if (room.getAvailableRooms() <= 0) {

            System.out.println("No rooms available.");

            return;

        }

        String roomId =
                RoomIdGenerator.generate(
                        reservation.getRoomType());

        allocationRepository.allocateRoom(
                reservation.getRoomType(),
                roomId);

        reservation.setAllocatedRoomId(roomId);

        reservation.setStatus(
                ReservationStatus.CONFIRMED);

        bookingHistoryService.saveReservation(
                reservation);

        room.setAvailableRooms(

                room.getAvailableRooms() - 1

        );

        System.out.println();

        System.out.println();

        System.out.println("========================================");
        System.out.println("BOOKING CONFIRMED");
        System.out.println("========================================");

        System.out.println("Customer : "
                + reservation.getCustomerName());

        System.out.println("Room Type : "
                + reservation.getRoomType());

        System.out.println("Room ID : "
                + reservation.getAllocatedRoomId());

        System.out.println("Nights : "
                + reservation.getNights());

        System.out.println("========================================");

    }

    public void displayWaitingQueue() {

        System.out.println();

        System.out.println("========================================");
        System.out.println("CURRENT BOOKING QUEUE");
        System.out.println("========================================");

        bookingRepository.displayQueue();

        System.out.println("========================================");

    }
    public void displayAllocatedRooms() {

        allocationRepository.displayAllocatedRooms();

    }
}