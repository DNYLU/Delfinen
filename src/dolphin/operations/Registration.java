package dolphin.operations;

import dolphin.util.UserInput;
import dolphin.members.Discipline;
import dolphin.util.MSG;
import dolphin.util.CurrentYear;
import dolphin.util.SwimmingTime;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Registration {
    MSG msg = new MSG();
    CurrentYear currentYear = new CurrentYear();


    UserInput userInput = new UserInput();
  /*
    Denne klasse skal kunne registrerer svømmerne til stævner og angive placering og tid.
    Derudover skal der vises top 5 svømmer for hver disciplin.
   */


    private void timeRegistration() {
        boolean checkChoice = true;
        while (checkChoice) {
            System.out.println("Indtast svømmerens tid: ");

        }
        double lapTime;
        System.out.println("Indtast svømmerens tid: ");
        lapTime = userInput.getDoubleInput();
        System.out.println(lapTime);
    }

    public void date() {
        boolean checkChoice = true;
        while (checkChoice) {
            System.out.println("Indtast dag: "); // dd/mm/yyyy
            int practiceDay = userInput.getIntInput();
            System.out.println("Indtast måned: ");
            int practiceMonth = userInput.getIntInput();
            System.out.println("Indtast år: ");
            int practiceYear = userInput.getIntInput();
            try {
                currentYear.setDate(practiceDay, practiceMonth, practiceYear);
                System.out.println("Dato: " + currentYear);
                checkChoice = false;
            } catch (DateTimeParseException dateTimeParseException) {
                msg.errorMessageDate();
                checkChoice = true; //
            }

        }
    }


}