package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jeremy.pcmap.R;
import com.example.jeremy.pcmap.SolarInteract;

import java.util.HashMap;
//import com.example.jeremy.pcmap.*; // simplifies imports

/**
 * Created by jmich_000 on 10/13/2017.
 */

public class Difficulty extends Activity{
    // Programmer-changeable values corresponding to the number of solar panels to use
    private final int EASY = 1;
    private final int MEDIUM = 2;
    private final int HARD = 4;
    // Buttons
    private Button Back, Easy, Medium, Hard, Play; // default setting is medium
    // Difficulty setting
    private static String difficultySetting;
    // Default setting
    private static final String defaultDifficulty = "Medium";
    // Map that converts difficulty into a number
    private static HashMap<String, Integer> difficultyMultiplier;

    public void Init() {
        setDifficultyMultiplier();

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
                difficultySetting = "Easy";
                dialog(difficultySetting);
            }
        });

        Medium.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                difficultySetting = "Medium";
                dialog(difficultySetting);
            }
        });

        Hard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                difficultySetting = "Hard";
                dialog(difficultySetting);
            }
        });
    }

    // Display the difficulty selections
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);
        Init();
    }

    // Return to game menu
    public void goBack(View view) {
        Intent homeActivity = new Intent(Difficulty.this, SolarInteract.class);
        startActivity(homeActivity);
    }

    // Plays the game
    public void play(View view) {
        Intent playGame = new Intent(Difficulty.this, CrankGame.class);
        startActivity(playGame);
    }

    // Shows a dialog box when difficulty is selected
    // Source: https://www.youtube.com/watch?v=IH3sWb1WacI
    public void dialog(String diff) {
        new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Difficulty set at " + diff + ".")
                .create().show();
    }

    // Initializes difficultyMultiplier
    private void setDifficultyMultiplier() {
        difficultyMultiplier = new HashMap<String, Integer>();
        difficultyMultiplier.put("Easy", EASY);
        difficultyMultiplier.put("Medium", MEDIUM);
        difficultyMultiplier.put("Hard", HARD);
    }

    // Sets default difficultySetting
    public static void defaultDifficulty() {
        difficultySetting = defaultDifficulty;
    }

    // Getter for difficulty setting
    public static String getDifficultySetting() {
        return difficultySetting;
    }
}
