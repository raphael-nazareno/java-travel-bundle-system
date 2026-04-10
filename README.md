# Mt Buller Travel Bundle System

## Overview
This project is a Java console application developed for a university assignment. It simulates a booking system for Mt Buller Ski Resort, allowing customers to create customised travel bundles that can include accommodation, lift passes, and ski lessons.

The application was designed using object-oriented programming principles and includes features such as inheritance, abstraction, interfaces, exception handling, and file persistence.

## Features

- Display all accommodations
- Display available accommodations
- Add new customers
- List all customers
- Create a travel bundle for a customer
- Add a lift pass to a bundle
- Add ski lessons to a bundle
- Save bundles to a file (binary format)
- Load bundles from a file

## System Design

### Main Classes

- **Accommodation (Abstract Class)**  
  Base class for all accommodation types.  
  Subclasses include:
  - HotelRoom
  - Apartment
  - LodgeRoom  

- **Customer**  
  Stores customer details including name, age, gender, and skiing level.

- **TravelBundle**  
  Represents a booking made by a customer.  
  Includes accommodation and optional additions such as lift passes and lessons.

- **LiftPass**  
  Handles lift pass pricing based on duration.

- **Lesson**  
  Calculates lesson pricing based on skiing level and number of lessons.

- **MtBullerResort**  
  Acts as the system manager and stores all customers, accommodations, and bundles using ArrayLists.

- **MtBullerAdmin**  
  Contains the main method and provides the menu-driven user interface.

## Object-Oriented Concepts Used

- **Abstraction**  
  The `Accommodation` class is implemented as an abstract class to represent shared properties of different accommodation types.

- **Inheritance**  
  `HotelRoom`, `Apartment`, and `LodgeRoom` extend the `Accommodation` class.

- **Encapsulation**  
  All class attributes are private and accessed through getters and setters.

- **Interface**  
  The `Pricable` interface is implemented by `LiftPass` and `Lesson` to define a common pricing method.

- **Enum**  
  `SkiingLevel` is used to represent customer skill levels (Beginner, Intermediate, Expert).

## Pricing Logic

### Lift Pass
- $26 per day
- 10% discount applied for bookings of 5 days or more
- $200 flat rate for a 30-day (season) pass

### Lessons
- Beginner: $25 per lesson
- Intermediate: $20 per lesson
- Expert: $15 per lesson
- Total lesson cost is calculated based on the number of lessons selected

## Data Persistence

- Travel bundles are saved to a binary file using `ObjectOutputStream`
- Bundles are loaded from a binary file using `ObjectInputStream`
- The file used is `bundles.dat`
- All relevant classes implement `Serializable` to support object persistence

## Input Validation & Error Handling

- User prompts clearly indicate expected input formats
- Invalid IDs (customer, accommodation, bundle) are handled gracefully
- Validation is applied to ensure:
  - Age is greater than 0
  - Duration is greater than 0
  - Lesson count is valid
- Try-catch blocks are used for:
  - File operations (saving and loading data)
  - Handling invalid enum input (skiing level)
- A custom exception is implemented to handle unavailable accommodation during booking

## How to Run

1. Compile the project:
javac mtbuller/*.java

2. Run the application:
java mtbuller.MtBullerAdmin

## Notes

- A bundle must include accommodation
- Lift passes and lessons are optional additions
- Each accommodation can only be booked once (becomes unavailable after booking)
- Lift pass duration determines pricing, including discounts and season pass
- Lesson cost is based on customer skiing level and number of lessons

## AI Acknowledgement

This project was developed with assistance from AI tools (ChatGPT) for guidance, debugging, and concept clarification. All code has been reviewed, understood, and adapted by the author.

## Author

Raphael Manalo








