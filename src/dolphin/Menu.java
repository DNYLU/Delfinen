package dolphin;

import java.util.Scanner;
public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;

    public Menu(String menuHeader, String leadText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }

    public void printMenu() {
        System.out.println(leadText);

        for (int i = 0; i < menuItems.length; i++) {
            if (menuItems[i] != null) {
                System.out.println(menuItems[i]);
            }
        }
    }

    public int readChoice() {
        Scanner scan = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1;
        while (!validChoice) {
            //System.out.println(leadText);
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                validChoice = true;
            } else {
                scan.nextLine();
                System.out.println("Invalid input");
            }
        }
        return choice;
    }
}
