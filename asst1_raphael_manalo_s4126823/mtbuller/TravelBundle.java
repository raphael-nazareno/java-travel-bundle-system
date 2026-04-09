package mtbuller;

public class TravelBundle {
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
        String accommodationText = (accommodation != null) ? accommodation.toString()
                : "No Booking Found";

        String liftPassText = (liftPass != null) ? String.format("$%.2f", liftPass.calculatePrice())
                : "N/A";

        String lessonTest = (lesson != null) ? String.format("$%.2f", liftPass.calculatePrice())
                : "No Lesson";

        return String.format(
                "Bundle ID: %d | Customer Name: %s | Accommodation: %s | Start Date: %s | Duration(Days): %d | Lift Pass: %s | Lessons: %s",
                bundleID, customerName, accommodationText, startDate, durationDays, liftPassText, lessonTest);
    }
}