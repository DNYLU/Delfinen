package dolphin.util;

import dolphin.members.Discipline;

/**
 * @author Lu
 * @author David
 */

public class CompetitionResult {
    int memberId;
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

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
