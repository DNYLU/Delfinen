package dolphin.operations;

import dolphin.members.Discipline;
import dolphin.members.Member;
import dolphin.util.MSG;
import dolphin.util.UserInput;

import java.util.ArrayList;

// Lu & David
public class CreateMember {
    public ArrayList<Member> allMembers = new ArrayList<>(); //TEST 1
    public ArrayList<Member> casualMembers = new ArrayList<>(); //TEST 1
    public ArrayList<Member> competitiveMembers = new ArrayList<>(); //TEST 1

    UserInput userInput = new UserInput();
    MSG msg = new MSG();
    Discipline discipline;
    //FileManager fileManager = new FileManager();// Find en path

    public void run() {
            createMember();
    }

    private void createMember() {
        //dolphin.members.Member info
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

        // Aktivitetsform loops

        // subscriptionType
        while (true) { // Skift while true om lidt til noget bedre
            System.out.println("Vælg medlemstype: "); // Aktiv eller passiv

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
                msg.errorMessageInt();
            }
        }

        //swimmerType
        while (true) {
            System.out.println("1. Motionist");
            System.out.println("2. Konkurrencesvømmer");

            int choice = userInput.getIntInput();

            if (choice == 1) {
                swimmerType = "Motionist";
                Member member = new Member(subscriptionType, swimmerType);


                break; // Find en bedre løsning
            } else if (choice == 2) {
                swimmerType = "Konkurrencesvømmer";
                break;
            } else {
                msg.errorMessageInt();
            }
        }
        if (swimmerType.equals("Konkurrencesvømmer")) {
            chooseDiscipline();
        }

    }

    private String chooseDiscipline() {
        Discipline disciplineChoice;
        System.out.println("Vælg disciplin:\n1. " +
                Discipline.BUTTERFLY.getName() +
                "\n2. " + Discipline.CRAWL.getName() +
                "\n3. " + Discipline.RYGCRAWL.getName() +
                "\n4. " + Discipline.BRYSTSVØMNING.getName()
        );


        while (true) {
            int choice = userInput.getIntInput();

            if (choice == 1) {
                disciplineChoice = Discipline.BUTTERFLY;
            } else if (choice == 2) {
                disciplineChoice = Discipline.CRAWL;
            } else if (choice == 3) {
                disciplineChoice = Discipline.RYGCRAWL;
            } else if (choice == 4) {
                disciplineChoice = Discipline.BRYSTSVØMNING;
            } else {
                msg.errorMessageInt();
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
