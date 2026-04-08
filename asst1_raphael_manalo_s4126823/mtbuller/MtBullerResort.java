package mtbuller;

import java.util.ArrayList;

public class MtBullerResort {
    private ArrayList<Customer> customers;

    public MtBullerResort() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

}