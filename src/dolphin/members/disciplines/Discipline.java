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
        if (swimmingTime != null) {
            if (swimmingTime.getTotalTime() < this.swimmingTime.getTotalTime()) {
                this.swimmingTime = swimmingTime;
            }
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String toString() {
        return this.name;
    }
}
