package test;

import bookmystay.model.Reservation;
import bookmystay.model.ReservationStatus;
import bookmystay.model.RoomType;
import bookmystay.repository.BookingHistoryRepository;
import bookmystay.service.BookingHistoryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingHistoryServiceTest {

    @Test
    void shouldCancelReservation() {

        BookingHistoryRepository repository =
                new BookingHistoryRepository();

        BookingHistoryService service =
                new BookingHistoryService(repository);

        Reservation reservation =
                new Reservation(
                        "RES001",
                        "Krrish",
                        RoomType.SINGLE,
                        2
                );

        service.saveReservation(reservation);

        service.cancelReservation("RES001");

        assertEquals(
                ReservationStatus.CANCELLED,
                repository.findByReservationId("RES001")
                        .getStatus()
        );

    }

}