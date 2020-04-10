package ir.ac.kntu;

import java.time.*;
import java.util.*;

public class Date {
    private int year;
    private int month;
    private int day;
    private LocalDate currentDate = LocalDate.now();

    public Date(int year, int month, int day) {
        this.year = 1399;
        this.month = month;
        this.day = day;
    }

    public Date() {
        this.year = 1399;
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfYear();
        int difference = 0;
        if (currentDate.getDayOfYear() > 79) {
            day -= 79;
            if (day <= 186) {
                this.month = (day / 31);
                this.day = (day % 31 == 0) ? 31 : day % 31;
                this.month = (this.day == 31) ? this.month : this.month + 1;
            } else {
                day = day - 186;
                this.month = (day / 30) + 6;
                this.day = (day % 30 == 0) ? 30 : day % 30;
                this.month = (this.day == 30) ? this.month : this.month + 1;
            }
        }
        if (currentDate.getDayOfYear() < 79) {

            difference = 11;
            day += difference;
            if (day % 30 == 0) {
                this.day = (day / 30 + 9);
                this.day = 30;
            } else {
                this.month = day / 30 + 10;
                this.day = day % 30;
            }
        }

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayOfYear() {
        int dayCounter = 0;
        if (month <= 6) {
            dayCounter = (month - 1) * 31 + day;
        } else {
            month -= 6;
            dayCounter = 186 + (month - 1) * 30 + day;
        }
        return dayCounter;
    }

    @Override
    public String toString() {
        return
                  day +
                " - " + month +
                " - " + year
                ;
    }
}
