package com.example.jeremy.pcmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jeremy.pcmap.Game.Difficulty;
import com.example.jeremy.pcmap.Game.Scoreboard;

/**
 * Created by jeremy on 5/14/17.
 */

public class SolarInteract extends Activity {
    private Button Home, Play, Scoreboard;

    public void Init() {
        // Create home button with listener
        Home = (Button) findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goHome(view); // Click listener event
            }
        });

        // Create play button with listener
        Play = (Button) findViewById(R.id.Play);
        Play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                selectDifficulty(view);
            }
        });

        // Create scoreboard button with listener
        Scoreboard = (Button) findViewById(R.id.Scoreboard);
        Scoreboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                seeScoreboard(view);
            }
        });
    }

    // Display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solar_interact);
        Init();
    }
    // Return home
    public void goHome(View view) {
        Intent homeActivity = new Intent(SolarInteract.this, HomeActivity.class);
        startActivity(homeActivity);
    }
    // Go to difficulty selection
    public void selectDifficulty(View view) {
        Intent difficultySelection = new Intent(SolarInteract.this, Difficulty.class);
        startActivity(difficultySelection);
    }
    // See the scoreboard
    public void seeScoreboard(View view) {
        Intent scoreboard = new Intent(SolarInteract.this, Scoreboard.class);
        startActivity(scoreboard);
    }
}
