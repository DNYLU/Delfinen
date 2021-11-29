package dolphin.members;

import dolphin.util.SwimmingTime;

public abstract class Discipline {
    private SwimmingTime time;
    private String name;

    Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getFormattedTime() {
        return this.time.toString();
    }

    public void setTime(SwimmingTime time) {
        if (time != null) {
            if (time.getTotalTime() < this.time.getTotalTime()) {
                this.time = time;
            }
        }
    }
}
