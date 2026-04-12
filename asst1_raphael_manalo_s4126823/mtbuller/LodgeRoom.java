package mtbuller;

public class LodgeRoom extends Accommodation {
    private static final long serialVersionUID = 1L;

    public LodgeRoom(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.LODGE_ROOM;
    }

}