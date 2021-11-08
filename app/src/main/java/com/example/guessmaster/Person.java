package com.example.guessmaster;

/**
 *
 * @author Samantha Hawco
 */
public abstract class Person {
    private String name;
    private Date birthday;
    private double difficulty;

    public Person (String name, Date birthday, double difficulty){
        this.name = name;
        this.birthday = new Date(birthday);
        this.difficulty = difficulty;
    }

    public Person (String name, int day, int month, int year, double difficulty){
        this.name = name;
        this.birthday = new Date(day, month, year);
        this.difficulty = difficulty;
    }

    /**
     * Copy constructor
     * @param person of Person type object to be copied
     */
    public Person (Person person){
        this.name = person.name;
        this.birthday = new Date(person.birthday);
        this.difficulty = person.difficulty;
    }

    /**
     * Returns points awarded for correct guess based on difficulty
     * @return int
     */
    public int getAwardedPointNumber (){
        return (int)(difficulty*100);
    }

    public abstract String personType (); //reutrns string that indicates person type
    public abstract Person clone(); //clones object

    /**
     * Determines relationship between birthday and guessed date
     * @param guess, Date guessed by user
     * @return string providing guidance
     */
    public String dateCompare(Date guess) {//compare date with person and return string
        int yearDiff = guess.getYear() - birthday.getYear();
        int monthDiff = guess.getMonth() - birthday.getMonth();
        int dayDiff = guess.getDay() - birthday.getDay();

        //check year, the highest precedence. If they are the same, month will be checked.
        if (yearDiff > 0) {
            return "Incorrect. Try a earlier year.";
        } else if (yearDiff < 0) {
            return "Incorrect. Try a later year.";
        }

        //check month, which is less important than year. If they are the same, day will be checked.
        if (monthDiff > 0) {
            return "Inncorrect. Try a earlier month";
        } else if (monthDiff < 0) {
            return "Inncorrect. Try a later month";
        }

        //check day, which is the lowest precendent
        if (dayDiff > 0) {
            return "Inncorrect. Try a earlier day";
        } else if (dayDiff < 0) {
            return "Inncorrect. Try a later day";
        }

        //should not reach here, since equals has already been checked and is false
        return "ERROR: date is equal or cannot be compared.";
    }

    /**
     * provides starting message
     * @return string
     */
    public String startMessage (){
        return "Guess the birthday of the " + personType() + " " + name;
    }
    /**
     * provides message for correct guess
     * @return string
     */
    public String closingMessage (){
        return "Congratulations! You were correct, "+toString();
    }

    public String toString (){
        return name + ", was born on " + birthday.getDay() + " " + birthday.getMonth() + ", "+ birthday.getYear();

    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return new Date(birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = new Date (birthday);
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

}

