import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<CupCake> cupCakeMenu, ArrayList<Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner scanner = new Scanner(System.in);

        String placeOrder = scanner.nextLine();

        ArrayList<Object> order = new ArrayList<>();

        Boolean ordering = true;

        if (placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());

            System.out.println("Here is the menu");
            System.out.println("Cupcakes: ");

            int itemNumber = 0;
            for (int i = 0; i < cupCakeMenu.size(); i++) {
                itemNumber++;
                System.out.print(itemNumber + ") ");
                cupCakeMenu.get(i).type();
                System.out.println("Price: $" + cupCakeMenu.get(i).getPrice());
                System.out.println();
            }

            System.out.println("Drinks: ");

            for (int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;
                System.out.print(itemNumber + ") ");
                drinkMenu.get(i).type();
                System.out.println("Price: $" + drinkMenu.get(i).getPrice());
                System.out.println();
            }

            while (ordering) {
                System.out.println(
                        "What would you like to order? Please use the number associated with each item to order.");
                int orderChoice = scanner.nextInt();
                scanner.nextLine();

                if (orderChoice - 1 < cupCakeMenu.size()) {
                    order.add(cupCakeMenu.get(orderChoice - 1));
                    System.out.println("Item added to order");
                } else if (orderChoice - 1 >= cupCakeMenu.size()) {
                    order.add(drinkMenu.get(orderChoice - cupCakeMenu.size() - 1));
                    System.out.println("Item added to order");
                } else if (orderChoice <= 0 || orderChoice > itemNumber) {
                    System.out.print("Sorry, we don't seem to have that");
                }

                System.out.print("Would you like to continue ordering (Y,N)");
                String res = scanner.nextLine();

                if (res.equalsIgnoreCase("n"))
                    break;
            }

        } else {
            System.out.println("Have a nice day then");
        }

            System.out.println(order.get(0));
             System.out.println(order.get(1));

             Double subTotal = 0.0;

        for (int i = 2; i < order.size(); i++) {
           
            if (order.get(i) instanceof CupCake){
            
                CupCake cupCake =   CupCake.class.cast(order.get(i));
                cupCake.type();
                System.out.println(cupCake.getPrice());

                subTotal = subTotal + cupCake.getPrice();
            }  
            else
            if (order.get(i) instanceof Drink){
                Drink drink =   Drink.class.cast(order.get(i));
                drink.type();
                System.out.println(drink.getPrice());

                subTotal = subTotal + drink.getPrice();
            }         
        }

        System.out.println("$" + subTotal + "\n");

        new CreateFile();
        new WriteToFile(order);
    }
}
