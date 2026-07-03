package bookmystay.service;

import bookmystay.model.Service;
import bookmystay.repository.ServiceRepository;

public class ServiceManagementService {

    private final ServiceRepository repository;

    public ServiceManagementService(
            ServiceRepository repository) {

        this.repository = repository;
    }

    public void addBreakfast(
            String reservationId) {

        repository.addService(

                reservationId,

                new Service(
                        "Breakfast",
                        500
                )
        );

    }

    public void addSpa(
            String reservationId) {

        repository.addService(

                reservationId,

                new Service(
                        "Spa",
                        2500
                )
        );

    }

    public void addAirportPickup(
            String reservationId) {

        repository.addService(

                reservationId,

                new Service(
                        "Airport Pickup",
                        1500
                )
        );

    }

    public void addLaundry(
            String reservationId) {

        repository.addService(

                reservationId,

                new Service(
                        "Laundry",
                        800
                )
        );

    }

    public void addDinner(
            String reservationId) {

        repository.addService(

                reservationId,

                new Service(
                        "Dinner",
                        1200
                )
        );

    }

    public void displayServices(
            String reservationId) {

        repository.displayServices(
                reservationId);

    }

}