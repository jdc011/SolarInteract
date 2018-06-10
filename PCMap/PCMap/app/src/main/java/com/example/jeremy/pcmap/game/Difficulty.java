package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeremy.pcmap.R;
import com.example.jeremy.pcmap.SolarInteract;

import java.util.HashMap;
//import com.example.jeremy.pcmap.*; // simplifies imports

/**
 * Created by jmich_000 on 10/13/2017.
 */

public class Difficulty extends Activity{
    // Programmer-changeable values corresponding to the number of solar panels to use
    private static final int EASY = 10;
    private static final int MEDIUM = 20;
    private static final int HARD = 30;
    /** Default setting (Medium) */
    private static final String defaultDifficulty = "Medium";
    // Buttons
    private Button Back, Easy, Medium, Hard, Play; // default setting is medium
    /** Difficulty setting: Easy, Medium, or Hard */
    private static String difficultySetting;
    /** Map that converts difficulty into a number. Used only for this purpose during the game */
    private static HashMap<String, Integer> difficultyMultiplier;

    public void Init() {
        if( difficultyMultiplier == null )
            initDifficultyMultiplier();
        resetTextViews(difficultySetting);

        // Create back button with listener
        Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });

        // Create back button with listener
        Play = (Button) findViewById(R.id.Play);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play(view);
            }
        });

        Easy = (Button) findViewById(R.id.Easy);
        Medium = (Button) findViewById(R.id.Medium);
        Hard = (Button) findViewById(R.id.Hard);


        Easy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetTextViews("Easy"); // method call needs to be before reset difficultySetting
                difficultySetting = "Easy";
                dialog(difficultySetting);
            }
        });

        Medium.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetTextViews("Medium");
                difficultySetting = "Medium";
                dialog(difficultySetting);
            }
        });

        Hard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetTextViews("Hard");
                difficultySetting = "Hard";
                dialog(difficultySetting);
            }
        });
    }

    /** Display the difficulty selections */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);
        Init();
    }

    /** Return to game menu */
    public void goBack(View view) {
        Intent homeActivity = new Intent(Difficulty.this, SolarInteract.class);
        startActivity(homeActivity);
    }

    /** Plays the game */
    public void play(View view) {
        Intent playGame = new Intent(Difficulty.this, CrankGame.class);
        startActivity(playGame);
    }

    /** Shows a dialog box when difficulty is selected
     *  Source: https://www.youtube.com/watch?v=IH3sWb1WacI
     */
    public void dialog(String diff) {
        new AlertDialog.Builder(this)
                //.setTitle("Title")
                .setMessage("Difficulty set at " + diff + ".")
                .setNeutralButton("Ok", null)
                .create().show();
    }

    /** Initializes difficultyMultiplier */
    private static void initDifficultyMultiplier() {
        difficultyMultiplier = new HashMap<String, Integer>();
        difficultyMultiplier.put("Easy", EASY);
        difficultyMultiplier.put("Medium", MEDIUM);
        difficultyMultiplier.put("Hard", HARD);
    }

    /** Resets other difficulty TextViews while setting the given one as the current diff setting */
    private void resetTextViews(String diff) {
        TextView t; //= (TextView) findViewById(R.id.DiffSetting);
        String oldDiffSetting;
        switch(difficultyMultiplier.get(difficultySetting)) {
            default: // defaults to resetting easy setting
            case EASY:
                t = (TextView) findViewById(R.id.Easy);
                oldDiffSetting = getResources().getString(R.string.si_diff_easy);
                break;
            case MEDIUM:
                t = (TextView) findViewById(R.id.Medium);
                oldDiffSetting = getResources().getString(R.string.si_diff_medium);
                break;
            case HARD:
                t = (TextView) findViewById(R.id.Hard);
                oldDiffSetting = getResources().getString(R.string.si_diff_hard);
                break;
        }
        t.setText(oldDiffSetting);

        String newDiffSetting;
        switch(difficultyMultiplier.get(diff)) {
            case 1:
                t = (TextView) findViewById(R.id.Easy);
                newDiffSetting = "→" + getResources().getString(R.string.si_diff_easy) + "←";
                break;
            default: // defaults to changing to medium setting
            case 2:
                t = (TextView) findViewById(R.id.Medium);
                newDiffSetting = "→" + getResources().getString(R.string.si_diff_medium) + "←";
                break;
            case 4:
                t = (TextView) findViewById(R.id.Hard);
                newDiffSetting = "→" + getResources().getString(R.string.si_diff_hard) + "←";
                break;
        }
        t.setText(newDiffSetting);
    }

    /** Sets default difficultySetting and initializes internal difficulty multiplier HashMap.
     *  Used by HomeActivity only */
    public static void defaultDifficulty() {
        difficultySetting = defaultDifficulty;
        initDifficultyMultiplier();
    }

    /** Getter for difficulty setting */
    public static String getDifficultySetting() {
        return difficultySetting;
    }

    /** Getter for numeric value of difficulty setting (the difficulty rating) */
    protected static int getDifficultyRating() { return difficultyMultiplier.get
            (difficultySetting); }
}
