package dolphin.util;

import dolphin.members.Discipline;

/**
 * @author Lu
 * @author David
 */

public class CompetitionResult {
    int memberID;
    int placement;
    Discipline discipline;

    public String toFileString() {
        return
                this.discipline.toFileString() + " " +
                this.placement;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
