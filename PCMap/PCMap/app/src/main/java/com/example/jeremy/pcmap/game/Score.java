package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jeremy.pcmap.R;

/**
 * Created by jmich_000 on 11/11/2017.
 */

public class Score extends Activity {
    private Button ToScoreboard;

    public void Init(){
        ToScoreboard = (Button) findViewById(R.id.ToScoreboard);
        ToScoreboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toScoreboard(view);
            }
        });
    }

    // Display the difficulty selections
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        Init();
    }

    // Goes to scoreboard
    public void toScoreboard(View view) {
        Intent toScoreboard = new Intent(Score.this, Scoreboard.class);
        startActivity(toScoreboard);
    }

    // TODO: Show the player's current score
}
