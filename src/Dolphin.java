public class Dolphin {
    public static void main(String[] args) {
        Dolphin dolphin = new Dolphin();
        dolphin.run();
    }

    /*
    * Formand:
    * Opret nyt medlem
    * Vis alle medlemmer
    *
    * Kassereren:
    * Vis forventet kontingent
    * Vis medlemmer i restance
    *
    * Svømmetræner:
    * Registrering af stævne, placering og tid
    * Oversigt over klubbens top 5 svømmere inden for HVER disciplin*/

    private void run() {
        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "Choose option", menuItems);
        menuItems[1] = "1. Opret nyt medlem";
        menuItems[2] = "2. et eller andet";

        menuItems[9] = "9. QUIT"; // Kald det noget andet

        menu.printMenu();

        int choice = menu.readChoice();
        boolean checkChoice;

        do {
            switch (choice) {
                case 1:
                    System.out.println("Opretter nyt medlem");
                    checkChoice = true; // Metode der opretter nyt medlem i stedet for
                case 2:
                    System.out.println("noget");
                    checkChoice = true;

                case 9:
                    System.out.println("Slutter programmet");
                    checkChoice = true;
                    break;

                default: //Hvis input er "forkert"
                    System.out.println("Lorte input");
                    menu.printMenu();
                    choice = menu.readChoice(); // Så metoden kører igen
                    checkChoice = false;
            }
        }
        while (!checkChoice); // Loop der kører, så længe den er false
    }
}
