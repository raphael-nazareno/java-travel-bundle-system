package mtbuller;

public class TravelBundle {
    private int bundleID;
    private static int nextID = 1;

    private String startDate;
    private int durationDays;

    private Customer customer;
    private Accommodation accommodation;

    public TravelBundle(Customer customer, String startDate, int durationDays) {
        this.bundleID = nextID++;

        this.customer = customer;
        this.startDate = startDate;
        this.durationDays = durationDays;

    }

}