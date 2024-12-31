public class Commercial extends Property {

    private boolean storeroom = false;
    private double yield;


    public Commercial(String address, double area, double price, double yield) {
        super(address, area, price);
        try{
            setYield(yield);
        }
        catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }
    }
    public Commercial(String address, double area, double price, boolean storeroom, double yield) {
        super(address, area, price);
        setStoreroom(storeroom);
        try{
            setYield(yield);
        }
        catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }
    }

    public boolean isStoreroom() {
        return storeroom;
    }

    public void setStoreroom(boolean storeroom) {
        this.storeroom = storeroom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if(yield < 0){
            throw new IllegalArgumentException("Yield can't be negative");
        }
        this.yield = yield;
    }

    public void printMonthlyYield(){
        double monthly_yield = (getPrice() * (yield / 100)) / 12;
        System.out.println("Monthly yield: "+monthly_yield);
    }


    public void taxIt(){
        double tax = getPrice() * 0.05;
        System.out.println("Tax: "+tax);
    }

    public double yearlyYield(){
        double yearly_yield = (yield/100) * getPrice();
        return yearly_yield;
    }
    @Override
    public String toString() {
        return "Commercial{" +
                "storeroom=" + storeroom +
                ", yield=" + yield +
                '}'+ super.toString();
    }
}
