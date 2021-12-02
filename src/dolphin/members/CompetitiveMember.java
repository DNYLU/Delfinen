package dolphin.members;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author David
 */
public class CompetitiveMember extends Member {

    private ArrayList<Discipline> disciplines;

    public CompetitiveMember() {

    }

    public CompetitiveMember(String memberName, int memberYearOfBirth, SubscriptionType subscriptionType, String swimmerType, ArrayList<Discipline> discipline, int id) {
        super(memberName, memberYearOfBirth, subscriptionType, swimmerType, id);
        this.disciplines = discipline;

    }

    public void setDataFromFileLine(String line) {
        this.disciplines = new ArrayList<>();
        super.setDataFromFileLine(line);
        String[] memberInfo = line.split(",");
        String[] disciplines = memberInfo[7].split(":");

        for (String disciplineString : disciplines) {
            Discipline discipline = new Discipline();
            discipline.setDataFromFileLine(disciplineString);

            this.disciplines.add(discipline);
        }
    }

    public String toFileString() {
        String fileString = super.toFileString() + ",";
        ArrayList<String> disciplinesString = new ArrayList<>();

        for (Discipline discipline : this.disciplines) {
            disciplinesString.add(discipline.toFileString());
        }

        fileString += String.join(":", disciplinesString);
        System.out.println(fileString);
        return fileString;
    }

    public ArrayList<Discipline> getDisciplines() {
        return this.disciplines;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

}
