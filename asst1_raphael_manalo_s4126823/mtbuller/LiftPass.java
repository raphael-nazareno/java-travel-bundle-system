package mtbuller;

public class LiftPass {
    private int numberOfDays;

    public LiftPass(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

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
}
