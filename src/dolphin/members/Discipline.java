package dolphin.members;

import dolphin.util.SwimmingTime;

public abstract class Discipline {
    private SwimmingTime time;
    private String name;

    Discipline(String name) {
        this.name = name;
    }

    public void setTime(SwimmingTime time) {
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(SwimmingTime time) {
        if (time != null) {
            if (time < this.time) {
                this.time = time;
            }
        }
    }
}
