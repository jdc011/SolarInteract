package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jeremy.pcmap.R;
import com.example.jeremy.pcmap.SolarInteract;

/**
 * Created by jmich_000 on 10/13/2017.
 */

public class Scoreboard extends Activity{
    //Buttons
    private Button Back;

    public void Init() {
        // Create back button with listener
        Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goBack(view);
            }
        });
    }

    // Display the scoreboard page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard);
        Init();
    }

    // Return to game menu
    public void goBack(View view) {
        Intent homeActivity = new Intent(Scoreboard.this, SolarInteract.class);
        startActivity(homeActivity);
    }

    // TODO: Implement a scoreboard display
}
