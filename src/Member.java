// Lu og Dannie
public class Member {

    enum SubscriptionType {
        ACTIVE("Aktiv"),
        PASSIVE("Passiv");

        SubscriptionType(String type) {
        }
    }

    enum AgeGroup {
        JUNIOR("Junior"),
        SENIOR("Senior");

        AgeGroup(String ageGroup) {
        }
    }

    //Pris variabler
    private int seniorPrice = 1600;
    private int juniorPrice = 1000;
    private int passivePrice = 500;
    private double seniorDiscountPrice = seniorPrice * 0.25;

    //Personal info
    private int memberYearOfBirth;
    private String memberName;

    // Jeg har lige lavet et par ændringer, så det måske passer bedre til det jeg skal lave -Lu

    // Info om svømmeren
    private SubscriptionType subscriptionType; // Aktiv eller passiv
    private AgeGroup ageGroup; // Junior eller Senior
    private String swimmerType; // Motionist eller konkurrencesvømmer

    // Payment info
    private double paymentAmount;
    private boolean paidSubscription; // Ændres senere

    private String discipline;
    private double bestTime; // Find et bedre ord for det

    //2021 - Fjernes senere når vi bliver klogere
    private int currentYear = 2021;

    public Member(String memberName, int memberYearOfBirth, SubscriptionType subscriptionType, String swimmerType, String discipline, double bestTime) {
        this.memberName = memberName;
        this.memberYearOfBirth = memberYearOfBirth;
        this.subscriptionType = subscriptionType;
        this.swimmerType = swimmerType;
        this.discipline = discipline;
        this.bestTime = bestTime;


        // Swimmer i forhold til alderen
        if (currentYear - this.memberYearOfBirth >= 18) {
            this.ageGroup = AgeGroup.SENIOR;
        } else {
            this.ageGroup = AgeGroup.JUNIOR;
        }

        // Betaling i forhold til "Title" og alder
        if (this.subscriptionType == SubscriptionType.ACTIVE) {
            if (currentYear - this.memberYearOfBirth < 18) { // Hvis man er under 18 år, koster det 1000 kr.
                this.paymentAmount = juniorPrice; // 1000 kr.
            } else if (currentYear - this.memberYearOfBirth >= 60) { // Hvis man er over 60 år, koster det 1200 kr. da der er 25% rabat på seniorprisen (1600 kr.)
                this.paymentAmount = seniorDiscountPrice; // 25% rabat = 400
            } else {
                this.paymentAmount = seniorPrice; // Hvis man er mellem 18 og 60 år gammel, koster det 1600 kr.
            }
        } else { // Hvis man har et passivt medlemskab
            this.paymentAmount = passivePrice; // 500 kr.
        }
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
        return paymentAmount;
    }
}
