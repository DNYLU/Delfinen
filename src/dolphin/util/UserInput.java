package dolphin.util;
import dolphin.file.FileApi;
import dolphin.members.CompetitiveMember;
import dolphin.members.Member;

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

    public CompetitiveMember findID() {
        Member member = null;
        FileApi fileApi = new FileApi();

        // Finder member via ID
        System.out.println("Indtast ID: ");
        boolean findMember = true;

        while (findMember) {
            int id = this.getIntInput();
            member = fileApi.findMember(id);

            if (member == null) {
                System.out.println("Medlem med ID: " + id + " blev ikke fundet");
            } else if (!(member instanceof CompetitiveMember)) {
                System.out.println("Medlem er ikke en konkurrencesvømmer");
            } else {
                member.getMemberName();
                findMember = false;
            }
        }
        return (CompetitiveMember)member;
    }
}

