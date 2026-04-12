# Mt Buller Travel Bundle System

## Overview
This project is a Java console application developed for a university assignment. It simulates a booking system for Mt Buller Ski Resort, allowing customers to create customised travel bundles that can include accommodation, lift passes, and ski lessons.

The application was designed using object-oriented programming principles and includes inheritance, abstraction, interfaces, enums, exception handling, input validation, sorting/filtering features, and binary file persistence.

## Features

### Core Features
- Display all accommodations
- Display available accommodations
- Add new customers
- List all customers
- Create a travel bundle for a customer
- List all bundles
- Add a lift pass to a bundle
- Add ski lessons to a bundle
- Save bundles to a file (binary format)
- Load bundles from a file

### Additional Features
- Display total bundle price
- Display bundle start date and end date
- Prevent duplicate lift passes in a bundle
- Prevent duplicate lesson entries in a bundle
- Cancel a bundle and release its accommodation
- Filter accommodations by type
- Filter accommodations by maximum price
- Sort accommodations by price

## System Design

### Main Classes

- **Accommodation (Abstract Class)**  
  Base class for all accommodation types.  
  Stores shared accommodation data such as ID, name, price per night, availability, and accommodation type.  
  Subclasses include:
  - HotelRoom
  - Apartment
  - LodgeRoom  

- **Customer**  
  Stores customer details including name, age, gender, and skiing level.

- **TravelBundle**  
  Represents a booking made by a customer.  
  Stores the customer, accommodation, bundle start date (as `LocalDate`), duration, optional lift pass, and optional lessons.  
  It also calculates accommodation cost, total bundle price, and bundle end date based on the start date and duration.

- **BundleItem (Abstract Class)**  
  Abstract parent class for optional bundle add-ons such as `LiftPass` and `Lesson`.

- **LiftPass**  
  Represents a lift pass and calculates pricing based on duration.

- **Lesson**  
  Represents ski lessons and calculates pricing based on skiing level and lesson count.

- **MtBullerResort**  
  Acts as the system manager and stores all customers, accommodations, and bundles using `ArrayList`s.  
  It also handles validation, sorting, filtering, saving/loading, and bundle cancellation.

- **MtBullerAdmin**  
  Contains the `main` method and provides the menu-driven user interface.

## Object-Oriented Concepts Used

- **Abstraction**  
  `Accommodation` and `BundleItem` are abstract classes used to model shared behaviour across related classes.

- **Inheritance**  
  `HotelRoom`, `Apartment`, and `LodgeRoom` extend `Accommodation`.  
  `LiftPass` and `Lesson` extend `BundleItem`.

- **Encapsulation**  
  Class attributes are private and accessed through getters/setters where appropriate.

- **Interfaces**  
  - `Pricable` is used for classes that can calculate a price.
  - `Bookable` is used for classes that can be reserved and have availability updated.

- **Enums**  
  - `SkiingLevel` represents customer skiing levels.
  - `AccommodationType` represents accommodation categories.

## Pricing Logic

### Accommodation
- Accommodation cost = nightly price × duration

### Lift Pass
- $26 per day
- 10% discount applied for bookings of 5 days or more
- $200 flat rate for a 30-day (season) pass

### Lessons
- Beginner: $25 per lesson
- Intermediate: $20 per lesson
- Expert: $15 per lesson
- Total lesson cost is calculated based on the number of lessons selected

### Bundle Total
Total bundle price includes:
- Accommodation cost
- Optional lift pass
- Optional lessons

## Data Persistence

- Travel bundles are saved to a binary file using `ObjectOutputStream`
- Bundles are loaded from a binary file using `ObjectInputStream`
- The file used is `bundles.dat`
- Relevant classes implement `Serializable` to support object persistence
- Bundles are displayed immediately after loading
- Accommodation availability is restored correctly after loading
- Bundle IDs and customer IDs continue correctly after loading
- Customers from loaded bundles are restored into the customer list

## Input Validation & Error Handling

- User prompts clearly indicate expected input formats
- Blank input is validated and handled gracefully
- Invalid IDs (customer, accommodation, bundle) are handled gracefully
- Numeric input is validated using parsing with `try-catch`
- Validation is applied to ensure:
  - Age is greater than 0
  - Duration is greater than 0
  - Lesson count is greater than 0
  - Lesson count cannot exceed bundle duration
  - Lift pass length is greater than 0
  - Lift pass length cannot exceed bundle duration unless it is a 30-day season pass
  - Arrival date is valid and must use `YYYY-MM-DD`
  - Arrival date cannot be in the past
  - Bundles cannot be created when no accommodations are available
- Try-catch blocks are used for:
  - File operations (saving and loading data)
  - Handling invalid enum input (skiing level and accommodation type)
  - Handling invalid numeric input
- A custom exception is implemented to handle unavailable accommodation during booking
- Duplicate lift passes and duplicate lesson entries are prevented

## Bonus Features

The project also includes additional features beyond the core requirements:
- Cancel a bundle
- Sort accommodations by price
- Filter accommodations by maximum price
- Filter accommodations by type
- Display bundle end date
- Display total bundle price

## How to Run

Compile the project:

```bash
javac mtbuller/*.java
```
Run the application:
```bash
java mtbuller.MtBullerAdmin.java
```
## Notes

- A bundle must include accommodation
- Lift passes and lessons are optional additions
- Each accommodation can only be booked once and becomes unavailable after booking
- Canceling a bundle makes its accommodation available again
- Lift pass duration determines pricing, including discounts and season pass pricing
- Lesson cost is based on customer skiing level and number of lessons
- The system starts with an initial list of accommodations and customers
- Bundles display both start date and end date

## AI Acknowledgement

This project was developed with assistance from AI tools (ChatGPT) for guidance, debugging, and concept clarification. All code has been reviewed, understood, and adapted by the author.

## Resources

The following resources were used to support the development of this project:

- **Java Full Course for Beginners** - YouTube  
  https://www.youtube.com/watch?v=eIrMbAQSU34

- **W3Schools Java Tutorial**  
  https://www.w3schools.com/java/default.asp

- **RMIT University, COSC2395 Programming A**  
  Course lectures and lab materials.
  
## Author

Raphael Manalo








