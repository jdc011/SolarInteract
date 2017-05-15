package com.example.jeremy.pcmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {
    // Buttons
    private Button Map;
    private Button Game;

    public void Init() {
        Map = (Button) findViewById(R.id.Map);
        Game = (Button) findViewById(R.id.Game);
        Map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clickMap(view); // Click listener event
            }
        });
    }

    // Display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Init();
    }

    public void clickMap(View view) {
        Intent mapActivity = new Intent(HomeActivity.this, MapsActivity.class);
        startActivity(mapActivity);
    }
}