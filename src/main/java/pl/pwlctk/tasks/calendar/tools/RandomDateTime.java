package pl.pwlctk.tasks.calendar.tools;

import java.time.LocalDateTime;

public class RandomDateTime {

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDateTime createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        int hour = createRandomIntBetween(0, 23);
        int minute = createRandomIntBetween(0, 59);
        return LocalDateTime.of(year, month, day, hour, minute);
    }
}
