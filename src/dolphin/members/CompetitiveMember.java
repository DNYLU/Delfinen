package dolphin.members;

import java.util.ArrayList;
import java.util.HashSet;

public class CompetitiveMember extends Member {

    private ArrayList<Discipline> disciplines;

    public CompetitiveMember(String memberName, int memberYearOfBirth, SubscriptionType subscriptionType, String swimmerType, ArrayList<Discipline> discipline) {
        super(memberName, memberYearOfBirth, subscriptionType, swimmerType);
        this.disciplines = discipline;

    }

}
