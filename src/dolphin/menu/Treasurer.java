package dolphin.menu;

import dolphin.Menu;
import dolphin.members.Contingent;
import dolphin.operations.DebtMembers;

public class Treasurer {

    /**
     * @author Lu
     */

    public void run() {
        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "-----KASSERER-----", menuItems);
        menuItems[1] = "1. Vis medlemmer i restance.\"";
        menuItems[2] = "2. Vis forventet kontigent.";

        menuItems[9] = "\n9. QUIT"; // Kald det noget andet

        boolean checkChoice = true;
        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    DebtMembers debtMembers = new DebtMembers();
                    debtMembers.debtMembers();
                    break;

                case 2:
                    Contingent contingent = new Contingent(); // Her henter vi hele det samlede kontingent beløb.
                    contingent.totalContingent();
                    System.out.println(contingent);
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
