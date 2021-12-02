package dolphin.operations;

import dolphin.members.Member;
import dolphin.file.FileApi;

import java.util.ArrayList;

/**
 * @author David
 * @author Umaid
 */

public class DebtMembers {

  public void debtMembers() {
    FileApi fileApi = new FileApi();
    ArrayList<Member> debtMembers = fileApi.getAllMembers();

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
