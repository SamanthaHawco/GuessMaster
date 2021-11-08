package com.example.guessmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //declare instance variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize instance variables

        //change person button
        //change person method call


        //guess button
        //guess method


        //test code from assignment
        //use addPerson
        //run startGame()

    }

    //change person method
    //set applicable text to empty
    //call start game method again

    public void startGame(){
        //generate a random number
        //get a random person
        //set applicable views based on that person

    }

    public void guess(){
        //changed some views

        //check if the user has typed quit
        System.exit(0);

        //change view to give feedback if incorrect

        //if correct change view
        //give them points, and change their total in a view
        //call the startGame method

    }


}