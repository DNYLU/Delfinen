package dolphin.members;

import dolphin.util.Date;
import dolphin.util.SwimmingTime;

/**
 * @author David
 * @author Lu
 * @author Umaid
 */

public class Discipline {
    protected Date date;
    protected SwimmingTime swimmingTime;
    protected String name;

    public Discipline() {
    }

    public Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    public SwimmingTime getSwimmingTime() {
        return swimmingTime;
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

    public String toFileString() {
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

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return this.name;
    }
}
