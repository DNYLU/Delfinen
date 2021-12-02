package dolphin.members.disciplines;

public class BreastStroke extends Discipline {

  public BreastStroke() {
    super("Brystsvømning");
  }

  public int compareTo(BreastStroke breastStroke) {
    if (this.swimmingTime.getTotalTime() > breastStroke.swimmingTime.getTotalTime()) {
      return -1;

    } else if (this.swimmingTime.getTotalTime() == breastStroke.swimmingTime.getTotalTime()) {
      return 0;
    } else {
      return 1;
    }
  }

}
