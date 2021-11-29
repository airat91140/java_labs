package lab5;

import jdk.jshell.execution.LoaderDelegate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void modelExceptions() {
        try {
            int[] array = {1, 2, 3};
            array[3] = 4;
        }catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        try {
            FileInputStream inp = new FileInputStream("non-existing_file.txt");
        }catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        }
        try {
            String a = null;
            a.length();
        }catch (NullPointerException ex) {
            System.out.println("NullPointerException");}
        try {
            String hostname = "http://locaihost";
            URL url = new URL(hostname);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.getResponseCode();

        }catch (IOException ex) {
            System.out.println("IOException");
        }
        try {
            Integer a = 3;
            Object obj = a;
            String b = (String) obj;
        }catch (ClassCastException ex) {
            System.out.println("ClassCastException");
        }
        try {
            int a = 5 / 0;
        }catch (ArithmeticException ex) {
            System.out.println("ArithmeticException");
        }
    }

    public static void outOfMemory() {
        int []array = new int[1000000000];
    }

    public static void stackOverFlow() {
        stackOverFlow();
    }

    public static void datesCalculating() {
        LocalDate now = LocalDate.now();

        LocalDate lincolnBirth = LocalDate.of(1809, Month.FEBRUARY, 12);
        LocalDate lincolnDeath = LocalDate.of(1855, Month.APRIL, 15);
        System.out.println("He died when he was " + ChronoUnit.YEARS.between(lincolnBirth, lincolnDeath));
        System.out.println("He lived " + ChronoUnit.DAYS.between(lincolnBirth, lincolnDeath) + " days");
        System.out.println();

        LocalDate cumberbatchBirth = LocalDate.of(1976, Month.JULY, 19);
        System.out.println("Cumberbatch born in " + (cumberbatchBirth.isLeapYear() ? "leap year" : "non-leap year"));
        System.out.println("He is " + ChronoUnit.DECADES.between(cumberbatchBirth, now) + " decades");
        System.out.println("It was " + cumberbatchBirth.plusYears(21).getDayOfWeek());
        System.out.println();

        LocalTime bostonDep = LocalTime.of(13, 45);
        LocalTime newYorkArr = LocalTime.of(19, 25);
        System.out.println("Ride longs " + ChronoUnit.MINUTES.between(bostonDep, newYorkArr) + " minutes");
        System.out.println("Arrival time: " + newYorkArr.plusHours(1).plusMinutes(19));
        System.out.println();

        LocalDateTime boston = LocalDateTime.of(2021, Month.MARCH, 24, 21, 15);
        System.out.println("Plane arrives at " + boston.plusHours(4).plusMinutes(15));
        System.out.println("Plane with delay arrives at " + boston.plusHours(4).plusMinutes(27).plusHours(4).plusMinutes(15));
        System.out.println();

        LocalDate september = LocalDate.of(2021, Month.SEPTEMBER, 1);
        LocalDate semesterStart = september
                .with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY))
                .with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("First day of semester is " + semesterStart);
        LocalDate semesterEnd = LocalDate.of(2022, Month.JUNE, 25);
        long weeks = ChronoUnit.WEEKS.between(semesterStart, semesterEnd);
        weeks -= 4; //vacations
        LocalDate lastWeekStart = semesterEnd.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
        long days = ChronoUnit.DAYS.between(lastWeekStart, semesterEnd);
        if (days == 7)
            days -= 2;
        if (days == 6)
            days -= 1;
        System.out.println("There are " + (weeks * 5 + days) + " days in school");
        System.out.println();

        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.of(13, 30));
        System.out.println("Week's meeting is at " + today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY)));
        System.out.println();
    }

    public static void flights() {
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");

        System.out.println("Flight 123");
        LocalDateTime localStart123 = LocalDateTime.of(2014, Month.JUNE, 13, 22, 30);
        ZonedDateTime start123 = ZonedDateTime.of(localStart123, SFO);
        System.out.println(start123.withZoneSameInstant(BOS));
        System.out.println(start123.plusHours(5).plusMinutes(30).withZoneSameInstant(BOS));
        System.out.println(start123.plusHours(5).plusMinutes(30));
        System.out.println();

        System.out.println("Flight 456");
        LocalDateTime localStart456 = LocalDateTime.of(2014, Month.JUNE, 28, 22, 30);
        ZonedDateTime start456 = ZonedDateTime.of(localStart456, SFO);
        System.out.println(start456.plusHours(22).withZoneSameInstant(BLR)
                .isBefore(ZonedDateTime.of(2014, 6, 29, 9, 0, 0, 0, BLR)));
        System.out.println();

        System.out.println("Flight 123");
        LocalDateTime localStart = LocalDateTime.of(2014, Month.NOVEMBER, 1, 22, 30);
        ZonedDateTime start = ZonedDateTime.of(localStart, SFO);
        System.out.println(start123.withZoneSameInstant(BOS).plusHours(5).plusMinutes(30));
        System.out.println();
    }

    public static void main(String[] args) {
        modelExceptions();
        datesCalculating();
        flights();
    }
}
