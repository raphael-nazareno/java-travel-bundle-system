package mtbuller;

import java.io.Serializable;

public abstract class Accommodation implements Serializable, Pricable, Bookable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private final double pricePerNight;
    private boolean available;
    private final String name;

    public Accommodation(int id, double pricePerNight, String name) {
        this.id = id;
        this.pricePerNight = pricePerNight;
        this.available = true;
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public double getPricePerNight() {
        return this.pricePerNight;
    }

    @Override
    public double calculatePrice() {
        return this.pricePerNight;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

    public String getName() {
        return this.name;
    }

    public abstract AccommodationType getAccommodationType();

    @Override
    public String toString() {
        String availabilityText = available ? "Yes" : "No";
        String typeText = getAccommodationType().name().replace('_', ' ');

        return String.format("%s | %s | ID: %d | Price: %.2f | Availability: %s",
                typeText, name, id, pricePerNight, availabilityText);
    }
}