public class Plot extends Property {

    protected enum TYPE{URBAN,AGRICULTURAL,INDUSTRIAL};
    private TYPE type;


    public Plot(String address, double area, double price,TYPE type) {
        super(address, area, price);
        this.type = type;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public void taxIt(){
        double tax = getPrice();
        if (type == TYPE.URBAN){
            tax *= 0.1;
        } else if (type == TYPE.INDUSTRIAL) {
            tax *= 0.05;

        } else if (type == TYPE.AGRICULTURAL) {
            tax *= 0.02;
        }
        System.out.println("Tax: "+tax);
    }

    @Override
    public String toString() {
        return type+" Plot: "+ super.toString() ;
    }
}
