package mtbuller;

public class LiftPass extends BundleItem {
    private static final long serialVersionUID = 1L;

    private final int numberOfDays;

    public LiftPass(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @Override
    public double calculatePrice() {
        if (numberOfDays == 30) {
            return 200.0;
        }
        if (numberOfDays >= 5) {
            return (26 * numberOfDays) * .9;
        } else {
            return 26 * numberOfDays;
        }
    }

    public int getNumberOfDays() {
        return this.numberOfDays;
    }
}
