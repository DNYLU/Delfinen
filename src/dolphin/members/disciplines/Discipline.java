package dolphin.members.disciplines;

import dolphin.util.Date;
import dolphin.util.SwimmingTime;

/**
 * @author David
 * @author Lu
 * @author Umaid
 */

public abstract class Discipline implements Comparable<Discipline> {
    protected Date date;
    protected SwimmingTime swimmingTime;
    protected String name;


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

  public void setDataFromFileLine(String line) {
    String[] data = line.split("-");

    this.name = data[0];

    if (data.length > 1) {
      this.swimmingTime = new SwimmingTime();
      this.swimmingTime.setDataFromFileLine(line);
    }

    if (data.length > 2) {
      this.date = new Date();
      this.date.setDataFromFileLine(line);
    }
  }

  public int compareTo(Discipline discipline) {
    if (this.swimmingTime.getTotalTime() > discipline.swimmingTime.getTotalTime()) {
      return -1;

    } else if (this.swimmingTime.getTotalTime() == discipline.swimmingTime.getTotalTime()) {
      return 0;
    } else {
      return 1;
    }
  }

    public String toFileString () {
      String dateString = "";
      String swimmingString = "";
      if (this.date != null) {
        dateString = "-" + this.date.toFileString();
      }
      if (this.swimmingTime != null) {
        swimmingString = "-" + this.swimmingTime.toFileString();

      }
      return this.name + swimmingString + dateString;
    }

    public void setDate (Date date){
      this.date = date;
    }

    public String toString () {
      return this.name;
    }
  }
