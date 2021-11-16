import java.util.ArrayList;
import java.util.List;

public class Kontingent { //Måske skift navn på klassen så den giver mere mening, da det faktisk kun er kassereren der skal bruge dette

    // Liste der gemmer "members" som ikke har betalt deres kontingent
    //List er et Interface som extender Collection interface
    private List<Member> unpaidMembers = new ArrayList<>();


    public Kontingent(List<Member> memberList) {
        super(memberList);
    }
}
