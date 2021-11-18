package dolphin.members;

public class Subscription {
    private final int seniorPrice = 1600;
    private final int juniorPrice = 1000;
    private final int passivePrice = 500;
    private final double seniorDiscountPrice = seniorPrice * 0.25;

    private double paymentAmount;

    public Subscription(AgeGroup ageGroup, int age, SubscriptionType subscriptionType) {
        if (subscriptionType == SubscriptionType.ACTIVE) {
            if (ageGroup == AgeGroup.JUNIOR) { // Hvis man er under 18 år, koster det 1000 kr.
                this.paymentAmount = juniorPrice; // 1000 kr.
            } else { // Hvis man er over 60 år, koster det 1200 kr. da der er 25% rabat på seniorprisen (1600 kr.)
                if (age >= 65) {
                    this.paymentAmount = this.seniorDiscountPrice;
                } else {
                    this.paymentAmount = this.seniorPrice; // 25% rabat = 400
                }
            }

        } else { // Hvis man har et passivt medlemskab
            this.paymentAmount = passivePrice; // 500 kr.
        }
    }

    public double getPaymentAmount() {
        return this.paymentAmount;
    }
}
