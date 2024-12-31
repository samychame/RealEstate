public class Office extends Property{

    public Office(String address, double area, double price) {
        super(address, area, price);
    }

    public void taxIt(){
        double tax = getPrice() * 0.05;
        System.out.println("Tax: "+tax);
    }

    @Override
    public String toString() {
        return "Office: "+super.toString();
    }
}
