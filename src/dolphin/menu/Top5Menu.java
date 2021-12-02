package dolphin.menu;

import dolphin.Menu;
import dolphin.members.disciplines.Backcrawl;
import dolphin.members.disciplines.BreastStroke;
import dolphin.members.disciplines.Butterfly;
import dolphin.members.disciplines.Crawl;
import dolphin.util.Top5;

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

        menuItems[9] = "\n9. QUIT"; // Kald det noget andet

        boolean checkChoice = true;
        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    top5.run(new Backcrawl().getName());
                    break;

                case 2:
                    top5.run(new BreastStroke().getName());
                    break;

                case 3:
                    top5.run(new Butterfly().getName());
                    break;

                case 4:
                    top5.run(new Crawl().getName());
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
