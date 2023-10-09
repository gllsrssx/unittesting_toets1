package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {
    @Test
    void sayHello() {
        assertEquals("Hello world!", new Sample().sayHello("world"));
    }
}
