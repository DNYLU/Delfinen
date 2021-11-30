package dolphin.util;

public class SwimmingTime {
    int minutes;
    int seconds;
    int milliSeconds;

    public SwimmingTime() {

    }

    public SwimmingTime(int minutes, int seconds, int milliSeconds) {
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        this.setMilliSeconds(milliSeconds);
    }
    public String toFileString() {
        return this.minutes + "-" + this.seconds + "-" + this.milliSeconds;
    }

    public String toString() {
        return this.minutes + ":" + this.seconds + ":" + this.milliSeconds;
    }

    public double getTotalTime() {
        double totalTime; // totalTime = minutes & milliSeconds converted to seconds

        totalTime = minutes*60;
        totalTime += milliSeconds*0.001;

        return totalTime;
    }

    public void setMinutes(int minutes) {
        if (minutes > 0) {
            this.minutes = minutes;
        }
    }

    public void setSeconds(int seconds) {
        if (seconds > 0) {
            this.seconds = seconds;
        }
    }

    public void setMilliSeconds(int milliSeconds) {
        if (milliSeconds > 0) {
            this.milliSeconds = milliSeconds;
        }
    }
}
