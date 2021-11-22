package dolphin.operations;

import dolphin.FileManager;
import dolphin.members.*;
import dolphin.util.MSG;
import dolphin.util.UserInput;
import java.util.ArrayList;
import java.util.HashSet;

// Lu & David
public class CreateMember {
    public ArrayList<Member> allMembers = new ArrayList<>(); //TEST 1
    public ArrayList<Member> casualMembers = new ArrayList<>(); //TEST 1
    public ArrayList<CompetitiveMember> competitiveMembers = new ArrayList<>(); //TEST 1

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
        SubscriptionType subscriptionType;
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
            System.out.println("1. " + SubscriptionType.ACTIVE.getName());
            System.out.println("2. " + SubscriptionType.PASSIVE.getName());

            int choice = userInput.getIntInput();

            if (choice == 1) {
                subscriptionType = SubscriptionType.ACTIVE;
                break; // Find en bedre løsning
            } else if (choice == 2) {
                subscriptionType = SubscriptionType.PASSIVE;
                break;
            } else {
                msg.errorMessageInt();
            }
        }

        //swimmerType
        while (true) {
            System.out.println("1. " + SwimmerType.CASUAL.getName());
            System.out.println("2. " + SwimmerType.COMPETITIVE.getName());

            int choice = userInput.getIntInput();

            if (choice == 1) {
                swimmerType = "Motionist";
                Member member = new Member(memberName, memberYearOfBirth, subscriptionType, swimmerType);
                casualMembers.add(member);

                break; // Find en bedre løsning
            } else if (choice == 2) {
                swimmerType = "Konkurrencesvømmer";
                break;
            } else {
                msg.errorMessageInt();
            }
        }
        if (swimmerType.equals("Konkurrencesvømmer")) {
            ArrayList<Discipline> disciplines = chooseDiscipline();
            CompetitiveMember member = new CompetitiveMember(memberName, memberYearOfBirth, subscriptionType, swimmerType, disciplines);
        }
    }

    private ArrayList<Discipline> chooseDiscipline() {
        Discipline disciplineChoice;
        System.out.println("Vælg disciplin:\n1. " +
                Discipline.BUTTERFLY.getName() +
                "\n2. " + Discipline.CRAWL.getName() +
                "\n3. " + Discipline.RYGCRAWL.getName() +
                "\n4. " + Discipline.BRYSTSVØMNING.getName() +
                "\n5. FÆRDIG");

        HashSet<Discipline> disciplines = new HashSet<>(); // Der kan ikke være duplicates af disciplin-værdierne

        boolean addingDiciplines = true;
        while (addingDiciplines) {
            int choice = userInput.getIntInput();

            if (choice == 1) {
                disciplines.add(Discipline.BUTTERFLY);
                System.out.println("Butterfly er blevet tilføjet");
            } else if (choice == 2) {
                disciplines.add(Discipline.CRAWL);
                System.out.println("Crawl er blevet tilføjet");
            } else if (choice == 3) {
                disciplines.add(Discipline.RYGCRAWL);
                System.out.println("Rygcrawl er blevet tilføjet");
            } else if (choice == 4) {
                disciplines.add(Discipline.BRYSTSVØMNING);
                System.out.println("Brystsvømning er blevet tilføjet");
            } else if (choice == 5) {
                addingDiciplines = false;
                System.out.println("Tilføjet disciplin(er): " + disciplines);
            } else if (choice < 1 || choice > 5) {
                msg.errorMessageInt();
            }
        }
        return new ArrayList<>(disciplines);
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

    public void addToCasualFile() {
        FileManager fileManager = new FileManager("casualFile.csv");
        for (Member member : this.casualMembers) {
            fileManager.writeLineToCsv(member.toFileString());
        }
    }

    public void addToCompetitiveFile() {
        FileManager fileManager = new FileManager("competitiveFile.csv");
        for (CompetitiveMember competitiveMember : this.competitiveMembers) {
            fileManager.writeLineToCsv(competitiveMember.toFileString());
        }
    }

}
