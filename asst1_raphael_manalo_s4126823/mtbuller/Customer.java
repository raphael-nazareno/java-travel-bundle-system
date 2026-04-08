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

    public int getCustomerID() {
        return this.customerID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public int getCustomerAge() {
        return this.customerAge;
    }

    public String getCustomerGender() {
        return this.customerGender;
    }

    public SkiingLevel getSkiingLevel() {
        return this.skiingLevel;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Name: %s | Age: %d | Gender: %s | Level: %s",
                customerID, customerName, customerAge, customerGender, skiingLevel);
    }
}
