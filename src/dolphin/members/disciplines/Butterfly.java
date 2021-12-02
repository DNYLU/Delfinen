package dolphin.members.disciplines;

public class Butterfly extends Discipline {

  public Butterfly() {
    super("Butterfly");
  }

  public int compareTo(Butterfly butterfly) {
    if (this.swimmingTime.getTotalTime() > butterfly.swimmingTime.getTotalTime()) {
      return -1;

    } else if (this.swimmingTime.getTotalTime() == butterfly.swimmingTime.getTotalTime()) {
      return 0;
    } else {
      return 1;
    }
  }

}
