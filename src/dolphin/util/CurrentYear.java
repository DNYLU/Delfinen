package dolphin.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
// Dannie
public class CurrentYear {

  private LocalDate date;

    public void setDate() {
      int year = LocalDate.now().getYear();
      int month = LocalDate.now().getMonthValue();
      int day = LocalDate.now().getDayOfMonth();

      this.date = LocalDate.of(year, month, day);
    }

    public String toString() {
      this.setDate();
      return this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getCurrentYear() {
      this.setDate();
      return this.date;
    }
  }

