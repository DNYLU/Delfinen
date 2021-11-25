package dolphin;
import dolphin.members.Contingent;
import dolphin.operations.AllMembers;
import dolphin.operations.CreateMember;
import dolphin.operations.DebtMembers;
//import dolphin.operations.PassiveMembers;

public class Dolphin {
    public static void main(String[] args) {
        Dolphin dolphin = new Dolphin();
        dolphin.run();

    }

    /*
     TODO:
        Formand:
        - Opret nyt medlem
        - Vis alle medlemmer. Dannie
        Kassereren:
        - Vis forventet kontingent. dannie // file api har en modtode som henter alle medlemmere og retur dem.
        - Vis medlemmer i restance
        Svømmetræner:
        - Registrering af stævne, placering og tid
        - Oversigt over klubbens top 5 svømmere inden for HVER disciplin
        Filhåndtering:
        - Vi laver 2 filer som er junior og senior.
        - Inde i de filer har vi de 4 forskellige discipliner, som den skal opdatere selv med de bedste tider inde for det forskellige grene.
        - Her bruger vi collection.sort til at finde de bedste tider og placere dem i den rigtige rækkefølge.
        */

    private void run() {
        String[] menuItems = new String[10];
        Menu menu = new Menu("MENU", "-----HOVEDMENU-----", menuItems);
        menuItems[1] = "1. Opret nyt medlem.";
        menuItems[2] = "2. Medlemmer af Delfinen.";
        menuItems[3] = "3. Vis medlemmer i restance.";
        menuItems[4] = "4. Vis forventet kontigent.";

        menuItems[9] = "9. QUIT"; // Kald det noget andet


        boolean checkChoice = true;

        do {
            menu.printMenu();
            int choice = menu.readChoice();
            switch (choice) {
                case 1:
                    System.out.println("Opretter nyt medlem");
                    CreateMember createMember = new CreateMember();
                    createMember.run();
                    break;

                case 2:
                    System.out.println("Vælg et emne: ");
                    AllMembers allMembers = new AllMembers();
                    //PassiveMembers passiveMembers = new PassiveMembers();
                    //DebtMembers debtMembers = new DebtMembers();
                    allMembers.allMembers();
                    //passiveMembers.passiveMembers();
                    //debtMembers.debtMembers();

                    break;

                    // Metode der opretter nyt medlem i stedet for
               case 3:
                    DebtMembers debtMembers = new DebtMembers();
                    debtMembers.debtMembers();
                    break;

                case 4:
                    Contingent contingent = new Contingent(); // Her henter vi hele det samlede kontigent beløb.
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
