package bookmystay.util;

import bookmystay.model.RoomType;

import java.util.HashMap;
import java.util.Map;

public class RoomIdGenerator {

    private static final Map<RoomType, Integer> counters =
            new HashMap<>();

    public static String generate(RoomType roomType) {

        counters.putIfAbsent(roomType, 1);

        int number = counters.get(roomType);

        counters.put(roomType, number + 1);

        return switch (roomType) {

            case SINGLE -> "S" + String.format("%03d", number);

            case DOUBLE -> "D" + String.format("%03d", number);

            case SUITE -> "SU" + String.format("%03d", number);

        };

    }

}