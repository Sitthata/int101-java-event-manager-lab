package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventManagerTest {
    private Event event1, event2;
    private EventManager manager;
    private Person person;

    @BeforeEach
    public void setUp() {
        // Setting up objects for each test case
        event1 = new Event("Tech Conference", "2023-10-10", "San Francisco");
        event2 = new Event("Music Fest", "2023-11-20", "New York");
        manager = new EventManager();
        person = new Person("John Doe", "john@example.com");
    }

    @Test
    public void testEventDetails() {
        assertEquals("Event: Tech Conference, Date: 2023-10-10, Location: San Francisco", event1.getEventDetails());
    }

    @Test
    public void testIsEventToday() {
        assertTrue(event1.isEventToday("2023-10-10"));
    }

    @Test
    public void testListEventsOn() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Adding events to the manager
        manager.addEvent(event1);
        manager.addEvent(event2);

        manager.listEventsOn("2023-10-10");

        // Restore original System.out
        System.setOut(originalOut);

        String expectedOutput = "Event: Tech Conference, Date: 2023-10-10, Location: San Francisco\n";
        // Normalize line endings for comparison
        String normalizedOutContent = outContent.toString().replace("\r\n", "\n");
        String normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n");
        assertEquals(normalizedExpectedOutput, normalizedOutContent);
    }

    @Test
    public void testPersonAddEvent() {
        person.addEvent(event1);
        ArrayList<Event> expectedEvents = new ArrayList<>();
        expectedEvents.add(event1);
        assertEquals(expectedEvents, person.getEventsAttending());
    }

    @Test
    public void testPersonListEventsOn() {
        person.addEvent(event1);
        person.addEvent(event2);

        ArrayList<Event> expectedEventsOnDate = new ArrayList<>();
        expectedEventsOnDate.add(event1);
        assertEquals(expectedEventsOnDate, person.listEventsOn("2023-10-10"));
    }
}