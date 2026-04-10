package mtbuller;

import java.io.Serializable;

public class TravelBundle implements Serializable {
    private static final long serialVersionUID = 1L;

    private int bundleID;
    private static int nextID = 1;

    private String startDate;
    private int durationDays;

    private Customer customer;
    private Accommodation accommodation;

    private LiftPass liftPass;
    private Lesson lesson;

    public TravelBundle(Customer customer, String startDate, int durationDays) {
        this.bundleID = nextID++;

        this.customer = customer;
        this.startDate = startDate;
        this.durationDays = durationDays;

    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void addAccommodationToBundle(Accommodation a) {
        this.accommodation = a;
    }

    public void addLiftPassToBundle(LiftPass l) {
        this.liftPass = l;
    }

    public void addLessonToBundle(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getBundleID() {
        return this.bundleID;
    }

    public String toString() {
        String customerName = customer.getCustomerName();
        int customerID = customer.getCustomerID();

        String accommodationText = (accommodation != null) ? accommodation.getName()
                : "No Booking Found";

        String liftPassText = (liftPass != null) ? String.format("$%.2f", liftPass.calculatePrice())
                : "N/A";

        String lessonText = (lesson != null) ? String.format("$%.2f", lesson.calculatePrice())
                : "No Lesson";

        return String.format(
                "Bundle ID: %d | Customer Name: %s | Customer ID: %s | Accommodation: %s | Start Date: %s | Duration(Days): %d | Lift Pass: %s | Lessons: %s",
                bundleID, customerName, customerID, accommodationText, startDate, durationDays, liftPassText,
                lessonText);
    }
}