public class Customer {

    private int customerID;

    private String customerName;
    private String customerDOB;
    private String customerGender;
    private int customerAge;

    public enum skiingLevel {
        Beginnering, Intermediate, Expert
    }

    public Customer(int customerID, String customerName, String customerDOB, int customerAge, String customerGender) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerDOB = customerDOB;
        this.customerAge = customerAge;
        this.customerGender = customerGender;

    }

    public String toString() {
        return String.format("This is %s, with customerID: %d", customerName, customerID);
    }
}
