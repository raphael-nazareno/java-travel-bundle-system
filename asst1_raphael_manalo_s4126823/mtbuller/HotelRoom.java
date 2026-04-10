package mtbuller;

public class HotelRoom extends Accommodation {

    public HotelRoom(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public String toString() {
        return "Hotel Room | " + super.toString();
    }
}
