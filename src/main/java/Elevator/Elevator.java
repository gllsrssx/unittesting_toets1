package Elevator;

import java.util.*;

public class Elevator {
    private static final int[] FLOORS = { -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    public static List<Integer> activeButtons(String badge, Integer currentLevel) throws Exception {
        if (currentLevel < -2 || currentLevel > 10) {
            throw new IllegalArgumentException("Invalid current level: " + currentLevel);
        }
        if (badge == null) {
            throw new IllegalArgumentException("No badge scanned");
        }
        List<Integer> activeButtons = new ArrayList<>();
        if (badge.equals("S")) {
            for (int floor : FLOORS) {
                activeButtons.add(floor);
            }
        } else if (badge.matches("\\d+")) {
            int roomFloor = Integer.parseInt(badge) / 100;
            if (roomFloor < 1 || roomFloor > 9) {
                throw new IllegalArgumentException("Invalid room floor: " + roomFloor);
            }
            activeButtons.add(roomFloor);
            activeButtons.add(0);
            activeButtons.add(10);
        } else {
            throw new IllegalArgumentException("Invalid badge: " + badge);
        }
        if (!activeButtons.contains(currentLevel)) {
            throw new Exception("Alarm: current level not allowed for badge");
        }
        return activeButtons;
    }
}