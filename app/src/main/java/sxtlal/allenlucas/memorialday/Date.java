package sxtlal.allenlucas.memorialday;

/**
 * Created by AllenLucas on 2016/5/5.
 */
public class Date extends java.util.Date {
    public int year;
    public int month;
    public int day;

    public Date() {

    }

    public Date(long l) {
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
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

    @Override
    public String toString() {
        return year +
                "年" + (month + 1) +
                "月" + day +
                "日";
    }
}
