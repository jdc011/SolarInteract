package com.example.jeremy.pcmap.Game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jeremy.pcmap.R; // temporary fix; need to research R
import com.example.jeremy.pcmap.SolarInteract; // imported to remove error
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
        /* TODO: Refer to SolarInteract.java for fixing red button names */
        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goBack(view); // Click listener event
            }
        });

        // Create difficulty buttons
        // TODO: Under construction
        /*
        Easy = (Button) findViewById(R.id.Easy);
        Medium = (Button) findViewById(R.id.Medium);
        Hard = (Button) findViewById(R.id.Hard);
        */

        Easy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                /* Easy setting */
            }
        });
    }

    // Display the difficulty selections
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solar_interact);
        Init();
    }
    // Return to game menu
    public void goBack(View view) {
        Intent homeActivity = new Intent(Difficulty.this, SolarInteract.class);
        startActivity(homeActivity);
    }
    // Plays the game
    public void play(View view) {
        Intent playGame = new Intent(Difficulty.this, /* name of class */null);
        startActivity(playGame);
    }
}
