package mtbuller;

import java.io.Serializable;

public class TravelBundle implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int bundleID;
    private static int nextID = 1;

    private final String startDate;
    private final int durationDays;

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

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Accommodation getAccommodation() {
        return this.accommodation;
    }

    public LiftPass getLiftPass() {
        return this.liftPass;
    }

    public Lesson getLesson() {
        return this.lesson;
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

    public int getDurationDays() {
        return this.durationDays;
    }

    public static void updateNextID(int loadedBundleID) {
        if (loadedBundleID >= nextID) {
            nextID = loadedBundleID + 1;
        }
    }

    private double calculateAccommodationCost() {
        if (accommodation == null) {
            return 0.0;
        }

        return accommodation.calculatePrice() * durationDays;
    }

    private double calculateBundleItemPrice(BundleItem item) {
        if (item == null) {
            return 0.0;
        }

        return item.calculatePrice();
    }

    private double calculateTotalPrice() {
        double totalPrice = calculateAccommodationCost();

        if (liftPass != null) {
            totalPrice += liftPass.calculatePrice();
        }

        if (lesson != null) {
            totalPrice += lesson.calculatePrice();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        String customerName = customer.getCustomerName();
        int customerID = customer.getCustomerID();

        String accommodationText = (accommodation != null) ? accommodation.getName()
                : "No Booking Found";

        String liftPassText = (liftPass != null)
                ? (liftPass.getNumberOfDays() == 30
                        ? String.format("$%.2f - Season pass", liftPass.calculatePrice())
                        : String.format("$%.2f - %d Day pass",
                                liftPass.calculatePrice(),
                                liftPass.getNumberOfDays()))
                : "Not added";

        String lessonText = (lesson != null)
                ? String.format("$%.2f - %d %s level lesson%s",
                        lesson.calculatePrice(),
                        lesson.getNumberOfLessons(),
                        lesson.getLevel().toString().toLowerCase(),
                        lesson.getNumberOfLessons() > 1 ? "s" : "")
                : "Not added";

        String totalPriceText = String.format("$%.2f", calculateTotalPrice());

        return String.format(
                "Bundle ID: %d | Customer Name: %s | Customer ID: %s | Accommodation: %s | Start Date: %s | Duration(Days): %d | Lift Pass: %s | Lessons: %s | Total Price: %s",
                bundleID, customerName, customerID, accommodationText, startDate, durationDays, liftPassText,
                lessonText, totalPriceText);
    }
}