package dolphin.util;

import java.time.LocalDateTime;

public class CurrentYear {

  private String formatter;
  private LocalDateTime CurrentYear;

    public CurrentYear(int time, String formatter) {
      this.formatter = formatter;
      int year = LocalDateTime.now().getYear();
      int month = LocalDateTime.now().getMonthValue();
      int day = LocalDateTime.now().getDayOfMonth();

      LocalDateTime dateTime = LocalDateTime.of(year, month, day,);


    public void setCurrentYear(LocalDateTime CurrentYear) {
      this.CurrentYear = CurrentYear;
    }

    public String toString() {
      return this.formatter.format(this.CurrentYear);
    }

    public LocalDateTime getCurrentYear() {
      return this.CurrentYear;
    }
  }
}
