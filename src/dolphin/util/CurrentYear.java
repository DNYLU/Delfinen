package dolphin.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
// Dannie & David
public class CurrentYear {

  private LocalDate date;

    public void setToCurrentDate() {
      int year = LocalDate.now().getYear();
      int month = LocalDate.now().getMonthValue();
      int day = LocalDate.now().getDayOfMonth();

      this.date = LocalDate.of(year, month, day);
    }

    public void setDate(int year, int month, int day) {
      this.date = LocalDate.of(year, month, day);
    }

    public String toString() {
      return this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int getCurrentYear() {
      this.setToCurrentDate();
      return this.date.getYear();
    }
  }

