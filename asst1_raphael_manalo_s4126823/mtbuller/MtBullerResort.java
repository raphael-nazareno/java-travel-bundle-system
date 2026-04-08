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

    // Accommodation Methods
    public void addAccommodation(Accommodation a) {
        accommodations.add(a);
    }

    public void listAllAccommodations() {
        for (Accommodation a : accommodations) {
            System.out.println(a);
        }
    }

}
