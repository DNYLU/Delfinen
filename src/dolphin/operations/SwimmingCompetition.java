package dolphin.operations;

import dolphin.file.FileApi;
import dolphin.members.CompetitiveMember;
import dolphin.members.Discipline;
import dolphin.members.Disciplines;
import dolphin.util.Date;
import dolphin.util.MSG;
import dolphin.util.SwimmingTime;
import dolphin.util.UserInput;
import dolphin.util.CompetitionResult;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * @author Lu
 * @author David
 */

public class SwimmingCompetition {
    MSG msg = new MSG();
    SwimmingTime swimmingTime = new SwimmingTime();
    FileApi fileApi = new FileApi();
    UserInput userInput = new UserInput();
    FindCompetitiveMember findCompetitiveMember = new FindCompetitiveMember();
    CompetitionResult competitionResult = new CompetitionResult();
    Date date = new Date();

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
            competitionResult.setMemberID(member.getId());

            ArrayList<Discipline> disciplines = member.getDisciplines();
            Discipline discipline;

            System.out.println("Vælg disciplin: ");
            System.out.println(disciplines);

            int choice = userInput.getIntInput();

            if (choice >= 0 && choice < disciplines.size()) {
                String disciplineName = disciplines.get(choice).getName();

                if (disciplineName.equals(Disciplines.BUTTERFLY.getName())) {
                    discipline = new Discipline(Disciplines.BUTTERFLY.getName());
                } else if (disciplineName.equals(Disciplines.CRAWL.getName())) {
                    discipline = new  Discipline(Disciplines.CRAWL.getName());
                } else if (disciplineName.equals(Disciplines.BACK_CRAWL.getName())) {
                    discipline = new Discipline(Disciplines.BACK_CRAWL.getName());
                } else {
                    discipline = new Discipline(Disciplines.BREAST_STROKE.getName());
                }
            } else {
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
            this.competitionResult.setDiscipline(discipline);

            checkChoice = false;

            fileApi.insertCompetitionResult(this.competitionResult, this.competitionResult.getMemberID());
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

