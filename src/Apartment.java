public class Apartment extends Residential {

    private int rooms = 1;

    public Apartment(String address, double area, double price, int parkingLots, int rooms) {
        super(address, area, price, parkingLots);
        try {
            setRooms(rooms);
        }
        catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if(rooms < 1){
            throw new IllegalArgumentException("Number of rooms can't be less than one!");
        }
        this.rooms = rooms;
    }



    @Override
    public String toString() {
        return "Apartment: "+rooms+" Rooms, " +super.toString();
    }
}
