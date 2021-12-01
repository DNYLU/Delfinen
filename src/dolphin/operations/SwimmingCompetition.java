package dolphin.operations;

import dolphin.file.FileApi;
import dolphin.members.CompetitiveMember;
import dolphin.members.Member;
import dolphin.members.disciplines.Discipline;
import dolphin.util.Date;
import dolphin.util.MSG;
import dolphin.util.SwimmingTime;
import dolphin.util.UserInput;
import dolphin.operations.FindCompetitiveMember;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class SwimmingCompetition {
    MSG msg = new MSG();
    Date date = new Date();
    SwimmingTime swimmingTime = new SwimmingTime();
    FileApi fileApi = new FileApi();
    UserInput userInput = new UserInput();
    FindCompetitiveMember findCompetitiveMember = new FindCompetitiveMember();

  /*
    Denne klasse skal kunne registrerer svømmerne til stævner og angive placering og tid.
    Derudover skal der vises top 5 svømmer for hver disciplin.
   */

    public void run() {
        swimmingCompetition();
    }

    private void swimmingCompetition() {
        System.out.println("-----STÆVNE-----");
        System.out.println("Indtast stævne: ");
        String competition = userInput.getStringInput();

        lapTime();
    }

    private void lapTime() {
        boolean checkChoice = true;
        while (checkChoice) {
            // Finder member via ID

            // Find ID på medlem
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
