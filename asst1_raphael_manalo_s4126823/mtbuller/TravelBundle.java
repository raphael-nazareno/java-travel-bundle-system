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

    public void addAccommodationToBundle(Accommodation a) {
        this.accommodation = a;

    }

    public String toString() {
        String customerName = customer.getCustomerName();
        String accommodationText = (accommodation != null) ? accommodation.toString()
                : "No Booking Found";

        return String.format(
                "Bundle ID: %d | Customer Name: %s | Accommodation: %s | Start Date: %s | Duration(Days): %d",
                bundleID, customerName, accommodationText, startDate, durationDays);
    }
}