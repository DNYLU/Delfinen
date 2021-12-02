package dolphin.members.disciplines;

public class Backcrawl extends Discipline {

  public Backcrawl() {
    super("Rygcrawl");
  }

  public int compareTo(Backcrawl backcrawl) {
    if (this.swimmingTime.getTotalTime() > backcrawl.swimmingTime.getTotalTime()) {
      return -1;

    } else if (this.swimmingTime.getTotalTime() == backcrawl.swimmingTime.getTotalTime()) {
      return 0;
    } else {
      return 1;
    }
  }

}
