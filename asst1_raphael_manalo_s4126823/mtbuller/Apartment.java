package mtbuller;

public class Apartment extends Accommodation {
    public Apartment(int id, double pricePerNight) {
        super(id, pricePerNight);
    }

    @Override
    public String toString() {
        return "Apartment  | " + super.toString();
    }
}
