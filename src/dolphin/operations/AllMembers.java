package dolphin.operations;

import dolphin.FileManager;
import dolphin.members.CompetitiveMember;
import dolphin.members.Member;

import java.util.ArrayList;

public class AllMembers {


  public void allMembers() {
    FileManager fileManager = new FileManager("casualFile.csv");
    FileManager fileManager1 = new FileManager("competitiveFile.csv");
    ArrayList<String[]> casualMembers = fileManager.readMembersFromCsv();
    ArrayList<String[]> competitiveMembers = fileManager1.readMembersFromCsv();
    ArrayList<Member> allMembers = new ArrayList<>();

    for (String[] casualMember : casualMembers) {
      Member member = new Member();
      member.setDataFromFileLine(String.join(",", casualMember));
      allMembers.add(member);

    }
    for (String[] competitiveMember : competitiveMembers) {
      CompetitiveMember member = new CompetitiveMember();
      member.setDataFromFileLine(String.join(",", competitiveMember));
      allMembers.add(member);
    }
    for (Member member : allMembers) {
      System.out.println(member.getMemberName());
    }
  }
}