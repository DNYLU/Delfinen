package dolphin.operations;

import dolphin.file.FileApi;
import dolphin.members.Member;

import java.util.ArrayList;
import java.util.Locale;

public class AllMembers {

  public void allMembers() {
    FileApi fileApi = new FileApi();
    ArrayList<Member> allMembers = fileApi.getAllMembers();

    for (Member member : allMembers) {
      // Dette bliver lavet for, at kunne gøre det første bogstav stort
      String output = member.getMemberName().substring(0, 1).toUpperCase() + member.getMemberName().substring(1);
      System.out.println(member.getId() + " " + output);
    }
  }
}