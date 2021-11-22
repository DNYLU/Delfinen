package dolphin.members;

public enum SwimmerType {
    CASUAL("Motionist"),
    COMPETITIVE("Konkurrencesvømmer");

    private final String name;

    SwimmerType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
