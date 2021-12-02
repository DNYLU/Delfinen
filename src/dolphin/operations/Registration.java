package dolphin.operations;

import dolphin.members.Discipline;
import dolphin.util.UserInput;
import dolphin.util.MSG;
import dolphin.util.Date;
import dolphin.util.SwimmingTime;
import dolphin.file.FileApi;
import dolphin.members.CompetitiveMember;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * @author Lu
 * @author David
 */

public class Registration {
    MSG msg = new MSG();
    Date date = new Date();
    SwimmingTime swimmingTime = new SwimmingTime();
    FileApi fileApi = new FileApi();
    FindCompetitiveMember findCompetitiveMember = new FindCompetitiveMember();
    UserInput userInput = new UserInput();
  /*
    Denne klasse skal kunne registrerer svømmerne til træning og angive placering og tid.
    Derudover skal der vises top 5 svømmer for hver disciplin.
   */

    public void run() {
        lapTime();
    }

    private void lapTime() {
        boolean checkChoice = true;
        while (checkChoice) {
            // Finder member via ID
            System.out.println("-----SVØMMETID-----");

            CompetitiveMember member = findCompetitiveMember.findID();

            ArrayList<Discipline> disciplines = member.getDisciplines();
            Discipline discipline;

            System.out.println("Vælg disciplin: ");
            System.out.println(disciplines);
            int choice = userInput.getIntInput();
            if (choice >= 0 && choice < disciplines.size()) {
                discipline = disciplines.get(choice);

            }   else {
                System.out.println("Kunne ikke finde disciplin. (Index starter på 0).");
                return;
            }

            System.out.println("Indtast minutter: ");
            int minutes = userInput.getIntInput();
            System.out.println("Indtast sekunder: ");
            int seconds = userInput.getIntInput();
            System.out.println("Indtast millisekunder: ");
            int milliSeconds = userInput.getIntInput();

            SwimmingTime swimTime = new SwimmingTime(minutes, seconds, milliSeconds);
            date();

            checkChoice = false;
            discipline.setDate(this.date);
            discipline.setSwimmingTime(swimTime);

            fileApi.editCompetitiveMember((CompetitiveMember) member);
            checkChoice = false;


        }
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
                this.date.setDate(practiceYear, practiceMonth, practiceDay);
                System.out.println("Dato: " + this.date);
                checkChoice = false;
            } catch (DateTimeParseException dateTimeParseException) {
                msg.errorMessageDate();
                checkChoice = true; //
            }
        }
    }
}