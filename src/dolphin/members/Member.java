package dolphin.members;

import java.util.ArrayList;

// Lu og Dannie
public class Member {

    //Personal info
    private final int memberYearOfBirth;
    private final String memberName;
    private final int memberAge;

    // Jeg har lige lavet et par ændringer, så det måske passer bedre til det jeg skal lave -Lu

    // Info om svømmeren
    private SubscriptionType subscriptionType; // Aktiv eller passiv
    private AgeGroup ageGroup; // Junior eller Senior
    private String swimmerType; // Motionist eller konkurrencesvømmer
    private ArrayList<Discipline> disciplines;

    // Payment info
    private Subscription subscription;
    private boolean paidSubscription; // Ændres senere

    private String discipline;
    private double bestTime; // Find et bedre ord for det

    public Member(String memberName, int memberYearOfBirth, SubscriptionType subscriptionType, String swimmerType, String discipline, double bestTime) {
        this.memberName = memberName;
        this.memberYearOfBirth = memberYearOfBirth;
        this.subscriptionType = subscriptionType;
        this.swimmerType = swimmerType;
        this.discipline = discipline;
        this.bestTime = bestTime;

        //2021 - Fjernes senere når vi bliver klogere
        int currentYear = 2021;
        this.memberAge = currentYear - this.memberYearOfBirth;

        // Swimmer i forhold til alderen
        if (this.memberAge >= 18) {
            this.ageGroup = AgeGroup.SENIOR;
        } else {
            this.ageGroup = AgeGroup.JUNIOR;
        }

        this.subscription = new Subscription(this.ageGroup, this.memberAge, this.subscriptionType);

        this.paidSubscription = false; // Hvis subscription ikke er aktivt
        this.discipline = discipline;
        this.bestTime = bestTime;

    }

    public void paidSubscription() {
        this.paidSubscription = true;
    }

    // Getters
    public String getMemberName() {
        return memberName;
    }

    public int getMemberYearOfBirth() {
        return memberYearOfBirth;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public String getSwimmerType() {
        return swimmerType;
    }

    public double getPaymentAmount() {
        return this.subscription.getPaymentAmount();
    }
}
