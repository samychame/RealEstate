import java.util.ArrayList;

public class DataManager {
    public static ArrayList<Property> getProperties() {
        ArrayList<Property> properties = new ArrayList<>();

        // Add 2 Plots
        properties.add(new Plot("Tel Aviv, Frishman 12", 500, 2000000, Plot.TYPE.URBAN));
        properties.add(new Plot("Ramat Gan, Bialik 23", 700, 1500000, Plot.TYPE.AGRICULTURAL));

        // Add 2 Apartments
        properties.add(new Apartment("Kfar Saba, Weitzman 18", 120, 1200000, 1, 3));
        properties.add(new Apartment("Herzliya, Ben Gurion 34", 100, 1000000, 1, 4));

        // Add 2 Villas
        properties.add(new Villa("Haifa, Carmel 45", 350, 3500000, 2, 2));
        properties.add(new Villa("Eilat, Red Sea 1", 300, 3000000, 3, 1));

        // Add 2 Vacation Apartments
        properties.add(new Vacation("Tiberias, Lake Street 3", 80, 800000,  6));
        properties.add(new Vacation("Dead Sea, Salt Road 7", 90, 900000, 8));

        // Add 2 Commercial Properties
        properties.add(new Commercial("Jerusalem, King George 19", 200, 2000000, true,6.5));
        properties.add(new Commercial("Beersheba, Negev 23", 150, 1500000, false, 5.0));

        // Add 2 Offices
        properties.add(new Office("Rishon Lezion, Herzl 77", 120, 1200000));
        properties.add(new Office("Petah Tikva, Derech HaMaccabim 22", 140, 1400000));

        return properties;
    }

}
