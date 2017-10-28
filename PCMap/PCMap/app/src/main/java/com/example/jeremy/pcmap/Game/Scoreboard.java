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

public class Scoreboard extends Activity{
    //Buttons
    private Button Back;

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
    }

    // Display the scoreboard page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solar_interact);
        Init();
    }
    // Return to game menu
    public void goBack(View view) {
        Intent homeActivity = new Intent(Scoreboard.this, SolarInteract.class);
        startActivity(homeActivity);
    }
}
