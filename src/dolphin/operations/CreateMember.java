package dolphin.operations;

import dolphin.file.FileApi;
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
        SubscriptionType subscriptionType = null;
        String swimmerType;
        String discipline;

        System.out.println("-----Opret nyt medlem-----");
        memberName = nameCheck("Indtast navn: ");
        System.out.print("Indtast fødselsår: ");
        memberYearOfBirth = userInput.getIntInput();

        System.out.println(); // Bare en line

        // Aktivitetsform loops

        // subscriptionType
        boolean addingSubscriptionType = true;
        while (addingSubscriptionType) { // Skift while true om lidt til noget bedre
            System.out.println("Vælg medlemstype: "); // Aktiv eller passiv


            //Bedøm om jeg skal lave en switch her eller if statement
            System.out.println("1. " + SubscriptionType.ACTIVE.getName());
            System.out.println("2. " + SubscriptionType.PASSIVE.getName());

            int choice = userInput.getIntInput();
            if (choice == 1) {
                subscriptionType = SubscriptionType.ACTIVE;

                addingSubscriptionType = false;
            } else if (choice == 2) {
                subscriptionType = SubscriptionType.PASSIVE;

                addingSubscriptionType = false;
            } else {
                msg.errorMessageInt();
            }
        }

        //swimmerType
        boolean addingSwimmerType = true;
        int id = this.createId();
        while (addingSwimmerType) {
            System.out.println("1. " + SwimmerType.CASUAL.getName());
            System.out.println("2. " + SwimmerType.COMPETITIVE.getName());

            int choice = userInput.getIntInput();
            if (choice == 1) {
                swimmerType = SwimmerType.CASUAL.getName();
                Member member = new Member(memberName, memberYearOfBirth, subscriptionType, swimmerType, id);
                casualMembers.add(member);
                this.addToCasualFile();

                addingSwimmerType = false;
            } else if (choice == 2) {
                swimmerType = SwimmerType.COMPETITIVE.getName();
                ArrayList<Discipline> disciplines = chooseDiscipline();
                CompetitiveMember member = new CompetitiveMember(memberName, memberYearOfBirth, subscriptionType, swimmerType, disciplines, id);
                this.competitiveMembers.add(member);
                this.addToCompetitiveFile();
                addingSwimmerType = false;
            } else {
                msg.errorMessageInt();
            }
        }
    }

    private ArrayList<Discipline> chooseDiscipline() {
        Discipline disciplineChoice;

        HashSet<Discipline> disciplines = new HashSet<>(); // Der kan ikke være duplicates af disciplin-værdierne

        boolean addingDiciplines = true;
        while (addingDiciplines) {
            System.out.println("Vælg disciplin:" +
                    "\n1. " + Discipline.BUTTERFLY.getName() +
                    "\n2. " + Discipline.CRAWL.getName() +
                    "\n3. " + Discipline.RYGCRAWL.getName() +
                    "\n4. " + Discipline.BRYSTSVØMNING.getName() +
                    "\n\n9. FÆRDIG");
            int choice = userInput.getIntInput();

            if (choice == 1) {
                disciplines.add(Discipline.BUTTERFLY);
                System.out.println(Discipline.BUTTERFLY.getName() + " er blevet tilføjet\n");
            } else if (choice == 2) {
                disciplines.add(Discipline.CRAWL);
                System.out.println(Discipline.CRAWL.getName() + " er blevet tilføjet\n");
            } else if (choice == 3) {
                disciplines.add(Discipline.RYGCRAWL);
                System.out.println(Discipline.RYGCRAWL.getName() + " er blevet tilføjet\n");
            } else if (choice == 4) {
                disciplines.add(Discipline.BRYSTSVØMNING);
                System.out.println(Discipline.BRYSTSVØMNING.getName() + " er blevet tilføjet\n");
            } else if (choice == 9) {
                addingDiciplines = false;
                System.out.println("Tilføjet disciplin(er): " + disciplines + "\n");
            } else {
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
        FileApi fileApi = new FileApi();
        for (Member member : this.casualMembers) {
            fileApi.writeCasualMember(member);
        }
    }

    public void addToCompetitiveFile() {
        FileApi fileApi = new FileApi();
        for (CompetitiveMember member : this.competitiveMembers) {
            fileApi.writeCompetitiveMember(member);
        }
    }


    public int createId() {
        FileApi fileApi = new FileApi();

        int id = 0;
        boolean createNewId = true;
        while (createNewId) {
            Member member = fileApi.findMember(id);
            if (member == null)  {
                createNewId = false;
            } else {
                id++;
            }

        }
        return id;
    }
}
