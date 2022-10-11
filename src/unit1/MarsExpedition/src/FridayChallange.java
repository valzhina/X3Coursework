import java.util.Scanner;

public class FridayChallange {

    public static void main(String[] args){

        Persona[] people = new Persona[5];

        people[0] = new Persona("Bob", 28);
        people[1] = new Persona("Lily", 25);

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a name to search for: ");

        String name = input.nextLine();

        boolean matchFound = false;

        for (Persona p: people){
            if(p.name.equals(name)) {
                System.out.println("Match: " + p.name + " " + p.age);
                matchFound = true;
            }
        }

        if(!matchFound){
            System.out.println("No match Found");
        }
//        System.out.println("Please enter a name to search for: ");
//
//        Scanner input = new Scanner(System.in);
//
//        String name = input.nextLine();
//
//        Person p1 = new Person("Bob", 28);
//        Person p2 = new Person("Lily", 25);
//
//        String name = input.nextLine();
//
//        if(p1.name.equals(name)){
//            System.out.println(p1.name + " " + p1.age);
//        }
//        else if(p2.name.equals(name)){
//            System.out.println(p2.name + " " + p2.age);
//        }

    }
}
