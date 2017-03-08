package com.example.jeremy.pcmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jeremy on 3/8/17.
 */

public class EmergencyActivity extends Activity{
    private Button back;

    public void init() {
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickMap(view);
            }
        });
    }

    @Override
    // Display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_activity);

        this.init();
    }

    public void clickMap(View view) {
        Intent emergencyActivity = new Intent(EmergencyActivity.this, MapsActivity.class);
        startActivity(emergencyActivity);
    }
}
