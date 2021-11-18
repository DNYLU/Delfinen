package dolphin.members;

public enum Discipline {
    BUTTERFLY("Butterfly"),
    CRAWL("Crawl"),
    RYGCRAWL("Rygcrawl"),
    BRYSTSVØMNING("Brystsvømning");

    private final String name;

    Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
