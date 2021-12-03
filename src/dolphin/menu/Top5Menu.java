package dolphin.menu;

import dolphin.members.Disciplines;
import dolphin.operations.Top5;

/**
 * @author Lu
 * @author David
 */

public class Top5Menu {
    public void run() {
        Top5 top5 = new Top5();

        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "-----TOP 5-----", menuItems);
        menuItems[1] = "1. Rygcrawl";
        menuItems[2] = "2. Brystsvømning";
        menuItems[3] = "3. Butterfly";
        menuItems[4] = "4. Crawl";

        menuItems[9] = "\n9. TILBAGE"; // Kald det noget andet

        boolean checkChoice = true;
        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    top5.run(Disciplines.BACK_CRAWL.getName());
                    break;

                case 2:
                    top5.run(Disciplines.BREAST_STROKE.getName());
                    break;

                case 3:
                    top5.run(Disciplines.BUTTERFLY.getName());
                    break;

                case 4:
                    top5.run(Disciplines.CRAWL.getName());
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
