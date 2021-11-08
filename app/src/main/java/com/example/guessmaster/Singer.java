package com.example.guessmaster;

/**
 *
 * @author Samantha Hawco
 */
public class Singer extends Person {
    private String debutAlbum;
    private Date debutAlbumReleaseDate;
    /**
     * Constructor
     * @param name
     * @param birthday
     * @param difficulty
     * @param debutAlbum
     * @param debutAlbumReleaseDate
     */
    public Singer(String name, Date birthday, double difficulty, String debutAlbum, Date debutAlbumReleaseDate) {
        super(name, birthday, difficulty);
        this.debutAlbum = debutAlbum;
        this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
    }

    /**
     * Copy constructor
     * @param toCopy, Singer object to be copied
     */
    public Singer(Singer toCopy){
        super(toCopy.getName(),toCopy.getBirthday(), toCopy.getDifficulty());
        this.debutAlbum = toCopy.debutAlbum;
        this.debutAlbumReleaseDate = new Date (toCopy.debutAlbumReleaseDate);
    }
    /**
     * Clones singer
     * @return Singer object
     */
    public Singer clone(){
        return new Singer(this);
    }

    public String toString (){
        return super.toString() + " Their debut album was " + debutAlbum + ", and was released on " + debutAlbumReleaseDate.toString()+ ". ";
    }
    /**
     * @return string, type of person
     */
    public String personType(){
        return "singer";
    }



}
