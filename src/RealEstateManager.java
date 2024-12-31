import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class RealEstateManager {

    class PriceException extends Exception{
        public PriceException(String message){
            super(message);
        }
    }
    private String name;
    private ArrayList<Property> properties = new ArrayList<>();

    public RealEstateManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property){
        if(property != null ){
            properties.add(property);
        }
        else{
            System.out.println("Can't add null to the properties!");
        }
    }

    public ArrayList<Property> propertiesList(double budget)throws PriceException{
        if(budget < 0){
            throw new PriceException("Negative budget");
        }
        ArrayList<Property> properties_in_budget = new ArrayList<>();
        for (Property property : properties) {
            if(property.getPrice() <= budget){
                properties_in_budget.add(property);
            }
        }
        if(properties_in_budget.isEmpty()){
            return null;
        }
        return properties_in_budget;
    }

    public double sumOfProperties(){
        double sum = 0;
        for (Property property : properties) {
            sum += property.getPrice();
        }
        return sum;
    }

    public String listOfPropertiesToString(){
        String property_list = "";
        for (Property property : properties) {
            property_list += property;
        }
        return property_list;
    }

    public void finacialReport(){
        System.out.println("- - - Financial Report - - -");
        for (Property property : properties) {
            System.out.println(property+": ");
            property.taxIt();
        }
        System.out.println("- - - - - - - - - - - - -  -");

    }

    public double commercialYield(){
        double sum = 0;
        for (Property property : properties) {
            if(property instanceof Commercial){
                sum += ((Commercial) property).yearlyYield();
            }
        }
        return sum;
    }

    public void propertiesByCity(String city){
        city = city.trim().toLowerCase().replace("-","").replace(" ","");
        for (Property property : properties) {
            String address = property.getAddress().toLowerCase().replace("-","").replace(" ","");
            if(address.contains(city)){
                System.out.println(property);
            }
        }
    }

    public int numberOfCities(){
        HashSet<String> cityMap = new HashSet<>();
        for (Property property : properties) {
            String address = property.getAddress();
            String address_city = address.split(",")[0].trim();
            cityMap.add(address_city);
        }
        return cityMap.size();
    }

    public static int printMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n- - - Real Estate Manager App - - -");
        System.out.println("""
                1 -> Property search by budget
                2 -> Financial Report
                3 -> Calculate commercial properties yield
                4 -> Search properties by city
                5 -> Show the properties cities
                -1 -> Exit
                """);
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        return choice;
    }


    @Override
    public String toString() {
        return "RealEstateManager{" +
                "name='" + name + '\'' +
                ", properties=" + listOfPropertiesToString() +
                '}';
    }
}
