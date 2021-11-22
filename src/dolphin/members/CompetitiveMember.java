package dolphin.members;

import java.util.ArrayList;
import java.util.HashSet;

public class CompetitiveMember extends Member {

    private ArrayList<Discipline> disciplines;

    public CompetitiveMember(String memberName, int memberYearOfBirth, SubscriptionType subscriptionType, String swimmerType, ArrayList<Discipline> discipline) {
        super(memberName, memberYearOfBirth, subscriptionType, swimmerType);
        this.disciplines = discipline;

    }

    public void setDataFromFileLine(String line) {
        super.setDataFromFileLine(line);
        String[] string = line.split(",");
        String[] string1 = string[6].split(":");

        for (String discipline : string1) {
            this.disciplines.add(Discipline.valueOf(discipline));
        }

    }

    public String toFileString() {
        String fileString = super.toFileString() + ",";
        ArrayList<String> disciplinesString = new ArrayList<>();

        for (Discipline discipline : this.disciplines) {
            disciplinesString.add(discipline.getName());
        }

        fileString += String.join(":", disciplinesString);
        return fileString;
    }

}
