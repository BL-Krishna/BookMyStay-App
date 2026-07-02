import bookmystay.model.Room;
import bookmystay.model.RoomType;
import bookmystay.service.InventoryService;

public class BookMyStayApplication {

    public static void main(String[] args) {

        InventoryService inventoryService =
                new InventoryService();

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

                        5,

                        7000,

                        "WiFi, AC, TV, Jacuzzi"

                )

        );

        inventoryService.displayInventory();

        System.out.println();

        System.out.println(

                "Single Available : "

                        + inventoryService.checkAvailability(

                        RoomType.SINGLE

                )

        );

    }

}