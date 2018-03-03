package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jeremy.pcmap.R;

/**
 * Created by jmich_000 on 11/11/2017.
 */

public class Score extends Activity {
    // Buttons
    private Button ToScoreboard;
    // strings for win/lose conditions
    private final String WIN = "You won! You beat the solar panel!";
    private final String LOSE = "You lost! Better luck next time!";
    private final String DRAW = "Wow! You and the solar panel(s) drew!";

    public void Init(){
        updateScores();
        updateResult();

        ToScoreboard = (Button) findViewById(R.id.ToScoreboard);
        ToScoreboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toScoreboard(view);
            }
        });
    }

    /** Display the difficulty selections */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);
        Init();
    }

    /** Goes to scoreboard */
    public void toScoreboard(View view) {
        Intent toScoreboard = new Intent(Score.this, Scoreboard.class);
        startActivity(toScoreboard);
    }

    /** Modifies the text fields to display scores */
    private void updateScores() {
        // player score
        double score = CrankGame.getPlayerScore();
        TextView t = (TextView) findViewById(R.id.PlayerScore);
        String updateString = t.getText().toString() + " " + score;
        t.setText(updateString);

        // solar panel score
        score = CrankGame.getSolarScore();
        t = (TextView) findViewById(R.id.SolarScore);
        updateString = t.getText().toString() + " " + score;
        t.setText(updateString);
    }

    /** Modifies the result to show either win, lose, or draw */
    private void updateResult() {
        double difference = CrankGame.getPlayerScore() - CrankGame.getSolarScore();
        String s = DRAW;
        if(difference > 0)
            s = WIN;
        else if(difference < 0)
            s = LOSE;
        TextView t = (TextView) findViewById(R.id.Result);
        t.setText(s);
    }
}
