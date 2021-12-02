package dolphin.menu;

import dolphin.Menu;
import dolphin.operations.AllMembers;
import dolphin.operations.CreateMember;

/**
 * @author Lu
 */

public class Chairman {

    public void run() {
        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "-----FORMAND-----", menuItems);
        menuItems[1] = "1. Opret nyt medlem.";
        menuItems[2] = "2. Vis medlemmer af Delfinen.";

        menuItems[9] = "\n9. TILBAGE"; // Kald det noget andet

        boolean checkChoice = true;
        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    CreateMember createMember = new CreateMember();
                    createMember.run();
                    break;

                case 2:
                    AllMembers allMembers = new AllMembers();
                    allMembers.allMembers();
                    break;

                case 9:
                    checkChoice = false;
                    break;

                default: //Hvis input er "forkert"
                    System.out.println("Lorte input");
                    menu.printMenu();
                    checkChoice = false;
            }
        }
        while (checkChoice); // Loop der kører, så længe den er true
    }
}
