package dolphin.operations;

import dolphin.file.FileApi;
import dolphin.members.Member;

import java.util.ArrayList;

public class AllMembers {

  public void allMembers() {
    FileApi fileApi = new FileApi();
    ArrayList<Member> allMembers = fileApi.getAllMembers();

    for (Member member : allMembers) {
      System.out.println(member.getMemberName());
    }
  }
}