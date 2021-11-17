import java.util.Locale;
import java.util.Scanner;

public class CreateMember {
    UserInput userInput = new UserInput();
    MSG msg = new MSG();


    private void createMember() {
        //Member info
        String memberName;
        int memberYearOfBirth;
        String subscriptionType;
        String swimmerType;
        String discipline;

        System.out.println("-----Opret nyt medlem-----");
        memberName = nameCheck("Indtast navn: ");
        System.out.print("Indtast fødselsår: ");
        memberYearOfBirth = userInput.getIntInput();
        System.out.println(); // Bare en line

        // Et loop til subscription type
        while (true) { // Skift while true om lidt til noget bedre
            System.out.println("Vælg aktivitetsform: "); // Aktiv eller passiv

            //Bedøm om jeg skal lave en switch her eller if statement
            System.out.println("1. Aktiv");
            System.out.println("2. Passiv");

            int choice = userInput.getIntInput();

            if (choice == 1) {
                subscriptionType = "Aktiv";
                break; // Find en bedre løsning
            } else if (choice == 2) {
                subscriptionType = "Passiv";
                break;
            } else {
                System.out.println("Forkert ");
            }
        }

    }

    // Check om man får et forkert input
    private String nameCheck(String input) {
        String name = "";

        boolean inputCheck = false;
        // Et loop indtil inputCheck = true

        while (!inputCheck) {
            System.out.println(input);
            name = userInput.getStringInput();

            if (name.length() < 1) { // Name må ikke være mindre længde en 1
                System.out.println("That name is too short");
            }
            // Hvis input ikke er for kort
            inputCheck = true;

            // Gør navnet til lower case
            name = name.toLowerCase();
        }

        return name;
    }
}
