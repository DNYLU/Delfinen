package dolphin.operations;

import dolphin.FileManager;
import dolphin.members.Member;
import dolphin.members.CompetitiveMember;

import java.util.ArrayList;

public class DebtMembers {

  public void debtMembers() {
    FileManager fileManager = new FileManager("casualFile.csv");
    FileManager fileManager1 = new FileManager("competitiveFile.csv");
    ArrayList<String[]> casualMembers = new ArrayList<>(fileManager.readMembersFromCsv());
    ArrayList<String[]> competitiveMembers = new ArrayList<>(fileManager1.readMembersFromCsv());
    ArrayList<Member> debtMembers = new ArrayList<>();

    for (String[] casualMember : casualMembers) {
      Member member = new Member();
      member.setDataFromFileLine(String.join(",", casualMember));
      debtMembers.add(member);
    }
    for (String[] competitiveMember : competitiveMembers) {
      CompetitiveMember member = new CompetitiveMember();
      member.setDataFromFileLine(String.join(",", competitiveMember));
      debtMembers.add(member);
    }
    for (int i = debtMembers.size() - 1; i >= 0; i--) {  // Den tæller baglæns fra max -> 0
      if (debtMembers.get(i).getDebtAmount() == 0) {
        debtMembers.remove(i);
      }

    }
    for (Member member : debtMembers) {
      System.out.println(member.getMemberName() + ": " + member.getDebtAmount());
    }
  }
}
