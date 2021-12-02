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
