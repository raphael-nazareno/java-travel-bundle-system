package mtbuller;

public abstract class Accommodation {
    private int id;
    private double pricePerNight;
    private boolean available;

    public Accommodation(int id, double pricePerNight) {
        this.id = id;
        this.pricePerNight = pricePerNight;
        this.available = true;
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

    @Override
    public String toString() {
        String availabilityText = available ? "Yes" : "No";

        return String.format("ID: %d | Price (per night): %.2f | Availability %s",
                id, pricePerNight, availabilityText);
    }
}