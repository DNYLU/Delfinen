package dolphin.members;

import dolphin.file.FileApi;

import java.util.ArrayList;

/**
 * @author Dannie
 */
public class Contingent {
  private double totalContingent;

  public void totalContingent() {
    FileApi fileApi = new FileApi();
    ArrayList<Member> allMembers = fileApi.getAllMembers();

    int totalContingent = 0;
    for (int i = 0; i < allMembers.size(); i++) {
      totalContingent += allMembers.get(i).getPaymentAmount();

    }
    this.setTotalContingent(totalContingent);

  }
  public void setTotalContingent(double totalContingent) {
    this.totalContingent = totalContingent;
  }

  public String toString() {
    return String.valueOf(this.totalContingent);
  }
}
