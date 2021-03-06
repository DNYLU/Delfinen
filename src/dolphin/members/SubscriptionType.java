package dolphin.members;
/**
 * @author Lu
 * @author David
 */
public enum SubscriptionType {
  ACTIVE("Aktiv"),
  PASSIVE("Passiv");

  private final String name;

  SubscriptionType(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
