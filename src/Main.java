import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<CupCake> cupCakeMenu = new ArrayList<>();

        CupCake cupCake = new CupCake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        Scanner scanner = new Scanner(System.in);

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupCake.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        
        String priceText = scanner.nextLine();
        cupCake.setPrice(Double.parseDouble(priceText));

        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description: ");
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
 
        priceText = scanner.nextLine();
        redVelvet.setPrice(Double.parseDouble(priceText));

        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description: ");
        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
    
        priceText = scanner.nextLine();
        chocolate.setPrice(Double.parseDouble(priceText));

        cupCakeMenu.add(cupCake);
        cupCakeMenu.add(redVelvet);
        cupCakeMenu.add(chocolate);

        ArrayList<Drink> drinkMenu = new ArrayList<>();

        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        System.out.println("We are in the middle of creating the drink menu. We currently have three types of drinks on the menu but we need to decide on pricing");
        System.out.println("We are deciding on the price for our bottled water. Here is the description: ");
        water.type();
        
        System.out.println("How much would you like to charge for the water bottle? (Input a numerical number taken to 2 decimal places)");
            
        priceText = scanner.nextLine();
        water.setPrice(Double.parseDouble(priceText));

        System.out.println("We are deciding on the price for our bottled soda. Here is the description: ");
        soda.type();
        
        System.out.println("How much would you like to charge for the soda bottle? (Input a numerical number taken to 2 decimal places)");
            
        priceText = scanner.nextLine();
        soda.setPrice(Double.parseDouble(priceText));
        
        System.out.println("We are deciding on the price for our bottled milk. Here is the description: ");
        milk.type();
        
        System.out.println("How much would you like to charge for the milk bottle? (Input a numerical number taken to 2 decimal places)");
            
        priceText = scanner.nextLine();
        milk.setPrice(Double.parseDouble(priceText));

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk); 

        Order order = new Order(cupCakeMenu, drinkMenu);
        scanner.close();
    }   
}
