package dolphin.members;

public enum Disciplines {
    BUTTERFLY("Butterfly"),
    BREAST_STROKE ("Brystsvømning"),
    CRAWL ("Crawl"),
    BACK_CRAWL ("Rygsvømning");

    private String name;

    Disciplines(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
