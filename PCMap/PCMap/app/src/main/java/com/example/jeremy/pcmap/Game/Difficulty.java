package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jeremy.pcmap.R;
import com.example.jeremy.pcmap.SolarInteract;
//import com.example.jeremy.pcmap.*; // simplifies imports

/**
 * Created by jmich_000 on 10/13/2017.
 */

public class Difficulty extends Activity{
    //Buttons
    private Button Back, Easy, Medium, Hard, Play;

    public void Init() {
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

        // TODO: Create difficulty buttons

        /*Easy = (Button) findViewById(R.id.Easy); /*
        Medium = (Button) findViewById(R.id.Medium);
        Hard = (Button) findViewById(R.id.Hard);


        Easy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Easy setting
            }
        });
        */
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

    // TODO: Implement easy/medium/hard difficulty setting
}
