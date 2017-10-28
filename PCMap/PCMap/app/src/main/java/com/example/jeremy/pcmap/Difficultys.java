package com.example.jeremy.pcmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jmich_000 on 10/13/2017.
 */

public class Difficultys extends Activity{    //Buttons
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
        Intent homeActivity = new Intent(Difficultys.this, SolarInteract.class);
        startActivity(homeActivity);
    }
}
