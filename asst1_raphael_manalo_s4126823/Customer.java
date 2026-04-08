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

    Customer Alice = new Customer(00001, "Alice Piper", "25th of September, 2002", 23, "Female");

    Customer Grace = new Customer(00002, "Grace Parker", "7th of December, 2002", 23, "Female");
}