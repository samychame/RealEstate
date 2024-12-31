import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static RealEstateManager manager = new RealEstateManager("Samy");
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<Property> manager_properties = DataManager.getProperties();
        for (Property managerProperty : manager_properties) {
            manager.addProperty(managerProperty);
        }
        managerApp();
    }

    public static void managerApp(){
        while (true){
            int choice = RealEstateManager.printMenu();
            if(choice == -1){
                break;
            }
            switch(choice){
                case 1:
                    //Property search by budget
                    ArrayList<Property> properties_in_budget = null;
                    System.out.println("Enter the budget");
                    double budget = scanner.nextDouble();
                    try {
                        properties_in_budget = manager.propertiesList(budget);
                    }catch(RealEstateManager.PriceException pe){
                        pe.printStackTrace();
                    }
                    if(properties_in_budget != null) {
                        for (int i = 0; i < properties_in_budget.size(); i++) {
                            System.out.println((i + 1) + ". " + properties_in_budget.get(i));
                        }
                    }
                    else{
                        System.out.println("There are no available properties in that budget");
                    }
                    break;
                case 2:
                    //Financial Report
                    manager.finacialReport();
                    break;
                case 3:
                    //Calculate commercial properties yield
                    double total_yield = manager.commercialYield();
                    System.out.println("The total yield is: "+total_yield);
                    break;
                case 4:
                    //Search properties by city
                    System.out.println("Enter the city you would like the property to be in");
                    String city = scanner.nextLine();
                    manager.propertiesByCity(city);
                    break;
                case 5:
                    //Show the properties cities
                    int num_of_cities = manager.numberOfCities();
                    System.out.println("There are properties in " + num_of_cities + " different cities.");
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    break;
            }
        }
    }


}
