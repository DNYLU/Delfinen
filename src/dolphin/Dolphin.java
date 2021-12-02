package dolphin;
import dolphin.members.Contingent;
import dolphin.menu.Chairman;
import dolphin.menu.Coach;
import dolphin.menu.Treasurer;
import dolphin.operations.AllMembers;
import dolphin.operations.CreateMember;
import dolphin.operations.DebtMembers;
import dolphin.operations.Registration;

/**
 * @author Lu
 */

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
        menuItems[1] = "1. FORMAND";
        menuItems[2] = "2. KASSERER";
        menuItems[3] = "3. SVØMMETRÆNER";

        menuItems[9] = "\n9. QUIT"; // Kald det noget andet


        boolean checkChoice = true;

        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    Chairman chairman = new Chairman();
                    chairman.run();
                    break;

                case 2:
                    Treasurer treasurer = new Treasurer();
                    treasurer.run();
                    break;

               case 3:
                   Coach coach = new Coach();
                   coach.run();
                    break;

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
