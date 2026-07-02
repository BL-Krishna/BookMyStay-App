package bookmystay.repository;

import bookmystay.model.Reservation;

import java.util.LinkedList;
import java.util.Queue;

public class BookingRepository {

    private final Queue<Reservation> bookingQueue =
            new LinkedList<>();

    public void addReservation(Reservation reservation) {

        bookingQueue.offer(reservation);

    }

    public Reservation processReservation() {

        return bookingQueue.poll();

    }

    public Reservation peekReservation() {

        return bookingQueue.peek();

    }

    public boolean isEmpty() {

        return bookingQueue.isEmpty();

    }

    public int size() {

        return bookingQueue.size();

    }

    public void displayQueue() {

        bookingQueue.forEach(System.out::println);

    }
}