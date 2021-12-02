package dolphin.operations;

import dolphin.members.CompetitiveMember;
import dolphin.members.Member;
import dolphin.util.UserInput;
import dolphin.file.FileApi;

/**
 * @author Lu
 */

public class FindCompetitiveMember {

    UserInput userInput = new UserInput();
    FileApi fileApi = new FileApi();

    public CompetitiveMember findID() {
        Member member = null;

            // Finder member via ID
            System.out.println("Indtast ID: ");
            boolean findMember = true;

            while (findMember) {
                int id = userInput.getIntInput();
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
