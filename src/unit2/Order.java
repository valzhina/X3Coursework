package unit2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){ //creates a constructor w/ two arrays
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();
        placeOrder = placeOrder.toUpperCase(); //ignoring capitalization for the future use

        ArrayList<Object> order = new ArrayList<Object>(); //ArrayList of Objects(O. can be any type)
        switch (placeOrder){ // alternative ti if statement
            case "Y":
            case "YE":
            case "YES":
                order.add(LocalDate.now()); //populates ArrayList order
                order.add(LocalTime.now()); //populates ArrayList order
                System.out.println("Here is the menu");
                System.out.println("CUPCAKES:");

                int itemNumber = 0;
                for(int i = 0; i < cupcakeMenu.size(); i++){
                    itemNumber++;
                    System.out.println(itemNumber + ".");
                    cupcakeMenu.get(i).type();//calls and prints the type() method on the cupcake ArrayList objects
                    System.out.println("Price: $" + cupcakeMenu.get(i).getPrice() + "\n");
                }
                for(int i = 0; i < drinkMenu.size(); i++){
                    itemNumber++;
                    System.out.println(itemNumber + ".");
                    drinkMenu.get(i).type();//calls and prints the type() method on the drink ArrayList objects
                    System.out.println("Price: $" + drinkMenu.get(i).getPrice() + "\n");
                }
                break;
            default:
                System.out.println("Have a nice day then.");
        }

        boolean ordering = true;
        while(ordering == true) {
            System.out.println("What would you like to order? " +
                    "Please use the number associated with each item to order.");

            int orderChoice = input.nextInt();
            input.nextLine(); //corrects the terminal scanner input location

            if (orderChoice == 1) {
                order.add(cupcakeMenu.get(0)); //populates ArrayList order w/items
                System.out.println("Item added to order");
            }
            else if (orderChoice == 2) {
                order.add(cupcakeMenu.get(1)); //populates ArrayList order w/items
                System.out.println("Item added to order");
            }
            else if (orderChoice == 3) {
                order.add(cupcakeMenu.get(2)); //populates ArrayList order w/items
                System.out.println("Item added to order");
            }
            else if (orderChoice == 4) {
                order.add(drinkMenu.get(0)); //populates ArrayList order w/items
                System.out.println("Item added to order");
            }
            else if (orderChoice == 5) {
                order.add(drinkMenu.get(1)); //populates ArrayList order w/items
                System.out.println("Item added to order");
            }
            else if (orderChoice == 6) {
                order.add(drinkMenu.get(2)); //populates ArrayList order w/items
                System.out.println("Item added to order");
            }
            else {
                System.out.println("Sorry, we don’t seem to have that on the menu.");
            }
            System.out.println("Would you like to continue ordering? (Y/N)");

            placeOrder = input.nextLine();
            placeOrder = placeOrder.toUpperCase(); //ignoring capitalization for the future use

            switch (placeOrder){ // alternative ti if statement
                case "Y":
                case "YE":
                case "YES":
                    break;
                default:
                    ordering = false;
            }
        }
        System.out.println("Here is your order");
        System.out.println(order.get(0));
        System.out.println(order.get(1));
        double subtotal = 0.0;
        int orderItemNumber = 0;
        for(int i = 2; i < order.size(); i++){ // i[0]: day  / i[1]:time
            if(order.get(i).equals(cupcakeMenu.get(0))){
                orderItemNumber++;
                System.out.println(orderItemNumber + ".");
                cupcakeMenu.get(0).type();
                System.out.println("Price: $" + cupcakeMenu.get(0).getPrice());
                subtotal += cupcakeMenu.get(0).getPrice();
            }
            else if(order.get(i).equals(cupcakeMenu.get(1))){
                orderItemNumber++;
                System.out.println(orderItemNumber + ".");
                cupcakeMenu.get(1).type();
                System.out.println("Price: $" + cupcakeMenu.get(1).getPrice());
                subtotal += cupcakeMenu.get(1).getPrice();
            }
            else if(order.get(i).equals(cupcakeMenu.get(2))){
                orderItemNumber++;
                System.out.println(orderItemNumber + ".");
                cupcakeMenu.get(2).type();
                System.out.println("Price: $" + cupcakeMenu.get(2).getPrice());
                subtotal += cupcakeMenu.get(2).getPrice();
            }
            else if(order.get(i).equals(drinkMenu.get(0))){
                orderItemNumber++;
                System.out.println(orderItemNumber + ".");
                drinkMenu.get(0).type();
                System.out.println("Price: $" + drinkMenu.get(0).getPrice());
                subtotal += drinkMenu.get(0).getPrice();
            }
            else if(order.get(i).equals(drinkMenu.get(1))){
                orderItemNumber++;
                System.out.println(orderItemNumber + ".");
                drinkMenu.get(1).type();
                System.out.println("Price: $" + drinkMenu.get(1).getPrice());
                subtotal += drinkMenu.get(1).getPrice();
            }
            else if(order.get(i).equals(drinkMenu.get(2))){
                orderItemNumber++;
                System.out.println(orderItemNumber + ".");
                drinkMenu.get(2).type();
                System.out.println("Price: $" + drinkMenu.get(2).getPrice());
                subtotal += drinkMenu.get(2).getPrice();
            }
        }
        System.out.println("\n   Subtotal: $" + subtotal);
        new CreateFile(); //calls the constructor function for the CreateFile class
        new WriteToFile(order); //calls the constructor function for the WriteToFile class
    }
}

// ===========================================================================
// NEW CLASS

class CreateFile{

    // CONSTRUCTION FUNCTION
    public CreateFile(){
        try{
            File salesData = new File("salesData.txt"); //creates a File object & sets it equal to a new File object
            if (salesData.createNewFile() == true) { //.createNewFile() returns true if a new file is created
                System.out.println("File created:" + salesData.getName());
            }
            else{
                System.out.println("File already exists");
            }
        }
        catch(IOException e){
            System.out.println("An error occurred");
        }
    }
}

// ===========================================================================
// NEW CLASS

class WriteToFile{

    // CONSTRUCTION FUNCTION
    public WriteToFile(ArrayList<Object> order){
        try{
            //FileWriter constructor parameters are: String “salesData.txt”,boolean/ to append
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);// PrintWriter takes FileWriter as a param

            for (int i = 0; i < order.size(); i++){
                salesWriter.println(order.get(i));
            }
            salesWriter.close();  // Stops the writer from continuing to run
            System.out.println("Successfully wrote to the file");
        }
        catch(IOException e){
            System.out.println("An error occurred");
        }
    }
}