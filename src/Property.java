public abstract class Property {

    private String address = "Na,na";
    private double area;
    private double price;

    public Property(String address, double area, double price) {
        try {
            setAddress(address);
            setArea(area);
            setPrice(price);
        }
        catch (IllegalArgumentException iae){
            iae.printStackTrace();
        }

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        //Split the adress into words
        String [] words = address.trim().split("\\s+");
        if(address == null || address.trim().equals("") || words.length < 2){
            throw new IllegalArgumentException("Address can't be empty or null and must contain at least two words!");
        }
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if(area < 0){
            throw new IllegalArgumentException("Area can't be negative!");
        }
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price can't be negative!");
        }
        this.price = price;
    }


    public abstract void taxIt();

    @Override
    public String toString() {
        return "Property{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                '}';
    }
}
