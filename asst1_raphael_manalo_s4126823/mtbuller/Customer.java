public class Customer {

    private int customerID;

    private String customerName;
    private String customerDOB;
    private String customerGender;
    private int customerAge;
    private SkiingLevel SkiingLevel;

    public enum SkiingLevel {
        BEGINNER, INTERMEDIATE, EXPERT
    }

    public Customer(int customerID, String customerName, String customerDOB, int customerAge, String customerGender,
            SkiingLevel SkiingLevel) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerDOB = customerDOB;
        this.customerAge = customerAge;
        this.customerGender = customerGender;
        this.SkiingLevel = SkiingLevel;

    }

    public String toString() {
        return String.format("This is %s, with customerID: %d", customerName, customerID);
    }
}
