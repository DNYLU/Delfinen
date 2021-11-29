package dolphin.members;

public abstract class Discipline {
    private double time;
    private String name;

    Discipline(String name, double time) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getTime() {
        return this.time;
    }
}
