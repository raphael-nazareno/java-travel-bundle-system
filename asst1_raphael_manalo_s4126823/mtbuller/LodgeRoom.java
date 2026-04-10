package mtbuller;

public class LodgeRoom extends Accommodation {

    public LodgeRoom(int id, double pricePerNight, String name) {
        super(id, pricePerNight, name);
    }

    @Override
    public String toString() {
        return "Lodge Room | " + super.toString();
    }

}