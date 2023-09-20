# EventManager Lab - Java Programming

## Overview
This lab is designed to teach you the principles of Object-Oriented Programming (OOP) with a focus on encapsulation and aggregation. You'll build a simple Event Manager system that handles events with details such as names, dates, and locations.

## Classes

### `Event` Class

**Description**:  
The `Event` class is responsible for holding information about an individual event.

#### Attributes:
- `name` : String - The name of the event
- `date` : String - The date of the event in the format "YYYY-MM-DD"
- `location` : String - The location of the event

#### Methods:
- `Constructor` - Initializes the attributes with provided values
- `Getters and Setters` - For each attribute
- `toString()` - Returns a String representation of the event

---

### `Person` Class

**Description**:  
Represents an individual who can attend events. Interacts with the `EventManager` class.

#### Attributes:
- `name` : String - A string representing the name of the person.
- `email` : String - A string representing the email address of the person.
- `eventsAttending` : ArrayList<Event> - An ArrayList holding the events the person is attending.

#### Methods:
- `addEvent(Event event)` - Adds an event to the person's list of events they are attending.
- `listEventsOn(String date)` - Returns a list of events the person is attending on a specific date.
- `toString()` - Returns a string representation of the person, typically including their name and email.

---

### `EventManager` Class

**Description**:  
The `EventManager` class is responsible for managing multiple events. It aggregates instances of the `Event` class.

#### Attributes:
- `events` : ArrayList<Event> - List of events managed

#### Methods:
- `addEvent(Event event)` - Adds a new event to the list
- `listEventsOn(String date)` - Lists all events on a particular date
- `isEventToday()` - Returns true if there is an event today, false otherwise
- `toString()` - Returns a String representation of all events managed