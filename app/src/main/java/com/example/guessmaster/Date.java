package com.example.guessmaster;

/**
 *
 * @author Samantha Hawco 20167916
 */
    public class Date {
    private int day;
    private int month;
    private int year;

    /**
     * Constructor
     * @param day
     * @param month
     * @param year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Copy Constructor
     * @param toCopy, Date type object to be copied
     */
    public Date (Date toCopy){
        day = toCopy.day;
        month = toCopy.month;
        year = toCopy.year;
    }

    /**
     * Constructor
     * @param sDate, string to be converted to Date type object
     */
    public Date (String sDate){
        this.day = Integer.parseInt(sDate.substring(0, 2));
        this.month = Integer.parseInt(sDate.substring(3, 5));
        this.year = Integer.parseInt(sDate.substring(6,10));
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

    /**
     * Checks if two Date type objects are equal
     * @param date
     * @return boolean true if equal, false if not equal
     */
    public boolean equals (Date date){
        if (day == date.day && month == date.month && year == date.year){
            return true;
        }
        return false;
    }

    public String toString (){
        return day + " " + month + ", "+ year;
    }




}