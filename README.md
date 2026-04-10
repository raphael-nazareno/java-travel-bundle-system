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


  

