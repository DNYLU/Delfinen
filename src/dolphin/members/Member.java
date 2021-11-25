package dolphin.members;

import dolphin.util.CurrentYear;

import java.util.ArrayList;

// Lu og Dannie
public class Member {
    private int id;
    //Personal info
    private String memberName;
    private int memberYearOfBirth;
    private int memberAge;

    // Jeg har lige lavet et par ændringer, så det måske passer bedre til det jeg skal lave -Lu

    // Info om svømmeren
    private SubscriptionType subscriptionType; // Aktiv eller passiv
    private AgeGroup ageGroup; // Junior eller Senior
    private String swimmerType; // Motionist eller konkurrencesvømmer

    // Payment info
    private Subscription subscription;

    public Member() {

    }

    public Member(String memberName, int memberYearOfBirth, SubscriptionType subscriptionType, String swimmerType, int id) {
        this.memberName = memberName;
        this.memberYearOfBirth = memberYearOfBirth;
        this.subscriptionType = subscriptionType;
        this.swimmerType = swimmerType;
        this.id = id;

        //Henter det nuværende år
        int currentYear = new CurrentYear().getCurrentYear();
        this.memberAge = currentYear - this.memberYearOfBirth;

        // Swimmer i forhold til alderen
        if (this.memberAge >= 18) {
            this.ageGroup = AgeGroup.SENIOR;
        } else {
            this.ageGroup = AgeGroup.JUNIOR;
        }

        this.subscription = new Subscription(this.ageGroup, this.memberAge, this.subscriptionType);

    }

    public void setDataFromFileLine(String line) {
        String[] string = line.split(",");

        int yearOfBirth = Integer.parseInt(string[1]);
        AgeGroup ageGroup = AgeGroup.valueOf(string[2]);
        SubscriptionType subscriptionType = SubscriptionType.valueOf(string[3]);

        this.memberName = string[0];
        this.memberYearOfBirth = yearOfBirth;
        this.memberAge = this.memberYearOfBirth - new CurrentYear().getCurrentYear();
        this.ageGroup = ageGroup;
        this.subscriptionType = subscriptionType;
        this.swimmerType = string[4];

        Subscription subscription = new Subscription();
        subscription.setDataFromFileLine(subscriptionType, ageGroup, this.memberAge, string[5]);
        this.subscription = subscription;
    }

    public String toFileString() {

        return this.memberName + "," +
                this.memberYearOfBirth + "," +
                this.ageGroup + "," +
                this.subscriptionType + "," +
                this.swimmerType + "," +
                this.subscription.toFileString();
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

    public double getDebtAmount() {
        return this.subscription.getDebtAmount();
    }
    public int getId() { return this.id; }

}
