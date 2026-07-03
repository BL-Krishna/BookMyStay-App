package bookmystay.repository;

import bookmystay.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class BookingHistoryRepository {

    private final List<Reservation> reservations =
            new ArrayList<>();

    public void save(Reservation reservation) {

        reservations.add(reservation);

    }

    public List<Reservation> findAll() {

        return reservations;

    }

    public Reservation findByReservationId(
            String reservationId) {

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId()
                    .equalsIgnoreCase(reservationId)) {

                return reservation;

            }

        }

        return null;

    }

    public List<Reservation> findByCustomerName(
            String customerName) {

        List<Reservation> result =
                new ArrayList<>();

        for (Reservation reservation : reservations) {

            if (reservation.getCustomerName()
                    .equalsIgnoreCase(customerName)) {

                result.add(reservation);

            }

        }

        return result;

    }

}