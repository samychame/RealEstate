public class Villa extends Residential{

    private int levels = 1;

    public Villa(String address, double area, double price, int parkingLots, int levels) {
        super(address, area, price, parkingLots);
        try {
            setLevels(levels);
        }
        catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        if(levels < 1){
            throw new IllegalArgumentException("Number of levels can't be less than one!");
        }
        this.levels = levels;
    }

    @Override
    public String toString() {
        return "Villa:" + levels +" Levels,"+super.toString();
    }
}
