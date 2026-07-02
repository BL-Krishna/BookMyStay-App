package bookmystay.service;

import bookmystay.model.Reservation;
import bookmystay.model.Room;
import bookmystay.repository.BookingRepository;
import bookmystay.repository.InventoryRepository;

public class BookingService {

    private final BookingRepository bookingRepository;

    private final InventoryRepository inventoryRepository;

    public BookingService(BookingRepository bookingRepository,
                          InventoryRepository inventoryRepository) {

        this.bookingRepository = bookingRepository;
        this.inventoryRepository = inventoryRepository;
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

        room.setAvailableRooms(

                room.getAvailableRooms() - 1

        );

        System.out.println();

        System.out.println("Booking Confirmed");

        System.out.println(reservation);

    }

    public void displayWaitingQueue() {

        System.out.println();

        System.out.println("===== Booking Queue =====");

        bookingRepository.displayQueue();

    }
}