package dolphin.util;

public class SwimmingTime {
    int minutes;
    int seconds;
    int milliSeconds;

    public String toString() {
        return this.minutes + ":" + this.seconds + ":" + this.milliSeconds;
    }

    public double getTotalTime() {
        double totalTime; // totalTime = minutes & milliSeconds converted to seconds

        totalTime = minutes*60;
        totalTime += milliSeconds*0.001;

        return totalTime;
    }
}
