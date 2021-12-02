package dolphin.util;
import java.util.Scanner;

/**
 * @author Lu
 */

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

    public double getDoubleInput() {
        while (!scan.hasNextDouble()) {
            msg.errorMessageInt();
            scan.next();
        }
        return scan.nextDouble();
    }
}

