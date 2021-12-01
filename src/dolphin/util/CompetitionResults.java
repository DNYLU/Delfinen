package dolphin.util;

import dolphin.members.CompetitiveMember;
import dolphin.members.disciplines.Discipline;
import dolphin.operations.SwimmingCompetition;

public class CompetitionResults {
    int memberID;
    int placement;
    Date date;
    Discipline discipline;

    public String toFileString() {

        return this.date.toFileString() + " " +
                this.discipline.toFileString() + " " +
                this.placement;
    }

    public int getMemberID() {
        return memberID;
    }
}
