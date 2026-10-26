package com.example.ci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class GreetingControllerUnitTest {
    @Test
    void greetingMessageIsPersonalized() {
        GreetingController controller = new GreetingController();
        assertEquals("Hello, Lakshya!", controller.greet("Lakshya").get("message"));
    }

    @Test
    void defaultGreetingIsAvailable() {
        GreetingController controller = new GreetingController();
        assertEquals("Hello, World!", controller.greet("World").get("message"));
    }
}
