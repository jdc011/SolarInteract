package com.example.jeremy.pcmap.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.text.Text;
import com.jjoe64.graphview.GraphView;

import com.example.jeremy.pcmap.R;

import static com.example.jeremy.pcmap.game.Difficulty.getDifficultyRating;
import static com.example.jeremy.pcmap.game.Difficulty.getDifficultySetting;

/**
 * Created by jmich_000 on 11/11/2017.
 */

public class CrankGame extends Activity {
    // Buttons for the game
    private Button Pause, REMOVETHISGoToScore, REMOVETHISIncreaseScore;
    /** Difficulty rating for the game */
    private int difficultyRating;
    /** Keeps track of player score */
    private static double playerScore;
    /** Keeps track of solar panel score */
    private static double solarScore;
    /** Number of ticks per second */
    private final int TICK = 20;

    public void Init(){
        difficultyRating = Difficulty.getDifficultyRating();
        playerScore = 0;
        solarScore = Math.pow(2, difficultyRating + 2);

        // Modifies the left TextView to dynamically show difficulty setting
        TextView t = (TextView) findViewById(R.id.DiffSetting);
        String diffSetting = getResources().getString(R.string.si_crank_diff) + " "
                + Difficulty.getDifficultySetting();
        t.setText(diffSetting);

        // Modifies the middle TextView to dynamically show difficulty rating
        t = (TextView) findViewById(R.id.DiffRating);
        diffSetting = getResources().getString(R.string.si_crank_rating) + " " + difficultyRating;
        t.setText(diffSetting);

        // Modifies the right two TextViews to dynamically display scores
        updatePlayerScore();
        updateSolarScore();

        Pause = (Button) findViewById(R.id.Pause);
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause(view);
            }
        });

        // TODO: delete the following button block
        REMOVETHISGoToScore = (Button) findViewById(R.id.REMOVETHISGoToScore);
        REMOVETHISGoToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                REMOVETHISgoToScore(view);
            }
        });

        // TODO: delete the following button block
        REMOVETHISIncreaseScore = (Button) findViewById(R.id.REMOVETHISIncreaseScore);
        REMOVETHISIncreaseScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                REMOVETHISincreaseScore(view);
            }
        });
    }

    /** Display the difficulty selections */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crank_game);
        Init();
        update();
    }

    /** Pauses the game temporarily */
    protected void onPause(View view) {
        /* TODO: Pauses the game */
    }

    /** Getter for player score */
    public static double getPlayerScore() { return playerScore; }

    /** Getter for solar score */
    public static double getSolarScore() { return solarScore; }

    /** Starts a new thread that updates the screen every tick
     *  Code from: https://stackoverflow.com/questions/14814714/update-textview-every-second
     */
    private void update() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000 / TICK);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updatePlayerScore();
                                updateSolarScore();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    /** Updates the player score */
    private void updatePlayerScore() {
        TextView t = (TextView) findViewById(R.id.PlayerScoreDisplay);
        String scoreToDisplay = getResources().getString(R.string.si_crank_playerScore) + " " +
                playerScore;
        t.setText(scoreToDisplay);
    }

    /** Updates the solar panels score */
    private void updateSolarScore() {
        TextView t = (TextView) findViewById(R.id.SolarScoreDisplay);
        String scoreToDisplay = getResources().getString(R.string.si_crank_solarScore) + " " +
                solarScore;
        t.setText(scoreToDisplay);
    }

    // TODO: remove this button when the game is implemented
    /** Allows programmer to go to Score Activity */
    public void REMOVETHISgoToScore(View view) {
        Intent goToScore = new Intent(CrankGame.this, Score.class);
        startActivity(goToScore);
    }

    // TODO: remove this button when the game is implemented
    /** Cookie Clicker */
    public void REMOVETHISincreaseScore(View view) {
        playerScore++;
    }

    // TODO: Run the game
}
