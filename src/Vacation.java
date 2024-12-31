public class Vacation extends Property{

    private int guests = 1;

    public Vacation(String address, double area, double price, int guests) {
        super(address, area, price);
        try {
            setGuests(guests);
        }
        catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }

    }


    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        if(guests < 1){
            throw new IllegalArgumentException("Number of guests can't be less than one!");
        }
        this.guests = guests;
    }

    public void taxIt(){
        double tax = getPrice() * 0.25;
        System.out.println("Tax: "+tax);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "guests=" + guests +
                '}'+super.toString();
    }
}
