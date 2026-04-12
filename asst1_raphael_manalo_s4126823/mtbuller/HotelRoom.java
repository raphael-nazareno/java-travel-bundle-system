package mtbuller;

public class HotelRoom extends Accommodation {

    public HotelRoom(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.HOTEL_ROOM;
    }

    @Override
    public String toString() {
        return "Hotel Room | " + super.toString();
    }
}
