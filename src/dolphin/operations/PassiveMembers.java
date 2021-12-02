/*package dolphin.operations;

import dolphin.file.FileManager;
import dolphin.members.CompetitiveMember;
import dolphin.members.Member;
import java.util.ArrayList;
// Dannie
public class PassiveMembers {

  public void passiveMembers () {
  FileManager fileManager = new FileManager("CasualMembers.csv");
  FileManager fileManager1 = new FileManager("CompetitiveMembers.csv");
  ArrayList<String[]> casualMembers = new ArrayList<>(fileManager.readMembersFromCsv());
  ArrayList<String[]> competitiveMembers = new ArrayList<>(fileManager1.readMembersFromCsv());
  ArrayList<Member> passiveMembers = new ArrayList<>();

  for (String[] casualMember : casualMembers) {
    Member member = new Member();
    member.setDataFromFileLine(String.join(" ", casualMember));
    passiveMembers.add(member);
  }
    for (String[] competitiveMember : competitiveMembers) {
    CompetitiveMember member = new CompetitiveMember();
    member.setDataFromFileLine(String.join(" ", competitiveMember));
    passiveMembers.add(member);
  }
    for (int i = passiveMembers.size() - 1; i >= 0; i--) {  // Den tæller baglæns fra max -> 0
    if (passiveMembers.get(i).getPassiveMembers() == 0) {
      passiveMembers.remove(i);
    }
    for (Member member : passiveMembers) {
      System.out.println(member.getMemberName();
    }
  }
}
*/