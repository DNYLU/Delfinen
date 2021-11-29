package dolphin;
import dolphin.members.Contingent;
import dolphin.operations.AllMembers;
import dolphin.operations.CreateMember;
import dolphin.operations.DebtMembers;
import dolphin.operations.Registration;

public class Dolphin {
    public static void main(String[] args) {
        Dolphin dolphin = new Dolphin();
        dolphin.run();
    }

    /*
     TODO:
        Svømmetræner:
        - Registrering af stævne, placering og tid
        - Oversigt over klubbens top 5 svømmer inden for HVER disciplin
        Filhåndtering:
        - Vi laver 2 filer som er junior og senior.
        - Inde i de filer har vi de 4 forskellige discipliner, som den skal opdatere selv med de bedste tider inde for det forskellige grene.
        - Her bruger vi collection.sort til at finde de bedste tider og placere dem i den rigtige rækkefølge.
        */

    private void run() {
        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "-----HOVEDMENU-----", menuItems);
        menuItems[1] = "1. Opret nyt medlem.";
        menuItems[2] = "2. Vis medlemmer af Delfinen.";
        menuItems[3] = "\n3. Vis medlemmer i restance.";
        menuItems[4] = "4. Vis forventet kontigent.";
        menuItems[5] = "\n5. Stævne";

        menuItems[9] = "\n9. QUIT"; // Kald det noget andet


        boolean checkChoice = true;

        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    System.out.println("Opretter nyt medlem");
                    CreateMember createMember = new CreateMember();
                    createMember.run();
                    break;

                case 2:
                    AllMembers allMembers = new AllMembers();
                    allMembers.allMembers();
                    break;

               case 3:
                    DebtMembers debtMembers = new DebtMembers();
                    debtMembers.debtMembers();
                    break;

                case 4:
                    Contingent contingent = new Contingent(); // Her henter vi hele det samlede kontigent beløb.
                    contingent.totalContingent();
                    System.out.println(contingent);
                    break;

                case 5:
                    Registration registration = new Registration();
                    registration.run();

                case 9:
                    System.out.println("Slutter programmet");
                    checkChoice = false;
                    break;

                default: //Hvis input er "forkert"
                    System.out.println("Lorte input");
                    menu.printMenu();
                    checkChoice = false;
            }
        }
        while (checkChoice); // Loop der kører, så længe den er false
    }
}
