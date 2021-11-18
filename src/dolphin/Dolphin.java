package dolphin;

import dolphin.operations.CreateMember;

public class Dolphin {
    public static void main(String[] args) {
        Dolphin dolphin = new Dolphin();
        dolphin.run();

    }

    /* TODO:
        Formand:
        - Opret nyt medlem
        - Vis alle medlemmer
        Kassereren:
        - Vis forventet kontingent
        - Vis medlemmer i restance
        Svømmetræner:
        - Registrering af stævne, placering og tid
        - Oversigt over klubbens top 5 svømmere inden for HVER disciplin*/

    private void run() {
        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "Choose option", menuItems);
        menuItems[1] = "1. Opret nyt medlem";
        menuItems[2] = "2. et eller andet";

        menuItems[9] = "9. QUIT"; // Kald det noget andet

        menu.printMenu();

        boolean checkChoice = true;

        do {
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    System.out.println("Opretter nyt medlem");
                    CreateMember createMember = new CreateMember();
                    createMember.run();
                    break;

                    // Metode der opretter nyt medlem i stedet for
                case 2:
                    System.out.println("noget");
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
