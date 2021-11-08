package com.example.guessmaster;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Samantha Hawco 20167916
 */
public class GuessMaster extends AppCompatActivity {

    private Person[] people;
    private int numPoints;
    private int numPeople;

    private TextView personName;
    private TextView pointTotal;
    private TextView message;
    private Button guessButton;
    private EditText guessInput;
    private Button changeButton;
    private ImageView personImage;

    private Person currPerson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing variables
        personName = (TextView) findViewById(R.id.personNameText);
        pointTotal = (TextView) findViewById(R.id.pointTotalText);
        message = (TextView) findViewById(R.id.messageText);
        guessButton = (Button) findViewById(R.id.guessButton);
        guessInput = (EditText) findViewById(R.id.guessEditText);
        changeButton = (Button) findViewById(R.id.changeButton);
        personImage = (ImageView) findViewById(R.id.personImage);
        numPoints = 0;
        //set original message and point display
        pointTotal.setText("Total Points: " + numPoints);
        message.setText("Welcome! Let's start the game.");

        //button listeners
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePerson();
            }
        });
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // playing game
                guess();
            }
        });
        //create persons and add to array
        Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), 0.25, "Liberal");
        Singer dion = new Singer("Celine Dion", new Date(30, 3, 1961), 0.5, "La voix du bon Dieu", new Date(6, 11, 1981));
        Singer robertson = new Singer("Ed Robertson", new Date(25, 10, 1970), 0.75, "Gordon", new Date(28, 7, 1992));
        addPerson(trudeau);
        addPerson(dion);
        addPerson(robertson);
        startGame(); //starts running the game
    }

    /**
     * Changes person being guessed and resets displays.
     */
    public void changePerson() {
        guessInput.getText().clear();
        message.setText(" ");
        startGame();
    }

    /**
     * Takes the user input and checks the guess, displaying appropriate messages
     */
    public void guess(){
        String guessString;
        Date guessDate;

        guessString = guessInput.getText().toString(); //reads user input
        if (guessString.equalsIgnoreCase("quit")) {
            System.exit(0); //exit program
        }

        guessDate = new Date(guessString); //creates Date with entered guess string
        if (guessDate.equals(currPerson.getBirthday())) { //if guess is correct
            message.setText(currPerson.closingMessage()); //print closing message for selected person
            numPoints = numPoints + currPerson.getAwardedPointNumber(); //accumulate total points
            message.setText("You won " + currPerson.getAwardedPointNumber() + " points in this round.");
            pointTotal.setText("Total points :"+numPoints);
            guessInput.getText().clear();
            startGame();
        } else { //guess was wrong
            message.setText(currPerson.dateCompare(guessDate));//compare guess and birthday and give suggestion
            guessInput.getText().clear();
        }
    }

    /**
     * Constructor
     */
    public GuessMaster() {
        people = new Person[0];
        numPoints = 0;
        numPeople = 0;
    }

    /**
     * Runs game play, communicates with user, and reads guesses
     */
    public void startGame() { //runs the game process
        int currIndex;
        Scanner read = new Scanner(System.in);
        Random rnd = new Random();

        currIndex = rnd.nextInt(numPeople);//random index number for random person selection
        currPerson = people[currIndex].clone(); //set current person based on random and use clone to avoid privacy leak
        personName.setText(currPerson.startMessage()); //display start message
        //display appropriate photo
        if (currPerson.getName().equalsIgnoreCase("Celine Dion")) {
            //set pic
            personImage.setImageResource(R.drawable.celine);
        } else if (currPerson.getName().equalsIgnoreCase("Justin Trudeau")) {
            //set pic
            personImage.setImageResource(R.drawable.justin);
        } else {
            //set pic of ed
            personImage.setImageResource(R.drawable.ed);
        }

    }

    /**
     * Adds new person to array of people and increases numPeople
     *
     * @param newPerson
     */
    public void addPerson(Person newPerson) {
        if (people == null) {
            people = new Person[0];
        }
        people = Arrays.copyOf(people, people.length + 1);
        people[numPeople] = newPerson.clone();
        numPeople++;
    }


}

