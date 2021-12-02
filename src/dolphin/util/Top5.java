package dolphin.util;

import dolphin.MemberTime;
import dolphin.file.FileApi;
import dolphin.members.AgeGroup;
import dolphin.members.CompetitiveMember;
import dolphin.members.Discipline;
import dolphin.operations.AllMembers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Lu
 * @author David
 * @author Umaid
 */

public class Top5 {
    FileApi fileApi = new FileApi();
    AllMembers allMembers = new AllMembers();


    private ArrayList<CompetitiveMember> sortSeniorCompetitiveMembers() {
        ArrayList<CompetitiveMember> competitiveMembers = fileApi.getCompetitiveMembers();
        ArrayList<CompetitiveMember> sortedSenior = new ArrayList<>();
        for (CompetitiveMember member : competitiveMembers) {
            if (member.getAgeGroup().equals(AgeGroup.SENIOR)) {
                sortedSenior.add(member);
            }
        }
        return sortedSenior;
    }

    private ArrayList<CompetitiveMember> sortJuniorCompetitiveMembers() {
        ArrayList<CompetitiveMember> competitiveMembers = fileApi.getCompetitiveMembers();
        ArrayList<CompetitiveMember> sortedJunior = new ArrayList<>();

        for (CompetitiveMember member : competitiveMembers) {
            if (member.getAgeGroup().equals(AgeGroup.JUNIOR)) {
                sortedJunior.add(member);
            }
        }
        return sortedJunior;
    }

    public ArrayList<MemberTime> topFive(ArrayList<CompetitiveMember> members, String name) {
        ArrayList<MemberTime> memberTimes = new ArrayList<>();
        for (CompetitiveMember competitiveMember : members) {
            for (Discipline discipline : competitiveMember.getDisciplines()) {

                if (discipline.getName().equals(name)) {

                    if (!(discipline.getSwimmingTime() == null)) {
                        MemberTime memberTime = new MemberTime(competitiveMember, discipline.getSwimmingTime());
                        memberTimes.add(memberTime);
                    }
                }
            }
        }
        return memberTimes;
    }

    public void run(String name) {
        ArrayList<CompetitiveMember> juniorMember = sortJuniorCompetitiveMembers();
        ArrayList<CompetitiveMember> seniorMember = sortSeniorCompetitiveMembers();

        ArrayList<MemberTime> juniorDiscipline = topFive(juniorMember, name);
        ArrayList<MemberTime> seniorDiscipline = topFive(seniorMember, name);
        Collections.sort(juniorDiscipline);
        Collections.sort(seniorDiscipline);

        displayTop5(juniorDiscipline);
        displayTop5(seniorDiscipline);
    }

    public void displayTop5(ArrayList<MemberTime> memberTimes) {
        boolean displayTop5 = true;
        int index = 0;
        while (displayTop5) {
            if (index >= memberTimes.size()) {
                displayTop5 = false;
            } else if (index == 5) {
                displayTop5 = false;
            } else {
                String nameId = memberTimes.get(index).getMemberId() + " " + memberTimes.get(index).getCompetitiveMemberName();
                String formattedSwimTime = memberTimes.get(index).getFormattedSwimmingTime();
                System.out.println(nameId + ": " + formattedSwimTime);
                index++;
            }

        }
    }

}
