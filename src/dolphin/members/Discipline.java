package dolphin.members;

public abstract class Discipline {
    private double time;
    private String name;

    Discipline(String name) {
        this.name = name;
        this.time = 100.0;
    }

    public String getName() {
        return this.name;
    }

    public double getTime() {
        return this.time;
    }

    public void setTime(double time) {
        if (time < this.time) {
            this.time = time;
        }
    }
}
