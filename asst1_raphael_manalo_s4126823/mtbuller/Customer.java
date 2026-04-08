package mtbuller;

public class Customer {

    private int customerID;
    private static int nextID = 1;

    private String customerName;
    private String customerGender;
    private int customerAge;
    private SkiingLevel skiingLevel;

    public Customer(String customerName, int customerAge, String customerGender,
            SkiingLevel SkiingLevel) {
        this.customerID = nextID++;

        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerGender = customerGender;
        this.skiingLevel = SkiingLevel;

    }

    public String setCustomerName(String customerName) {
        return customerName;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String toString() {
        return String.format("This is %s, with customerID: %d", customerName, customerID);
    }
}
