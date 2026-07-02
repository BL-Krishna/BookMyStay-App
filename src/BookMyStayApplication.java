import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.repository.InventoryRepository;
import bookmystay.service.InventoryService;
import bookmystay.service.SearchService;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryRepository repository =
                new InventoryRepository();

        InventoryService inventoryService =
                new InventoryService(repository);

        SearchService searchService =
                new SearchService(repository);

        inventoryService.addRoom(
                new Room(
                        RoomType.SINGLE,
                        20,
                        1800,
                        "WiFi, AC"
                )
        );

        inventoryService.addRoom(
                new Room(
                        RoomType.DOUBLE,
                        15,
                        3000,
                        "WiFi, AC, TV"
                )
        );

        inventoryService.addRoom(
                new Room(
                        RoomType.SUITE,
                        0,
                        7000,
                        "WiFi, AC, TV, Jacuzzi"
                )
        );

        inventoryService.displayInventory();

        searchService.displayAvailableRooms();

        searchService.displayRoomDetails(RoomType.DOUBLE);

        System.out.println();

        System.out.println("Suite Available : "
                + searchService.isRoomAvailable(RoomType.SUITE));

    }
}