package dolphin.file;

import dolphin.members.CompetitiveMember;
import dolphin.members.Member;

import java.util.ArrayList;

public class FileApi {
    private final String casualPath = "casualFile.csv";
    private final String competitivePath = "competitiveFile.csv";

    public void writeCasualMember(Member member) {
        this.writeMember(member, this.casualPath);
    }

    public void writeCompetitiveMember(Member member) {
        this.writeMember(member, this.competitivePath);
    }

    private void writeMember(Member member, String path) {
        FileManager fileManager = new FileManager(path);
        fileManager.writeLineToCsv(member.toFileString());
    }

    public ArrayList<Member> getAllMembers() {
        FileManager fileManager = new FileManager(this.casualPath);
        FileManager fileManager1 = new FileManager(this.competitivePath);

        ArrayList<String[]> casualMembers = fileManager.readLinesFromCsv();
        ArrayList<String[]> competitiveMembers = fileManager1.readLinesFromCsv();
        ArrayList<Member> allMembers = new ArrayList<>();

        if (casualMembers != null) {
            for (String[] casualMember : casualMembers) {
                Member member = new Member();
                member.setDataFromFileLine(String.join(",", casualMember));
                allMembers.add(member);
            }
        }

        if (competitiveMembers != null) {
            for (String[] competitiveMember : competitiveMembers) {
                CompetitiveMember member = new CompetitiveMember();
                member.setDataFromFileLine(String.join(",", competitiveMember));
                allMembers.add(member);
            }
        }
        return allMembers;
    }

    public Member findMember(int id) {
        ArrayList<Member> members = this.getAllMembers();
        Member member = null;
        for (Member member1 : members) {
            if (member1.getId() == id) {
                member = member1;

            }

        }
        return member;
    }

}
