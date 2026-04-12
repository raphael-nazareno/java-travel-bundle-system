package mtbuller;

public class Apartment extends Accommodation {
    public Apartment(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.APARTMENT;
    }

    @Override
    public String toString() {
        return "Apartment  | " + super.toString();
    }
}
