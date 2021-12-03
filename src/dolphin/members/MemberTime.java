package dolphin.members;

import dolphin.util.SwimmingTime;

public class MemberTime implements Comparable<MemberTime> {
  private CompetitiveMember competitiveMember;
  private SwimmingTime swimmingTime;

  public MemberTime(CompetitiveMember competitiveMember, SwimmingTime swimmingTime)  {
    this.competitiveMember = competitiveMember;
    this.swimmingTime = swimmingTime;

  }
  public int getMemberId() {
    return this.competitiveMember.getId();
  }

  public String getCompetitiveMemberName() {
    return this.competitiveMember.getMemberName();
  }

  public String getFormattedSwimmingTime() {
    return this.swimmingTime.toString();
  }

  public int compareTo(MemberTime memberTime) {
  if (this.swimmingTime.getTotalTime() > memberTime.swimmingTime.getTotalTime()) {
    return -1;

  } else if (this.swimmingTime.getTotalTime() == memberTime.swimmingTime.getTotalTime()) {
    return 0;
  } else {
    return 1;
  }
}

}
