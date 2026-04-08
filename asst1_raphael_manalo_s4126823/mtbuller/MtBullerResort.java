package mtbuller;

import java.util.ArrayList;

public class MtBullerResort {
    private ArrayList<Customer> customers;
    private ArrayList<Accommodation> accommodations;
    private ArrayList<TravelBundle> travelBundles;

    public MtBullerResort() {
        customers = new ArrayList<>();
        accommodations = new ArrayList<>();
        travelBundles = new ArrayList<>();

        populateAccommodations();
        populateCustomers();
    }

    // Initial Arrays
    // Accommodations
    public void populateAccommodations() {

        Accommodation windsor_classic = new HotelRoom(101, 150);
        Accommodation windsor_deluxe = new HotelRoom(102, 300);
        Accommodation windsor_suite = new HotelRoom(103, 500);
        Accommodation windsor_grand_suite = new HotelRoom(104, 1000);

        Accommodation metropolitan_studio = new Apartment(201, 200);
        Accommodation metropolitan_single = new Apartment(202, 275);
        Accommodation metropolitan_double = new Apartment(203, 325);

        Accommodation garden_village_single = new LodgeRoom(301, 350);
        Accommodation garden_village_double = new LodgeRoom(302, 450);
        Accommodation garden_village_family = new LodgeRoom(303, 600);

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

    // Customers
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
        for (Accommodation a : accommodations) {
            System.out.println(a);
        }
    }

    public void listAvailableAccommodations() {
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

}
