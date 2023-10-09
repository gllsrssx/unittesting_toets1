package Elevator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ElevatorTest {
    @Test
    void testActiveButtonsNoBadge() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Elevator.activeButtons(null, 0);
        });
        Assertions.assertEquals("No badge scanned", exception.getMessage());
    }

    @Test
    void testActiveButtonsInvalidCurrentLevel() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Elevator.activeButtons("S", -3);
        });
        Assertions.assertEquals("Invalid current level: -3", exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Elevator.activeButtons("S", 11);
        });
        Assertions.assertEquals("Invalid current level: 11", exception.getMessage());
    }

    @Test
    void testActiveButtonsStaffBadge() throws Exception {
        List<Integer> expected = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> actual = Elevator.activeButtons("S", 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testActiveButtonsRoomBadge() throws Exception {
        List<Integer> expected = Arrays.asList(4, 0, 10);
        List<Integer> actual = Elevator.activeButtons("405", 10);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testActiveButtonsInvalidBadge() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Elevator.activeButtons("X", 0);
        });
        Assertions.assertEquals("Invalid badge: X", exception.getMessage());
    }

    @Test
    void testActiveButtonsNotAllowed() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            Elevator.activeButtons("405", 5);
        });
        Assertions.assertEquals("Alarm: current level not allowed for badge", exception.getMessage());
    }
}