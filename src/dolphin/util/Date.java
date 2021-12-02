package dolphin.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * @author David
 * @author Dannie
 */
public class Date {

  private LocalDate date;

    public void setToCurrentDate() {
      int year = LocalDate.now().getYear();
      int month = LocalDate.now().getMonthValue();
      int day = LocalDate.now().getDayOfMonth();

      this.date = LocalDate.of(year, month, day);
    }
    public String toFileString() {
      if (this.date == null) {
        return "";
      }
      return this.date.getYear() + "-" + this.date.getMonthValue() + "-" + this.date.getDayOfMonth();
    }

    public void setDataFromFileLine(String line) {
      String[] data = line.split("-");
      if (data.length < 2) {
        return;
      }
      int year = Integer.parseInt(data[4]);
      int month = Integer.parseInt(data[5]);
      int day = Integer.parseInt(data[6]);

      this.setDate(year, month, day);
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

