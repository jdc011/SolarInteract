package com.example.jeremy.pcmap.game;

import android.app.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeremy.pcmap.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import static com.example.jeremy.pcmap.game.Difficulty.getDifficultyRating;
import static com.example.jeremy.pcmap.game.Difficulty.getDifficultySetting;


/**
 * Created by jmich_000 on 11/11/2017.
 */

public class CrankGame extends Activity {
    /** Number of ticks per second */
    private final int TICK = 20;
    /** Duration of the game in seconds */
    private final int NUM_SECONDS = 60;
    // Buttons for the game
    private Button Pause, REMOVETHISGoToScore, REMOVETHISIncreaseScore;
    /** Difficulty rating for the game */
    private int difficultyRating;
    /** Keeps track of player score */
    private static double playerScore;
    /** Keeps track of solar panel score */
    private static double solarScore;
    /** Keeps track of paused state */
    private boolean isPaused;
    /** Timer for the game */
    private int timer;
    /** Thread management */
    private Thread thread;
    /** Handler for sending messages between the worker thread and the main UI thread */
    private Handler mHandler;

    public void Init(){
        difficultyRating = Difficulty.getDifficultyRating();
        playerScore = 0;
        solarScore = Math.pow(2, difficultyRating + 2);
        isPaused = false;
        timer = TICK * NUM_SECONDS;

        // Modifies the left TextView to dynamically show difficulty setting
        TextView t = (TextView) findViewById(R.id.DiffSetting);
        String diffSetting = getResources().getString(R.string.si_crank_diff) + " "
                + Difficulty.getDifficultySetting();
        t.setText(diffSetting);

        // Modifies the middle TextView to dynamically show difficulty rating
        t = (TextView) findViewById(R.id.DiffRating);
        diffSetting = getResources().getString(R.string.si_crank_rating) + " "
                + difficultyRating;
        t.setText(diffSetting);

        // Modifies the right two TextViews to dynamically display scores
        updatePlayerScore();
        updateSolarScore();

        // Initializes timer
        updateTimer();

        // Pause button
        Pause = (Button) findViewById(R.id.Pause);
        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPause(view);
            }
        });

        // Message handler (see line 153)
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message inputMessage) {
                // The following line is only there to demonstrate that mHandler received a message
                // Otherwise handleMessage only exists to execute a task whenever it receives
                // message, i.e. (as of commit #108) whenever the worker thread is interrupted.
                //System.err.println(((Exception) inputMessage.obj).getMessage());
                System.out.println("Worker thread interrupted via " + inputMessage.obj.toString()
                    + "; game stopped, to the scores!");

                //handleException((Exception) inputMessage.obj);
            }
        };

        // TODO: delete the following 2 button blocks
        // REMOVETHISGoToScore = (Button) findViewById(R.id.REMOVETHISGoToScore);
        /*REMOVETHISGoToScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                REMOVETHISgoToScore(view);
            }
        });

        // REMOVETHISIncreaseScore = (Button) findViewById(R.id.REMOVETHISIncreaseScore);
        REMOVETHISIncreaseScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                REMOVETHISincreaseScore(view);
            }
        });*/
    }

    /** Display the difficulty selections */
    protected void onCreate(Bundle savedInstanceState) {
        System.out.print("DEBUG: IN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crank_game);
        Init();
        update();

        // TODO
        //    private final String DEVICE_NAME="MyBTBee";
        final String DEVICE_ADDRESS = "20:16:12:12:63:33";
        final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");//Serial Port Service ID
        BluetoothDevice device;
        BluetoothSocket socket;
        OutputStream outputStream;
        InputStream inputStream;
        Button startButton, sendButton, clearButton, stopButton;
        TextView textView;
        EditText editText;
        boolean deviceConnected = false;
        Thread thread;
        byte buffer[];
        int bufferPosition;
        boolean stopThread;

        boolean found=false;
        BluetoothAdapter bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),"Device doesnt Support Bluetooth",Toast.LENGTH_SHORT).show();
        }
        if(!bluetoothAdapter.isEnabled())
        {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter, 0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
        if(bondedDevices.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Please Pair the Device first",Toast.LENGTH_SHORT).show();
        }
        else {
            for (BluetoothDevice iterator : bondedDevices) {
                if (iterator.getAddress().equals(DEVICE_ADDRESS)) {
                    device = iterator;
                    found = true;

                    // TODO
                    try {
                        System.out.print("DEBUG: WIN");
                        socket = device.createRfcommSocketToServiceRecord(PORT_UUID);
                        socket.connect();
                        outputStream = socket.getOutputStream();
                        outputStream.write(100);
                    }
                    catch (IOException e) {

                    }
                    break;
                }
            }
        }
    }

    public void setUiEnabled(boolean bool)
    {

    }

    public boolean BTinit()
    {
        return true;
    }



    public void onClickStart(View view) {
        if(BTinit())
        {
            if(true)
            {

            }

        }
    }

    void beginListenForData() {

    }

    public void onClickSend(View view) {

    }

    public void onClickStop(View view) throws IOException {

    }

    public void onClickClear(View view) {

    }


    /** Pauses the game temporarily */
    public void onPause(View view) {
        isPaused = !isPaused;
        update();
    }

    /** Getter for player score */
    public static double getPlayerScore() { return playerScore; }

    /** Getter for solar score */
    public static double getSolarScore() { return solarScore; }

    /** Starts a new thread that updates the screen every tick
     *  Code from: https://stackoverflow.com/questions/14814714/update-textview-every-second
     */
    private void update() {
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (/*!isInterrupted()*/!isPaused) {
                        Thread.sleep(1000 / TICK);
                        solarScore += Math.pow(2,-4);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updatePlayerScore();
                                updateSolarScore();
                                updateTimer();
                            }
                        });
                        timer--;
                        if(timer == 0) {
                            handleGameEnd();
                        }
                    }
                } catch (InterruptedException e) {
                    // This is in a worker thread, need to send message to main thread
                    // Sources:
                    //   https://developer.android.com/training/multiple-threads/communicate-ui.html
                    //   https://stackoverflow.com/questions/3875184/cant-create-handler-inside-thread-that-has-not-called-looper-prepare
                    Message message = mHandler.obtainMessage(1, e);
                    message.sendToTarget();

                    // Old code:
                    //handleException(e);
                }
            }
        };
        thread.start();
    }

    /** Handles exceptions thrown, creates a textbox */
    private void handleException(Exception e) {
        new AlertDialog.Builder(this)
                .setTitle("Uh oh, " + e.getClass() + " threw an exception!")
                .setMessage("Error message: " + e.getMessage())
                .setNeutralButton("Ok", null)
                .create().show();
    }

    /** Updates the player score */
    private void updatePlayerScore() {
        TextView t = (TextView) findViewById(R.id.PlayerScoreDisplay);
        String scoreToDisplay = getResources().getString(R.string.si_crank_playerScore) + " " + playerScore;
        t.setText(scoreToDisplay);
    }

    /** Updates the solar panels score */
    private void updateSolarScore() {
        TextView t = (TextView) findViewById(R.id.SolarScoreDisplay);
        String scoreToDisplay = getResources().getString(R.string.si_crank_solarScore) + " " + solarScore;
        t.setText(scoreToDisplay);
    }

    /** Updates the timer to display the time left */
    private void updateTimer() {
        TextView t = (TextView) findViewById(R.id.Timer);
        String timeToDisplay = getResources().getString(R.string.si_crank_timer) + " " +
                (timer/20+1);
        t.setText(timeToDisplay);
    }

    /** Handles end of game functions (goes to player score screen) */
    public void handleGameEnd() {
        thread.interrupt();
        Intent goToScore = new Intent(CrankGame.this, Score.class);
        startActivity(goToScore);
    }

    // TODO: remove this button when the game is implemented
    /** Allows programmer to go to Score Activity */
    public void REMOVETHISgoToScore(View view) {
        handleGameEnd();
    }

    // TODO: remove this button when the game is implemented
    /** Cookie Clicker */
    public void REMOVETHISincreaseScore(View view) { playerScore += (isPaused)?0:1; }

    // TODO: Run the game
}
