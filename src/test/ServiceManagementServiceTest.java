package test;

import bookmystay.repository.ServiceRepository;
import bookmystay.service.ServiceManagementService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceManagementServiceTest {

    @Test
    void shouldCalculateTotalCost() {

        ServiceRepository repository =
                new ServiceRepository();

        ServiceManagementService service =
                new ServiceManagementService(
                        repository);

        service.addBreakfast("RES001");
        service.addSpa("RES001");

        assertEquals(
                3000,
                repository.calculateTotalServiceCost(
                        "RES001"));
    }

    @Test
    void shouldAllowMultipleServices() {

        ServiceRepository repository =
                new ServiceRepository();

        ServiceManagementService service =
                new ServiceManagementService(
                        repository);

        service.addBreakfast("RES001");
        service.addSpa("RES001");
        service.addAirportPickup("RES001");

        assertEquals(
                3,
                repository.getServices("RES001")
                        .size());
    }

    @Test
    void shouldReturnEmptyForUnknownReservation() {

        ServiceRepository repository =
                new ServiceRepository();

        assertTrue(
                repository.getServices("ABC")
                        .isEmpty());
    }
}