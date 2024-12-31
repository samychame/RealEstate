public abstract class Residential extends Property{

    private int parkingLots;

    public Residential(String address, double area, double price, int parkingLots) {
        super(address, area, price);
        try {
            setParkingLots(parkingLots);
        }
        catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }
    }

    public int getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(int parkingLots) {
        if(parkingLots < 0){
            throw new IllegalArgumentException("Number of parking lots can't be negative!");
        }
        this.parkingLots = parkingLots;
    }

    public void taxIt(){
        double tax = getPrice() * 0.08;
        System.out.println("Tax: "+tax);
    }


    @Override
    public String toString() {
        return "Residential{" +
                "parkingLots=" + parkingLots +
                '}' + super.toString();
    }
}
