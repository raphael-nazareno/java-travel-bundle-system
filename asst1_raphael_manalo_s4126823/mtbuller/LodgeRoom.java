package mtbuller;

public class LodgeRoom extends Accommodation {

    public LodgeRoom(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public AccommodationType getAccommodationType() {
        return AccommodationType.LODGE_ROOM;
    }

}