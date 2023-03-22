package appointment;

import java.util.Date;

public class MDate {

    int day;
    int month;
    int year;
    String timeZone;
    int hour;
    int minute;
    

    public MDate(Date m) {
    }

    public MDate(int day, int month, int year, String timeZone, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.timeZone = timeZone;
        this.hour = hour;
        this.minute = minute;

    }

    public MDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    

    public boolean dateArrange(int datee) {
        return this.day==datee;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

}
