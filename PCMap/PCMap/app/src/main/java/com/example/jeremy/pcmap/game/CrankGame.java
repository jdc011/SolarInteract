package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jeremy.pcmap.R;

import java.util.HashMap;

/**
 * Created by jmich_000 on 11/11/2017.
 */

public class CrankGame extends Activity {
    // Buttons for the game
    private Button Pause, REMOVETHISGoToScore;

    public void Init(){
        Pause = (Button) findViewById(R.id.Pause);
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause(view);
            }
        });

        // TODO: Remove the following button block
        REMOVETHISGoToScore = (Button) findViewById(R.id.REMOVETHISGoToScore);
        REMOVETHISGoToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                REMOVETHISgoToScore(view);
            }
        });
    }

    // Display the difficulty selections
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crank_game);
        Init();
    }

    // Pauses the game temporarily
    public void onPause(View view) {
        /* TODO: Pauses the game */
    }

    // TODO: remove this button when the game is implemented
    public void REMOVETHISgoToScore(View view) {
        Intent goToScore = new Intent(CrankGame.this, Score.class);
        startActivity(goToScore);
    }

    // TODO: Run the game
}
