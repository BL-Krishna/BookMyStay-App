package bookmystay.service;

import bookmystay.model.Reservation;
import bookmystay.model.ReservationStatus;
import bookmystay.repository.BookingHistoryRepository;

import java.util.List;

public class BookingHistoryService {

    private final BookingHistoryRepository repository;

    public BookingHistoryService(
            BookingHistoryRepository repository) {

        this.repository = repository;

    }

    public void saveReservation(
            Reservation reservation) {

        reservation.setStatus(
                ReservationStatus.CONFIRMED);

        repository.save(reservation);

    }

    public void cancelReservation(
            String reservationId) {

        Reservation reservation =
                repository.findByReservationId(
                        reservationId);

        if (reservation == null) {

            System.out.println("Reservation Not Found.");

            return;

        }

        reservation.setStatus(
                ReservationStatus.CANCELLED);

        System.out.println(
                reservationId + " Cancelled.");

    }

    public void displayBookingHistory() {

        System.out.println();

        System.out.println(
                "========== BOOKING HISTORY ==========");

        repository.findAll()

                .forEach(System.out::println);

    }

    public void searchReservation(
            String reservationId) {

        System.out.println();

        Reservation reservation =
                repository.findByReservationId(
                        reservationId);

        if (reservation == null) {

            System.out.println("Reservation Not Found.");

            return;

        }

        System.out.println(reservation);

    }

    public void searchCustomer(
            String customerName) {

        List<Reservation> reservations =
                repository.findByCustomerName(
                        customerName);

        reservations.forEach(System.out::println);

    }

}