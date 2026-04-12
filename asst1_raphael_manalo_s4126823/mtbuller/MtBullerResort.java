package mtbuller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MtBullerResort {
    private ArrayList<Customer> customers;
    private ArrayList<Accommodation> accommodations;
    private ArrayList<TravelBundle> travelBundles;
    private final Scanner scanner;

    public MtBullerResort(Scanner scanner) {
        this.scanner = scanner;
        // Array Creation
        customers = new ArrayList<>();
        accommodations = new ArrayList<>();
        travelBundles = new ArrayList<>();

        populateAccommodations();
        populateCustomers();
    }

    // Preset Accommodations
    public void populateAccommodations() {

        Accommodation windsor_classic = new HotelRoom(101, 150, "Windsor Classic");
        Accommodation windsor_deluxe = new HotelRoom(102, 300, "Windsor Deluxe");
        Accommodation windsor_suite = new HotelRoom(103, 500, "Windsor Suite");
        Accommodation windsor_grand_suite = new HotelRoom(104, 900, "Windsor Grand Suite");

        Accommodation metropolitan_studio = new Apartment(201, 200, "Metropolitan Studio");
        Accommodation metropolitan_single = new Apartment(202, 275, "Metropolitan Single");
        Accommodation metropolitan_double = new Apartment(203, 325, "Metropolitan Double");

        Accommodation garden_village_single = new LodgeRoom(301, 350, "Garden Village Single");
        Accommodation garden_village_double = new LodgeRoom(302, 450, "Garden Village Double");
        Accommodation garden_village_family = new LodgeRoom(303, 600, "Garden Village Family");

        addAccommodation(windsor_classic);
        addAccommodation(windsor_deluxe);
        addAccommodation(windsor_suite);
        addAccommodation(windsor_grand_suite);

        addAccommodation(metropolitan_studio);
        addAccommodation(metropolitan_single);
        addAccommodation(metropolitan_double);

        addAccommodation(garden_village_single);
        addAccommodation(garden_village_double);
        addAccommodation(garden_village_family);
    }

    // Preset Customers
    public void populateCustomers() {
        Customer alice = new Customer("Alice Piper", 23, "Female",
                SkiingLevel.EXPERT);

        Customer grace = new Customer("Grace Parker", 23, "Female",
                SkiingLevel.INTERMEDIATE);

        Customer mark = new Customer("Mark Howard", 35, "Male",
                SkiingLevel.BEGINNER);

        addCustomer(alice);
        Customer.updateNextID(alice.getCustomerID());

        addCustomer(grace);
        Customer.updateNextID(grace.getCustomerID());

        addCustomer(mark);
        Customer.updateNextID(mark.getCustomerID());
    }

    // Customer Methods
    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void createCustomer() {
        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();

        if (customerName.trim().isEmpty()) {
            System.out.println("Invalid name. Name cannot be blank.");
            return;
        }

        System.out.println("Enter your age: ");
        String ageInput = scanner.nextLine();
        int customerAge;

        try {
            customerAge = Integer.parseInt(ageInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age. Please enter a whole number.");
            return;
        }

        if (customerAge <= 0) {
            System.out.println("Invalid age. Age must be greater than 0.");
            return;
        }

        System.out.println("Enter your gender: ");
        String customerGender = scanner.nextLine();

        System.out.println("Enter your Skiing Experience (Beginner, Intermediate or Expert): ");
        String levelInput = scanner.nextLine();
        SkiingLevel level;
        try {
            level = SkiingLevel.valueOf(levelInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid level. Please enter BEGINNER, INTERMEDIATE, or EXPERT.");
            return;
        }

        Customer customer = new Customer(customerName, customerAge, customerGender, level);

        addCustomer(customer);
        System.out.println("Customer information succesfully added!");

    }

    public void listCustomers() {
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public Customer findCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getCustomerID() == id) {
                return c;
            }
        }
        return null;
    }

    // Accommodation Methods
    public void addAccommodation(Accommodation a) {
        accommodations.add(a);
    }

    public void listAllAccommodations() {
        System.out.println("\nType | Name | ID | Price | Availability");
        System.out.println("--------------------------------------------------");

        for (Accommodation a : accommodations) {
            System.out.println(a);
        }
    }

    public void listAvailableAccommodations() {
        System.out.println("\nType | Name | ID | Price | Availability");
        System.out.println("--------------------------------------------------");

        for (Accommodation a : accommodations)
            if (a.isAvailable()) {
                System.out.println(a);
            }
    }

    public Accommodation findAccommodationById(int id) {
        for (Accommodation a : accommodations) {
            if (a.getID() == id) {
                return a;
            }
        }
        return null;
    }

    // Travel Bundle Methods
    public void addBundle(TravelBundle b) {
        travelBundles.add(b);
    }

    public void createBundle() {
        // User Input for Bundle
        System.out.println("Enter your customer ID: ");
        String customerIdInput = scanner.nextLine();
        int customerID;

        try {
            customerID = Integer.parseInt(customerIdInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid customer ID. Please enter a whole number.");
            return;
        }

        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter your arrival date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        try {
            LocalDate.parse(startDate);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Please enter the date in YYYY-MM-DD format.");
            return;
        }

        System.out.println("Enter stay duration in days: ");
        String durationInput = scanner.nextLine();
        int durationDays;

        try {
            durationDays = Integer.parseInt(durationInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid duration. Please enter a whole number.");
            return;
        }

        if (durationDays <= 0) {
            System.out.println("Invalid duration. Duration must be greater than 0.");
            return;
        }

        // New Bundle Object
        TravelBundle bundle = new TravelBundle(customer, startDate, durationDays);

        // User Input For Accommodation
        listAvailableAccommodations();
        System.out.println();
        System.out.println("Enter Accommodation ID from the list above: ");
        String accommodationIdInput = scanner.nextLine();
        int accommodationID;

        try {
            accommodationID = Integer.parseInt(accommodationIdInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid accommodation ID. Please enter a whole number.");
            return;
        }

        Accommodation accommodation = findAccommodationById(accommodationID);

        if (accommodation == null) {
            System.out.println("Accommodation not found!");
            return;
        }
        try {
            if (!accommodation.isAvailable()) {
                throw new AccommodationNotAvailableException("Accommodation is not available!");
            }
        } catch (AccommodationNotAvailableException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Add accommodation to Bundle and set accommodation to Unavailable
        bundle.addAccommodationToBundle(accommodation);
        accommodation.setAvailable(false);

        // Adds newly created bundle to bundle array
        addBundle(bundle);
        System.out.println("Bundle created successfully.");

    }

    public void listBundles() {
        if (travelBundles.isEmpty()) {
            System.out.println("No bundles found!");
            return;
        }

        System.out.println("\nBundle ID | Customer | Accommodation | Start | Days | Lift Pass | Lessons | Total Price");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");

        for (TravelBundle b : travelBundles) {
            System.out.println(b);
        }
    }

    public TravelBundle findBundleById(int id) {
        for (TravelBundle b : travelBundles) {
            if (b.getBundleID() == id) {
                return b;
            }
        }
        return null;
    }

    public void saveBundlesToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bundles.dat"))) {
            out.writeObject(travelBundles);
            System.out.println("Bundles saved successfully.");
        } catch (IOException e) {
            System.out.println("ERROR! Couldn't save bundles: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void readBundlesFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("bundles.dat"))) {
            travelBundles = (ArrayList<TravelBundle>) in.readObject();

            for (TravelBundle bundle : travelBundles) {
                TravelBundle.updateNextID(bundle.getBundleID());
            }

            for (TravelBundle bundle : travelBundles) {
                Customer loadedCustomer = bundle.getCustomer();

                if (loadedCustomer != null) {
                    Customer.updateNextID(loadedCustomer.getCustomerID());
                }
            }

            for (TravelBundle bundle : travelBundles) {
                Customer loadedCustomer = bundle.getCustomer();

                if (loadedCustomer != null && findCustomerById(loadedCustomer.getCustomerID()) == null) {
                    addCustomer(loadedCustomer);
                }
            }

            for (TravelBundle bundle : travelBundles) {
                Customer loadedCustomer = bundle.getCustomer();

                if (loadedCustomer != null) {
                    Customer currentCustomer = findCustomerById(loadedCustomer.getCustomerID());

                    if (currentCustomer != null) {
                        bundle.setCustomer(currentCustomer);
                    }
                }
            }

            for (Accommodation accommodation : accommodations) {
                accommodation.setAvailable(true);
            }

            for (TravelBundle bundle : travelBundles) {
                Accommodation bookedAccommodation = bundle.getAccommodation();

                if (bookedAccommodation != null) {
                    Accommodation currentAccommodation = findAccommodationById(bookedAccommodation.getID());

                    if (currentAccommodation != null) {
                        currentAccommodation.setAvailable(false);
                        bundle.addAccommodationToBundle(currentAccommodation);
                    }
                }
            }

            System.out.println("Bundles loaded successfully.");
            listBundles();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR! Couldn't load bundles: " + e.getMessage());
        }
    }

    // Lift Pass Methods
    public void addLiftPassToBundle() {
        System.out.println("Enter Bundle ID: ");
        String bundleIdInput = scanner.nextLine();
        int bundleID;

        try {
            bundleID = Integer.parseInt(bundleIdInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bundle ID. Please enter a whole number.");
            return;
        }

        TravelBundle travelBundle = findBundleById(bundleID);
        if (travelBundle == null) {
            System.out.println("Bundle not found!");
            return;
        }

        System.out.println("Enter Lift Pass length in days: ");
        String daysInput = scanner.nextLine();
        int numberOfDays;

        try {
            numberOfDays = Integer.parseInt(daysInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid lift pass length. Please enter a whole number.");
            return;
        }

        if (numberOfDays <= 0) {
            System.out.println("Invalid lift pass length. Days must be greater than 0.");
            return;
        }

        LiftPass liftPass = new LiftPass(numberOfDays);

        travelBundle.addLiftPassToBundle(liftPass);
        System.out.println("Lift pass added successfully.");
    }

    public void addLessonToBundle() {
        System.out.println("Enter Bundle ID: ");
        String bundleIdInput = scanner.nextLine();
        int bundleID;

        try {
            bundleID = Integer.parseInt(bundleIdInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid bundle ID. Please enter a whole number.");
            return;
        }

        TravelBundle travelBundle = findBundleById(bundleID);
        if (travelBundle == null) {
            System.out.println("Bundle not found!");
            return;
        }

        SkiingLevel level = travelBundle.getCustomer().getSkiingLevel();

        System.out.println("Enter number of lessons: ");
        String lessonsInput = scanner.nextLine();
        int numLessons;

        try {
            numLessons = Integer.parseInt(lessonsInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of lessons. Please enter a whole number.");
            return;
        }

        if (numLessons <= 0) {
            System.out.println("Invalid number of lessons.");
            return;
        }

        Lesson lesson = new Lesson(level, numLessons);

        travelBundle.addLessonToBundle(lesson);
        System.out.println("Lesson added successfully.");

    }

}