import java.util.ArrayList;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) throws Exception {

        Scanner kb = new Scanner(System.in);
        String input;
        ArrayList<String> list = new ArrayList<>();


        System.out.println("Enter what you would like to search for - be precise. Enter blank space to end search.");
        while ((input = kb.nextLine()).length() > 0) {
            list.add(input);

        }
        if(!list.isEmpty()) {
            walmartStore walmartStore = new walmartStore(list);
            walmartStore.createCart();
            System.out.println("Walmart: ");
            System.out.println("Total cost: " + walmartStore.getTotalCost());
            System.out.println("Shopping cart: " + walmartStore.getShoppingCart());
            System.out.println("\n\n");


            hebStore hebStore = new hebStore(list);
            hebStore.createCart();
            System.out.println("HEB: ");
            System.out.println("Total cost: " + hebStore.getTotalCost());
            System.out.println("Shopping cart: " + hebStore.getShoppingCart());
            System.out.println("\n\n");
//        unitedStore unitedStore = new unitedStore(list);
//        unitedStore.createCart();


//System.out.println("United: ");
//System.out.println("Total cost: " + unitedStore.getTotalCost());
//System.out.println("Shopping cart: " +unitedStore.getShoppingCart());

            samsStore samsStore = new samsStore(list);
            samsStore.createCart();
            System.out.println("Sams: ");
            System.out.println("Total cost: " + samsStore.getTotalCost());
            System.out.println("Shopping cart: " + samsStore.getShoppingCart());



        }else{
            System.out.println("list is empty...");
        }
    }

}
