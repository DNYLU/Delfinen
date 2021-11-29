package dolphin.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// Dannie
public class CurrentYear {

  private LocalDate date;

    public void setToCurrentDate() {
      int year = LocalDate.now().getYear();
      int month = LocalDate.now().getMonthValue();
      int day = LocalDate.now().getDayOfMonth();

      this.date = LocalDate.of(year, month, day);
    }

    public void setDate(String year, String month, String day) {
      int intYear = Integer.parseInt(year);
      int intMonth = Integer.parseInt(month);
      int intDay = Integer.parseInt(day);

      this.date = LocalDate.of(intYear, intMonth, intDay);
    }

    public String toString() {
      return this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int getCurrentYear() {
      this.setToCurrentDate();
      return this.date.getYear();
    }
  }

