import java.util.Scanner;

public class MarsExpedition {
    public MarsExpedition() {

        Scanner input = new Scanner(System.in);
        System.out.println("Expedition prep program starting…");
        System.out.println("Booting up…");

        System.out.println("…");
        System.out.println("…");
        System.out.println("…");

        System.out.println("Ready");

        System.out.println("You are allowed to bring one weapon with you. You know, just in case. " +
                "What do you want to bring?");

        String weapon = input.nextLine();

        System.out.println("Nice choice, you will be bringing " + weapon + " with you.");
        System.out.println("You have the choice of 3 vehicles " +
                "\nA: Mars Rover " +
                "\nB: Chevy Silverado " +
                "\nC: Honda Civic");



        String vehicleChoice = input.nextLine();

        if (vehicleChoice.equalsIgnoreCase("A") ||
                vehicleChoice.equalsIgnoreCase("Mars Rover")) {
            vehicleChoice = "Mars Roover";
        } else if (vehicleChoice.equalsIgnoreCase("B") ||
                vehicleChoice.equalsIgnoreCase("Chevy Silverado")) {
            vehicleChoice = "Chevy Silverado";
        } else if (vehicleChoice.equalsIgnoreCase("C") ||
                vehicleChoice.equalsIgnoreCase("Honda Civic")) {
            vehicleChoice = "Honda Civic";
        } else {
            System.out.println("Vehicle Choice does not equal any of the above. " +
                    "You will be using your feet!");
            vehicleChoice = "your feet";
        }

        System.out.println("Your expedition team is now ready" +
                "\nLed by Alla with 8 teammates." + //teamSize
                "\nTo explore the surface of Mars using " + vehicleChoice + " ." +
                "\nExploration team heads out in" +
                "\n5…." +
                "\n4…." +
                "\n3…." +
                "\n2…." +
                "\n1…." +
                "\nGO GO GO!");
    }

}