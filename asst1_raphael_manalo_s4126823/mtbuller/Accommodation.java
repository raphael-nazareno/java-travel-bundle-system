package mtbuller;

import java.io.Serializable;

public abstract class Accommodation implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private double pricePerNight;
    private boolean available;

    private String name;

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

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String availabilityText = available ? "Yes" : "No";

        return String.format("%s | ID: %d | Price: %.2f | Availability %s",
                name, id, pricePerNight, availabilityText);
    }
}