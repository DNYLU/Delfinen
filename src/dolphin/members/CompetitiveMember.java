package dolphin.members;

import dolphin.members.disciplines.*;

import java.util.ArrayList;

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


        Butterfly butterfly = new Butterfly();
        Crawl crawl = new Crawl();
        Backcrawl backcrawl = new Backcrawl();
        BreastStroke breastStroke = new BreastStroke();

        for (int i = 0; i < disciplines.length; i++) {
            Discipline discipline = new Butterfly();
            discipline.setDataFromFileLine(disciplines[i]);

            if (discipline.getName().equals(butterfly.getName())) {
                this.disciplines.add((Butterfly) discipline);
            } else if (discipline.getName().equals(crawl.getName())) {
                this.disciplines.add(discipline);
            } else if (discipline.getName().equals(backcrawl.getName())) {
                this.disciplines.add(discipline);
            } else {
                this.disciplines.add(discipline);
            }
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
