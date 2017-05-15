package com.example.jeremy.pcmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jeremy on 5/14/17.
 */

public class SolarInteract extends Activity {
    private Button Home;

    public void Init() {
        // Create home button with listener
        Home = (Button) findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goHome(view); // Click listener event
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
}
