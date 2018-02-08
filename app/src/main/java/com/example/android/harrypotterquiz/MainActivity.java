package com.example.android.harrypotterquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int totalPoints = 0;

    public void submitAnswers(View view) {

        //get gryffindor CheckBox id
        CheckBox gryffindorCheckbox = findViewById(R.id.griffyndor);

        //get ravenclaw CheckBox id
        CheckBox ravenclawCheckbox = findViewById(R.id.ravenclaw);

        //get slytherin CheckBox id
        CheckBox slytherinCheckbox = findViewById(R.id.slytherin);

        //get hufflepuff CheckBox id
        CheckBox hufflepuffCheckbox = findViewById(R.id.hufflepuff);

        //call method to calculate the points of question 1
        calculateCheckBoxPts(gryffindorCheckbox.isChecked(),ravenclawCheckbox.isChecked(),slytherinCheckbox.isChecked(),hufflepuffCheckbox.isChecked());

        //get EditText id for question 2
        EditText answer2Text = findViewById(R.id.answer2);

        //call method to calculate the points from question 2
        calculateEditTextPoints(answer2Text.getText().toString(), "Minerva");

        //get RadioButton Id from question 3
        RadioButton unicornHairButton = findViewById(R.id.unicorn_hair);

        //call method to calculate points from question 3
        calculateRadioBtnPoints(unicornHairButton.isChecked());

        //get EditText id from question 4
        EditText answer4Text = findViewById(R.id.answer4);

        //call method to calculate points from question 4
        calculateEditTextPoints(answer4Text.getText().toString(), "expecto patronum");

        //get RadioButton id from question 5
        RadioButton boggartButton = (RadioButton)findViewById(R.id.worst_fears);

        //call method to calculate points from question 5
        calculateRadioBtnPoints(boggartButton.isChecked());

        //display quiz results to user
        String displayResults = createMessage(totalPoints);
        Toast.makeText(this, displayResults, Toast.LENGTH_LONG).show();

        //set totalPoints back to 0, so if user plays again without resetting, or hits the submit button multiple times
        // the point total will start over
        totalPoints = 0;

    }

    /** this method calculate the points for question one
     *
     * @param griffyndor boolean, did the user check this box
     * @param ravenclaw boolean, did the user check this box
     * @param slytherin boolean, did the user check this box
     * @param hufflepuff boolean, did the user check this box
     * @return int, sum of points for the first question
     */
    private int calculateCheckBoxPts(boolean griffyndor, boolean ravenclaw, boolean slytherin, boolean hufflepuff){

        if (griffyndor == true){
            totalPoints = totalPoints + 1;
        }

        if(ravenclaw == true) {
            totalPoints = totalPoints + 1;
        }

        if(slytherin == true) {
            totalPoints = totalPoints + 1;
        }

        if(hufflepuff == true) {
            totalPoints = totalPoints + 1;
        }
        return totalPoints;
    }

    /**this method calculates the sum of points for question 2 and question 4
     *
     * @param actualAnswer string, the answer the user submitted
     * @return int, add one point to totalPoints
     */
    private int calculateEditTextPoints(String actualAnswer, String expectedAnswer){
        //compare the strings passed in, if they are equal add a point
        if (actualAnswer.toLowerCase().compareTo(expectedAnswer.toLowerCase()) == 0){
            totalPoints = totalPoints + 1;
        }
        return totalPoints;
    }

    /** this method calculates the sum of points for question 3 and 5
     *
     * @param isChecked boolean, did the user check the correct answer
     * @return total points received for question 3 and 5
     */
    private int calculateRadioBtnPoints(boolean isChecked){

        if(isChecked == true){
            totalPoints = totalPoints + 1;
        }
        return totalPoints;
    }

    /**method to create the toast to display the quiz results
     *
     * @param totalPoints int, total points received for the quiz
     * @return String, message displaying the results to user
     */
    private String createMessage(int totalPoints) {
        String results = "Here are your final results from Hogwarts:";
        String scoreMsg = "You received a score of ";
        String maxMsg = " out of 8 points.";

        if (totalPoints >= 6) {
            results += "\n" + "Great job, you really know your Harry Potter facts! " + scoreMsg + totalPoints + maxMsg;
        } else if (totalPoints >= 3) {
            results += "\n" + "Not bad, you know a lot of Harry Potter facts. " + scoreMsg + totalPoints + maxMsg;

        } else if (totalPoints >= 1) {
            results += "\n" + "Better luck next time, keep reading Harry Potter!! " + scoreMsg + totalPoints + maxMsg;
        }

        return results;

    }

    //reset the view when user hits the reset button, clear the quiz
    public void reset(View v){
        setContentView(R.layout.activity_main);
    }
}
