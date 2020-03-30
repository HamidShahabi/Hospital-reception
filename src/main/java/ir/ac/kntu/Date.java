package ir.ac.kntu;

import java.time.*;
import java.util.*;

public class Date {
    private int year;
    private Month month;
    private int day;
    private LocalDate currentDate = LocalDate.now();

    public Date(int year, Month month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date() {

        this.year = currentDate.getYear();
        this.day = currentDate.getDayOfMonth();
        this.month = currentDate.getMonth();

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayOfYear() {
        return currentDate.getDayOfYear();
    }


}
