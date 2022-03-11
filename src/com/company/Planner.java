package com.company;


import java.lang.invoke.SwitchPoint;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Planner {

    final private short[] numberOfDays = new short[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private short monthNumber;
    private short monthLength;
    private String[][] monthDays;

    public Planner() {
        this.monthNumber = 1;
        this.monthLength = numberOfDays[monthNumber - 1];
        this.monthDays = new String[31][];
        for (int i = 0; i < 31; i++) {
            this.monthDays[i] = new String[0];
        }
    }


    public Planner(int monthNumber) {
        if (monthNumber > 12)
            this.monthNumber = 12;
        else if (monthNumber < 1)
            this.monthNumber = 1;
        else
            this.monthNumber = (short) monthNumber;
        this.monthLength = numberOfDays[monthNumber - 1];
        this.monthDays = new String[this.monthLength][];
        for (int i = 0; i < this.monthLength; i++) {
            this.monthDays[i] = new String[0];
        }
    }


    public Planner(int monthNumber, String[][] monthDays) {
        this.monthDays = monthDays;
        this.monthNumber = (short) monthNumber;
        this.monthLength = numberOfDays[monthNumber - 1];
    }


    public String[] add(int date, String task) {
        if (date > this.monthLength || date < 1) {
            System.out.println("Invalid date!");
            return null;
        } else {
            String[] day = new String[this.monthDays[date - 1].length + 1];
            for (int i = 0; i < this.monthDays[date - 1].length; i++) {
                day[i] = this.monthDays[date - 1][i];
            }
            day[this.monthDays[date - 1].length] = task;
            this.monthDays[date - 1] = day;
            return day;
        }
    }


    public void next() {
        short prevMonthLength = this.monthLength;
        this.monthNumber++;
        if (this.monthNumber > 12)
            this.monthNumber = 1;
        this.monthLength = numberOfDays[monthNumber - 1];

        String[][] tempMonth = new String[this.monthLength][];

        if (this.monthLength > prevMonthLength) {
            for (int i = 0; i < prevMonthLength; i++) {
                tempMonth[i] = this.monthDays[i];
            }
            for (int i = prevMonthLength; i < this.monthLength; i++) {
                tempMonth[i] = new String[0];
            }
            this.monthDays = tempMonth;
        } else if (this.monthLength < prevMonthLength) {
            for (int i = 0; i < this.monthLength; i++) {
                tempMonth[i] = this.monthDays[i];
            }
            String[][] qqq = this.monthDays;
            qqq = this.monthDays;
            this.monthDays = tempMonth;
            for (int i = this.monthLength; i < prevMonthLength; i++) {
                for (int j = 0; j < qqq[i].length; j++) {
                    this.add(this.monthLength, qqq[i][j]);
                }
            }
        } else {
            for (int i = 0; i < prevMonthLength; i++) {
                tempMonth[i] = this.monthDays[i];
            }
            this.monthDays = tempMonth;
        }
    }


    public String[] info(int date) {
        if ((date > this.monthLength) || (date < 1)) {
            System.out.println("Invalid date!");
            return null;
        } else {
            if (this.monthDays[date - 1].length == 0) {
                System.out.println("There no tasks on " + date + "! ");
            } else {
                System.out.println("Task list on " + date + ": ");
                for (int i = 0; i < this.monthDays[date - 1].length; i++) {
                    System.out.println(this.monthDays[date - 1][i]);
                }
            }
            return this.monthDays[date - 1];
        }
    }

    public short getMonthNumber() {
        return this.monthNumber;
    }

    public short getMonthLength() {
        return this.monthLength;
    }

    public static void main(String[] args) {
        System.out.println("Jaba");
        String[][] testDays = new String[][]{
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
                {"A", "B", "C"},
        };
        Planner calendar = new Planner(2, testDays);
        calendar.info(1);
        calendar.add(1, "Buy water");
        calendar.info(1);
        calendar.next();
        calendar.add(31, "Buy weapon");
        calendar.add(31, "Cook food");
        calendar.info(31);
        calendar.next();
        calendar.info(30);
        calendar.info(29);
    }
}
