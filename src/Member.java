public class Member {
  private String memberName;
  private int memberYearOfBirth;
  private String memberDesciplin;
  private boolean memberActive;

  public Member(String memberName, String memberDesciplin, int memberYearOfBirth, boolean memberActive) {
  }

  public void setMemberName() {
    this.memberName = memberName;
  }
  public String getMemberName() {
    return memberName;
  }

  public void setMemberYearOfBirth() {
    this.memberYearOfBirth = memberYearOfBirth;
  }
  public int getMemberYearOfBirth() {
    return memberYearOfBirth;
  }

  public void setMemberDesciplin(String memberDesciplin) {
    this.memberDesciplin = memberDesciplin;
  }
  public String getMemberDesciplin() {
    return memberDesciplin;
  }

  public void setMemberActive(boolean memberActive) {
    this.memberActive = memberActive;
  }
  public boolean isMemberActive() {
    return memberActive;
  }
}
