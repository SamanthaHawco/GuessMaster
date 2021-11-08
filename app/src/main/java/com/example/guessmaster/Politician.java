package com.example.guessmaster;

/**
 *
 * @author Samantha Hawco 20167916
 */
public class Politician extends Person {

    private String party;

    /**
     * Constructor
     * @param name
     * @param birthday
     * @param difficulty
     * @param party
     */
    public Politician(String name, Date birthday, double difficulty, String party) {
        super(name, birthday, difficulty);
        this.party = party;
    }

    /**
     * Copy constructor
     *
     * @param toCopy, politician object to be copied
     */
    public Politician(Politician toCopy) {
        super(toCopy.getName(), toCopy.getBirthday(), toCopy.getDifficulty());
        this.party = toCopy.party;
    }

    /**
     * clones object
     *
     * @return Politician object
     */
    public Politician clone() {
        return new Politician(this);
    }

    public String toString() {
        return super.toString() + ". They are a member of the " + party + " party.";
    }

    /**
     * @return string, type of person
     */
    public String personType() {
        return "politician";
    }

}

