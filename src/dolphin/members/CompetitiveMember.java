package dolphin.members;

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
        String[] disciplines = memberInfo[6].split(":");

        Butterfly butterfly = new Butterfly();
        Crawl crawl = new Crawl();
        Backcrawl backcrawl = new Backcrawl();
        Brystsvømning brystsvømning = new Brystsvømning();

        for (String discipline : disciplines) {
            if (discipline.equals(butterfly.getName())) {
                this.disciplines.add(butterfly);
            } else if (discipline.equals(crawl.getName())) {
                this.disciplines.add(crawl);
            } else if (discipline.equals(backcrawl.getName())) {
                this.disciplines.add(backcrawl);
            } else if (discipline.equals(brystsvømning.getName())) {
                this.disciplines.add(brystsvømning);
            }
        }

    }

    public String toFileString() {
        String fileString = super.toFileString() + ",";
        ArrayList<String> disciplinesString = new ArrayList<>();

        for (Discipline discipline : this.disciplines) {
            disciplinesString.add(discipline.toString());
        }

        fileString += String.join(":", disciplinesString);
        return fileString;
    }

    public ArrayList<Discipline> getDisciplines() {
        return this.disciplines;
    }

}
