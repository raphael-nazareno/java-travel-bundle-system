package mtbuller;

public class Apartment extends Accommodation {
    private static final long serialVersionUID = 1L;

    public Apartment(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.APARTMENT;
    }

}
