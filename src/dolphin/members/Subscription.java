package dolphin.members;

import dolphin.file.FileApi;
import dolphin.operations.AllMembers;

import java.util.ArrayList;

/**
 * @author David
 * @author Danny Lu
 */
public class Subscription {
    private final int seniorPrice = 1600;
    private final int juniorPrice = 1000;
    private final int passivePrice = 500;
    private final double seniorDiscountPrice = seniorPrice - (seniorPrice * 0.25);

    private double paymentAmount;
    private double debtAmount;

    public Subscription() {
    }

    public Subscription(AgeGroup ageGroup, int age, SubscriptionType subscriptionType) {
        this.calculatePaymentAmount(subscriptionType, ageGroup, age);
    }

    private void calculatePaymentAmount(SubscriptionType subscriptionType, AgeGroup ageGroup, int age) {
        if (subscriptionType == SubscriptionType.ACTIVE) {
            if (ageGroup == AgeGroup.JUNIOR) { // Hvis man er under 18 år, koster det 1000 kr.
                this.paymentAmount = juniorPrice; // 1000 kr.
            } else { // Hvis man er over 60 år, koster det 1200 kr. da der er 25% rabat på seniorprisen (1600 kr.)
                if (age >= 60) {
                    this.paymentAmount = this.seniorDiscountPrice;
                } else {
                    this.paymentAmount = this.seniorPrice; // 25% rabat = 400
                }
            }
        } else { // Hvis man har et passivt medlemskab
            this.paymentAmount = passivePrice; // 500 kr.
        }
    }

    public void setDataFromFileLine(SubscriptionType subscriptionType, AgeGroup ageGroup, int age, String line) {
        debtAmount = Double.parseDouble(line);
        this.calculatePaymentAmount(subscriptionType, ageGroup, age);
    }

    public String toFileString() {
        return String.valueOf(this.debtAmount);
    }

    public double getPaymentAmount() {
        return this.paymentAmount;
    }

    public double getDebtAmount() {
        return this.debtAmount;
    }
}
