public class Member {

  private String memberName;
    private int memberYearOfBirth;
    //Personal info


    // Jeg har lige lavet et par ændringer, så det måske passer bedre til det jeg skal lave -Lu
    // Swimming info
    private String activityForm;
    private String swimmerTitle; // Ved ikke hvad det skal hedde (Junior eller senior)
    private String swimmerType;

    // Payment info
    private double paymentAmount;
    private boolean paidSubscription;

    private String discipline;
    private double bestTime; // Find et bedre ord for det

  //2021 - Fjernes senere når vi bliver klogere
  private int currentYear = 2021;

  public Member(String memberName, int memberYearOfBirth, String activityForm,
                String swimmerTitle, String swimmerType, String discipline, double bestTime) {
    this.memberName = memberName;
    this.memberYearOfBirth = memberYearOfBirth;
    this.activityForm = activityForm;
    this.swimmerTitle = swimmerTitle;

    // Swimmer i forhold til alderen
    if (currentYear - this.memberYearOfBirth >= 18) {
      this.swimmerTitle = "senior";
    } else {
      this.swimmerTitle = "junior";
    }

    // Betaling i forhold til "Title" og alder
    if (this.activityForm.equals("active")) {
      if (currentYear - this.memberYearOfBirth < 18) { // Hvis man er under 18 år, koster det 1000 kr.
        this.paymentAmount = 1000;
      } else if (currentYear - this.memberYearOfBirth >= 60) { // Hvis man er over 60 år, koster det 500 kr.
        this.paymentAmount = 500;
      } else {
        this.paymentAmount = 1600; // Hvis man er mellem 18 og 60 år gammel, koster det 1600 kr.
      }
    }

  }



  public void setMemberName() {
    this.memberName = memberName;
  }
  public String getMemberName() {
    return memberName;
  }

  public void setMemberYearOfBirth() {
    this.memberYearOfBirth = memberYearOfBirth;
  }
  public int getMemberYearOfBirth() {
    return memberYearOfBirth;
  }


}
