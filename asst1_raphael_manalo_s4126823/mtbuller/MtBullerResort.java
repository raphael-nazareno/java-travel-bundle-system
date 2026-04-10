package mtbuller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MtBullerResort {
    private ArrayList<Customer> customers;
    private ArrayList<Accommodation> accommodations;
    private ArrayList<TravelBundle> travelBundles;

    public MtBullerResort() {
        // Array Creation
        customers = new ArrayList<>();
        accommodations = new ArrayList<>();
        travelBundles = new ArrayList<>();

        populateAccommodations();
        populateCustomers();
    }

    // Preset Accommodations
    public void populateAccommodations() {

        Accommodation windsor_classic = new HotelRoom(101, 150, "Window Classic");
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
        addCustomer(grace);
        addCustomer(mark);
    }

    // Customer Methods
    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void createCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter your age: ");
        int customerAge = scanner.nextInt();
        scanner.nextLine();
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
        System.out.println("\nType         | Name                      | ID   | Price      | Availability");
        System.out.println("-------------------------------------------------------------------------------");

        for (Accommodation a : accommodations) {
            System.out.println(a);
        }
    }

    public void listAvailableAccommodations() {
        System.out.println("\nType         | Name                      | ID   | Price      | Availability");
        System.out.println("-------------------------------------------------------------------------------");

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();

        Customer customer = findCustomerById(customerID);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Enter your arrival date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.println("Enter stay duration in days: ");
        int durationDays = scanner.nextInt();

        if (durationDays <= 0) {
            System.out.println("Invalid duration. Duration must be greater than 0.");
            return;
        }

        // New Bundle Object
        TravelBundle bundle = new TravelBundle(customer, startDate, durationDays);

        // User Input For Accommodation
        listAvailableAccommodations();
        System.out.println("Enter Accommodation ID from the list above: ");
        int accommodationID = scanner.nextInt();

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
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bundles.dat"));
            out.writeObject(travelBundles);
            out.close();
            System.out.println("Bundles saved successfully.");
        } catch (IOException e) {
            System.out.println("ERROR! Couldn't save bundle!");
        }
    }

    @SuppressWarnings("unchecked")
    public void readBundlesFromFile() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("bundles.dat"));

            travelBundles = (ArrayList<TravelBundle>) in.readObject();

            in.close();

            System.out.println("Bundles loaded successfully.");
        } catch (Exception e) {
            System.out.println("ERROR! Couldn't load bundles.");
        }
    }

    // Lift Pass Methods
    public void addLiftPassToBundle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Bundle ID: ");
        int bundleID = scanner.nextInt();

        TravelBundle travelBundle = findBundleById(bundleID);
        if (travelBundle == null) {
            System.out.println("Bundle not found!");
            return;
        }

        System.out.println("Enter Lift Pass length in days: ");
        int numberOfDays = scanner.nextInt();

        LiftPass liftPass = new LiftPass(numberOfDays);

        travelBundle.addLiftPassToBundle(liftPass);
        System.out.println("Lift pass added successfully.");
    }

    public void addLessonToBundle() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Bundle ID: ");
        int bundleID = scanner.nextInt();

        TravelBundle travelBundle = findBundleById(bundleID);
        if (travelBundle == null) {
            System.out.println("Bundle not found!");
            return;
        }

        SkiingLevel level = travelBundle.getCustomer().getSkiingLevel();

        System.out.println("Enter number of lessons: ");
        int numLessons = scanner.nextInt();
        if (numLessons <= 0) {
            System.out.println("Invalid number of lessons.");
            return;
        }

        Lesson lesson = new Lesson(level, numLessons);

        travelBundle.addLessonToBundle(lesson);
        System.out.println("Lesson added successfully.");

    }

}