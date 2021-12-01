package dolphin.file;

import dolphin.members.CompetitiveMember;
import dolphin.members.Member;
import dolphin.util.CompetitionResult;

import java.util.ArrayList;

public class FileApi {
    private final String casualPath = "casualFile.csv";
    private final String competitivePath = "competitiveFile.csv";

    public void writeCasualMember(Member member) {
        this.writeMember(member, this.casualPath);
    }

    public void writeCompetitiveMember(CompetitiveMember competitiveMember) {
        this.writeMember(competitiveMember, this.competitivePath);
    }

    private void writeMember(Member member, String path) {
        FileManager fileManager = new FileManager(path);
        fileManager.writeLineToCsv(member.toFileString());
    }

    private void editMember(Member member, String path) {
        FileManager fileManager = new FileManager(path);
        fileManager.editMember(member.getId(), member.toFileString());
    }

    public void editCompetitiveMember(CompetitiveMember member) {
        this.editMember(member, this.competitivePath);
    }

    public void editCasualMember(Member member) {
        this.editMember(member, this.casualPath);
    }

    private void overWriteAllMembers(String path) {
        FileManager fileManager = new FileManager(path);

        ArrayList<Member> allMembers = this.getAllMembers();
        StringBuilder allMembersString = new StringBuilder();

        for (Member member : allMembers) {
            allMembersString.append(member.toFileString()).append("\n");
        }
        System.out.println(allMembersString);
        fileManager.overwriteFile(allMembersString.toString());
    }

    public void overWriteCompetitiveMembers() {
        this.overWriteAllMembers(this.competitivePath);
    }

    public void overWriteCasualMembers() {
        this.overWriteAllMembers(this.casualPath);
    }

    public void insertCompetitionResult(CompetitionResult competitionResult, int id) {
        String path = "Members";
        FileManager fileManager = new FileManager(path);
        fileManager.createFolder();
        fileManager.setPath(path + "/" +id);
        fileManager.createFolder();

        fileManager.setPath(path + "/" + id + "/competitionResults.csv");
        fileManager.writeLineToCsv(competitionResult.toFileString());
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
                System.out.println(member.getId());

            }

        }
        return member;
    }

}
