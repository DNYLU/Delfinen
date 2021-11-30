package dolphin.members.disciplines;

import dolphin.util.Date;
import dolphin.util.SwimmingTime;

public abstract class Discipline {
  private Date date;
  private SwimmingTime swimmingTime;
  private String name;

  Discipline(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public String getFormattedTime() {
    return this.swimmingTime.toString();
  }

  public void setSwimmingTime(SwimmingTime swimmingTime) {
    if (this.swimmingTime == null) {

      this.swimmingTime = swimmingTime;
    } else if (swimmingTime != null) {

      if (swimmingTime.getTotalTime() < this.swimmingTime.getTotalTime()) {

        this.swimmingTime = swimmingTime;
      }
    }
  }

  public String toFileString() {
    String dateString = "";
    String swimmingString = "";
    if (this.date != null) {
      dateString = "-" + this.date.toFileString();
    }
    if (this.swimmingTime != null) {
      swimmingString = "-" + this.swimmingTime.toFileString();

    }
    return this.name + dateString + swimmingString;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String toString() {
    return this.name;
  }
}
