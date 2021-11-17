import java.util.Scanner;

public class UserInput {
    MSG msg = new MSG();

    private Scanner scan = new Scanner(System.in);


    public String getStringInput() {
        while (!scan.hasNextLine()) {
            msg.errorMessageString();
            scan.next();
        }
        return scan.nextLine();
    }

    public int getIntInput() {
        while (!scan.hasNextInt()) {
            msg.errorMessageInt();
            scan.next();
        }
        return scan.nextInt();
    }
}

