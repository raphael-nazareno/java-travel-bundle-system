package mtbuller;

public class HotelRoom extends Accommodation {
    private static final long serialVersionUID = 1L;

    public HotelRoom(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.HOTEL_ROOM;
    }
}
