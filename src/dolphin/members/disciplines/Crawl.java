package dolphin.members.disciplines;

public class Crawl extends Discipline {

  public Crawl() {
    super("Crawl");
  }

  public int compareTo(Crawl crawl) {
    if (this.swimmingTime.getTotalTime() > crawl.swimmingTime.getTotalTime()) {
      return -1;

    } else if (this.swimmingTime.getTotalTime() == crawl.swimmingTime.getTotalTime()) {
      return 0;
    } else {
      return 1;
    }
  }

}
