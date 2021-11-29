package dolphin.util;

// Lu
public class MSG { //Klasse til evt. fejlbeskeder

    public void errorMessageInt() {
        System.out.println("Indtastningen er ikke et tal. Prøv igen.");
    }

    public void errorMessageString() {
        System.out.println("Indtastningen er forkert. Prøv igen.");
    }

    public void errorMessageDate() {
        System.out.println("Ugyldig dato! Prøv igen.");
    }
}
