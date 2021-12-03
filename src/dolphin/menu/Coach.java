package dolphin.menu;

import dolphin.operations.Registration;
import dolphin.operations.SwimmingCompetition;

/**
 * @author Lu
 */

public class Coach {
    public void run() {
        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "-----SVØMMETRÆNER-----", menuItems);
        menuItems[1] = "1. Indtast træningstid.";
        menuItems[2] = "2. Opret stævne.";
        menuItems[3] = "3. Vis klubbens Top 5";

        menuItems[9] = "\n9. TILBAGE"; // Kald det noget andet

        boolean checkChoice = true;
        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    Registration registration = new Registration();
                    registration.run();
                    break;

                case 2:
                    SwimmingCompetition swimmingCompetition = new SwimmingCompetition();
                    swimmingCompetition.run();
                    break;

                case 3:
                    Top5Menu top5Menu = new Top5Menu();
                    top5Menu.run();
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
