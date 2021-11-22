package dolphin.operations;
import dolphin.util.UserInput;
import java.util.ArrayList;

public class Registration {
  UserInput userInput = new UserInput();
  /*
    Denne klasse skal kunne registrerer svømmerne til stævner og angive placering og tid.
    Derudover skal der vises top 5 svømmer for hver disciplin.
   */


  private void timeRegistration() {
    double lapTime;
    System.out.println("Indtast svømmerens tid: ");
    lapTime = userInput.getDoubleInput();
    System.out.println(lapTime);
  }


}