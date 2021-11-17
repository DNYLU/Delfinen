import java.util.Scanner;

public class UserInput {
    private Scanner scan = new Scanner(System.in);

    public String getStringInput() {
        return scan.nextLine();
    }

    public int getIntInput() {
        return scan.nextInt();
    }
}
