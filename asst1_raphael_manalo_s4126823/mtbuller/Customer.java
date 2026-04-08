package mtbuller;

public class Customer {

    private int customerID;
    static int nextID = 1;

    private String customerName;
    private String customerDOB;
    private String customerGender;
    private int customerAge;
    private SkiingLevel SkiingLevel;

    public Customer(int customerID, String customerName, int customerAge, String customerGender,
            SkiingLevel SkiingLevel) {
        customerID = nextID++;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerGender = customerGender;
        this.SkiingLevel = SkiingLevel;

    }

    public String toString() {
        return String.format("This is %s, with customerID: %d", customerName, customerID);
    }
}
