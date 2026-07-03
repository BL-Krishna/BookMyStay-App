package bookmystay.repository;

import bookmystay.model.Service;

import java.util.*;

public class ServiceRepository {

    private final Map<String, List<Service>> reservationServices =
            new HashMap<>();

    public void addService(String reservationId,
                           Service service) {

        reservationServices

                .computeIfAbsent(
                        reservationId,
                        id -> new ArrayList<>()
                )

                .add(service);

    }

    public List<Service> getServices(
            String reservationId) {

        return reservationServices.getOrDefault(
                reservationId,
                new ArrayList<>());

    }

    public double calculateTotalServiceCost(
            String reservationId) {

        return getServices(reservationId)

                .stream()

                .mapToDouble(Service::getPrice)

                .sum();

    }

    public void displayServices(
            String reservationId) {

        System.out.println();

        System.out.println(
                "Services for Reservation : "
                        + reservationId);

        List<Service> services =
                getServices(reservationId);

        if (services.isEmpty()) {

            System.out.println("No Services Selected");

            return;

        }

        services.forEach(System.out::println);

        System.out.println();

        System.out.println(
                "Total Service Cost : ₹"
                        + calculateTotalServiceCost(
                        reservationId));

    }

}