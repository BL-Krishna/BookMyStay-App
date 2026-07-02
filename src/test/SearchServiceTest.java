package test;

import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.InventoryRepository;
import bookmystay.service.SearchService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {

    @Test
    void testRoomAvailable() {

        InventoryRepository repository = new InventoryRepository();

        repository.save(
                new Room(RoomType.SINGLE,
                        10,
                        1500,
                        "WiFi"));

        SearchService searchService =
                new SearchService(repository);

        assertTrue(
                searchService.isRoomAvailable(RoomType.SINGLE));
    }

    @Test
    void testRoomUnavailable() {

        InventoryRepository repository = new InventoryRepository();

        repository.save(
                new Room(RoomType.SUITE,
                        0,
                        5000,
                        "Luxury"));

        SearchService searchService =
                new SearchService(repository);

        assertFalse(
                searchService.isRoomAvailable(RoomType.SUITE));
    }
}
