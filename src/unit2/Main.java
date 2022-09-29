package unit2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>(); //creates a new ArrayList which contains Cupcake objects
        ArrayList<Drink> drinkMenu = new ArrayList<Drink>(); //creates a new ArrayList which contains Drink objects

        //Objects Declaration
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        System.out.println("We are in the middle of creating the cupcake menu. " +
                "We currently have three cupcakes on the menu but we need to decide on pricing.");
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");

        cupcake.type(); //calling the type() method on the cupcake objects to get the text from standard cupcake class

        System.out.println("How much would you like to charge for the cupcake? " +
                "\n(Input a numerical number taken to 2 decimal places)");

        Scanner input = new Scanner(System.in); //a Scanner object to accept the users input
        double priceText = input.nextDouble();
        input.nextLine();
        //double price = Double.parseDouble(priceText);

        System.out.println("How much would you like to charge for the bottle of water? ");
        priceText = input.nextDouble();
        input.nextLine();


        cupcake.setPrice(priceText);//calling the setPrice() method w/the param. of priceText on the cupcake object
        redVelvet.setPrice(priceText + 1); //calling the setPrice() method w/the param. of priceText on the redVelvet object
        chocolate.setPrice(priceText + 2);//calling the setPrice() method w/the param. of priceText on the choco object

        water.setPrice(priceText); // for object water sets a price
        soda.setPrice(priceText + 1); // for object soda sets a price
        milk.setPrice(priceText + 2); // for object milk sets a price

        cupcakeMenu.add(cupcake); //adding each of Class objects to the ArrayList
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        /*
        System.out.println("If regular cupcake price is " + cupcake.price + ". Then:" +
                "\nRed Velvet cupcake price would be " + redVelvet.price + "." +
                "\nChocolate cupcake price would be " + chocolate.price +
                "\n" +
                "\nWater price is " + water.price + "." +
                "\nSoda price would be " + soda.price + "." +
                "\nMilk price would be " + milk.price + ".");
        */

        System.out.println("The menu is ready!");

        new Order(cupcakeMenu, drinkMenu);
    }
}
class Cupcake{ //public new class named Cupcake

    public double price; // Create a public double variable named price, no value assigned
//  private double price; // Create a private double var so cupcake.price won't be available from main

    public double getPrice() { //CodeGenerate Getter method #1
        return price;
    }

    public void setPrice(double price) { //CodeGenerate Setter method #2
        this.price = price;
    }

    public void type(){ //a public function  'type' that prints and returns void method #3
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }

    public String toString(){ return "" + price; }
}

class RedVelvet extends Cupcake{
    public void type(){
        System.out.println("A red velvet based cupcake, with cream cheese frosting."); //overrides the behavior of the inherited method
    }
}
class Chocolate extends Cupcake{
    public void type(){
        System.out.println("A chocolate based cupcake, with chocolate frosting."); //overrides the behavior of the inherited method
    }
}

class Drink{
    public double price; //double variable
    public double getPrice(){return price;}//returns double variable
    public void setPrice(double price){this.price = price;} //sets double variable
    public void type(){System.out.println("A bottle of water");} //describes the class
}

class Soda extends Drink{
    public void type(){System.out.println("A bottle of soda.");}
}

class Milk extends Drink{
    public void type(){System.out.println("A bottle of milk.");}
}