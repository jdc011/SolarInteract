package com.example.jeremy.pcmap;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.Scanner;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    // Floor fields
    private int[] floors = {1,2,3,4};
    private int currentFloor = floors[0];

    //destination
    private ArrayList<PlaceName> dest;

    // Google map API
    private GoogleMap mMap;
    private GroundOverlay theOverlay;

    // Path to destination
    private Polyline theLine;

    // Error message string declaration
    private String errorMessage;

    // Buttons
    private Button Home;
    private Button Floor1;
    private Button Floor2;
    private Button Floor3;
    private Button Floor4;
    private Button[] buttonList = new  Button[4];

    // Button highlights based on current path
    private boolean[] highlighted = {false, false, false, false};

    @Override
    // Display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        // Create floor buttons
        Floor1 = (Button) findViewById(R.id.floor1);
        Floor2 = (Button) findViewById(R.id.floor2);
        Floor3 = (Button) findViewById(R.id.floor3);
        Floor4 = (Button) findViewById(R.id.floor4);

        // Put buttons in a list
        buttonList[0] = Floor1;
        buttonList[1] = Floor2;
        buttonList[2] = Floor3;
        buttonList[3] = Floor4;

        // Default floor
        if(this.currentFloor == this.floors[0]) {
            Floor1.setTextColor(Color.RED);
        }

        // Create home button with listener
        Home = (Button) findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                goHome(view); // Click listener event
            }
        });

        // List of floor buttons
        final Button[] floorButtons = {Floor1, Floor2, Floor3, Floor4};

        // Autocomplete feature in search bar
        final Constants con = new Constants();
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, con.LANDMARKS);
        autoCompleteTextView.setAdapter(adapter);

        // have done button exit keyboard full screen
        autoCompleteTextView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        Button Search =  (Button) findViewById(R.id.search_button);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Default remaining true highlights to false
                for(int i = 0; i < highlighted.length; i++) {
                    highlighted[i] = false;
                }

                // Default floor button colors
                for(int i = 0; i < floorButtons.length; i++) {
                    if(floorButtons[i].getCurrentTextColor() == Color.GREEN) {
                        floorButtons[i].setTextColor(Color.BLACK);

                        if(i+1 == currentFloor) {
                            floorButtons[i].setTextColor(Color.RED);
                        }
                    }
                }

                //get string from search bar
                String place = autoCompleteTextView.getText().toString().toLowerCase();

                if (con.toEnum(place) != null) {
                    // Show floor 1 starting
                    // Set button colors
                    currentFloor = floors[0];
                    Floor1.setTextColor(Color.RED);
                    Floor2.setTextColor(Color.BLACK);
                    Floor3.setTextColor(Color.BLACK);
                    Floor4.setTextColor(Color.BLACK);

                    // Draw current path if destination is searched
                    if (dest != null && dest.size() != 0)
                        drawPath(dest.toArray(new PlaceName[0]), currentFloor);

                    // Show current floor plan
                    showFloor(currentFloor);

                    // Set path highlight colors
                    for(int i = 0; i < floors.length; i++) {
                        if(highlighted[i] && i+1 != currentFloor){
                            buttonList[i].setTextColor(Color.GREEN);
                        }
                    }

                    //turn string into enum to be used
                    PlaceName thePlace = con.toEnum(place);
                    dest = con.getPath(thePlace, currentFloor);
                    System.out.println("DEBUG: " + dest);
                    drawPath(dest.toArray(new PlaceName[0]), currentFloor);
                    showFloor(currentFloor);

                    // Set button colors for available paths
                    for(int i = 0; i < floors.length; i++) {
                        if(con.FLOORS.get(thePlace) == null) {
                            errorMessage = "path to location does not exist yet";
                            handleError(errorMessage);
                            return;
                        }
                        if(con.FLOORS.get(thePlace) == floors[i]) {
                            if(i+1 != currentFloor) {
                                floorButtons[i].setTextColor(Color.GREEN);
                            }
                            highlighted[i] = true;
                        }
                    }
                } else { // error case
                    // didn't search
                    if (place.equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a place to search.",
                                Toast.LENGTH_SHORT).show();
                    } else { // not found
                        Toast.makeText(getApplicationContext(),
                                autoCompleteTextView.getText().toString() + " is not found.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                /* need to differentiate places by floor and message to point user to
                press the right floor button */
                // use drawPath(src, string typed by user)
            }
        });

        //clears search bar if pressed
        Button clear = (Button) findViewById(R.id.Clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Already cleared
                if (dest == null) {
                    autoCompleteTextView.setText("");
                    return;
                }

                // Clear objects being displayed
                autoCompleteTextView.setText("");
                dest.clear();
                theLine.setVisible(false);

                // Default remaining true highlights to false
                for(int i = 0; i < highlighted.length; i++) {
                    highlighted[i] = false;

                    // Set all color back except for current floor
                    if(floorButtons[i].getCurrentTextColor() == Color.GREEN) {
                        floorButtons[i].setTextColor(Color.BLACK);

                        if(i+1 == currentFloor) {
                            floorButtons[i].setTextColor(Color.RED);
                        }
                    }
                }
            }
        });
    }

    @Override
    // Display components in map
    public void onMapReady(GoogleMap googleMap) {
        // Initialize google map API
        mMap = googleMap;

        // Create constants object
        Constants con = new Constants();

        // Zoom buttons
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        showFloor(1);

        // Form SRC marker
        LatLng SRC = new LatLng(con.X_SRC, con.Y_SRC);

        // Add a marker in SRC, UCSD, and move the camera.
        mMap.addMarker(new MarkerOptions().position(SRC).title("You are here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SRC, con.DEF_ZOOM));

        mMap.setLatLngBoundsForCameraTarget(con.XY_POS);
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(con.X_SRC,con.Y_SRC)).zoom(20.0f).bearing(0).tilt(0).build()));
        //drawPath(new PlaceName[] {PlaceName.SRC, PlaceName.Santorini, PlaceName.SunshineMarket});
    }

   /* // Draw path from SRC to landmark
    public void drawPath(List<PlaceName> landmarks) {
        Constants con = new Constants();
        if (theLine == null) {
            PolylineOptions plo = new PolylineOptions();
            theLine = mMap.addPolyline(plo);
        }

        ArrayList<LatLng> pointsList = new ArrayList<LatLng>();
        for (PlaceName landmark : landmarks) {
            pointsList.add(con.LOCATIONS.get(landmark));
        }

        theLine.setPoints(pointsList);
    }*/

    // Draw path from SRC to landmark
    public void drawPath(PlaceName[] landmarks, int currentFloor) {
        Constants con = new Constants();
        if (theLine == null) {
            PolylineOptions plo = new PolylineOptions();
            theLine = mMap.addPolyline(plo);
        }

        ArrayList<LatLng> pointsList = new ArrayList<LatLng>();
        for (PlaceName landmark : landmarks) {
            if(con.FLOORS.get(landmark) == null) {
                errorMessage = "landmark \"" + landmark.name() + "\" not found";
                handleError(errorMessage);
                return;
            } else
                System.out.println(currentFloor);
            if (con.FLOORS.get(landmark) == currentFloor) {
                pointsList.add(con.LOCATIONS.get(landmark));
            }
        }

        theLine.setPoints(pointsList);
        theLine.setVisible(true);
    }

    /** Handles error messages, creates a textbox */
    private void handleError(String err) {
        System.err.println(err);
        /*
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Error message: \n" + err)
                .setNeutralButton("Close", null)
                .create().show();
        */
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }

    // Shows a certain floor
    public void showFloor(int theFloor) {
        // Create constants object
        Constants con = new Constants();

        BitmapDescriptor theBitmap = BitmapDescriptorFactory.fromResource(con.floorplans[theFloor]);

        // Form PC floor plan
        GroundOverlayOptions PCOverlay = new GroundOverlayOptions()
                .image(theBitmap)
                .positionFromBounds(con.XY_POS);

        // Add PC floor plan to map
        if (theOverlay == null) {
            theOverlay = mMap.addGroundOverlay(PCOverlay);
        } else {
            theOverlay.setImage(theBitmap);
        }
    }

    // Show floor 1
    public void clickFloor1(View view) {
        // Set button colors
        this.currentFloor = floors[0];
        Floor1.setTextColor(Color.RED);
        Floor2.setTextColor(Color.BLACK);
        Floor3.setTextColor(Color.BLACK);
        Floor4.setTextColor(Color.BLACK);

        // Draw current path if destination is searched
        if (dest != null && dest.size() != 0)
            drawPath(dest.toArray(new PlaceName[0]), currentFloor);

        // Show current floor plan
        showFloor(this.currentFloor);

        // Set path highlight colors
        for(int i = 0; i < floors.length; i++) {
            if(highlighted[i] && i+1 != currentFloor){
                buttonList[i].setTextColor(Color.GREEN);
            }
        }
    }

    // Show floor 2
    public void clickFloor2(View view) {
        // Set button colors
        this.currentFloor = floors[1];
        Floor1.setTextColor(Color.BLACK);
        Floor2.setTextColor(Color.RED);
        Floor3.setTextColor(Color.BLACK);
        Floor4.setTextColor(Color.BLACK);

        // Draw current path if destination is searched
        if (dest != null && dest.size() != 0)
            drawPath(dest.toArray(new PlaceName[0]), currentFloor);

        // Show current floor plan
        showFloor(this.currentFloor);

        // Set path highlight colors
        for(int i = 0; i < floors.length; i++) {
            if(highlighted[i] && i+1 != currentFloor){
                buttonList[i].setTextColor(Color.GREEN);
            }
        }
    }

    // Show floor 3
    public void clickFloor3(View view) {
        // Set button colors
        this.currentFloor = floors[2];
        Floor1.setTextColor(Color.BLACK);
        Floor2.setTextColor(Color.BLACK);
        Floor3.setTextColor(Color.RED);
        Floor4.setTextColor(Color.BLACK);

        // Draw current path if destination is searched
        if (dest != null && dest.size() != 0)
            drawPath(dest.toArray(new PlaceName[0]), currentFloor);

        // Show current floor plan
        showFloor(this.currentFloor);

        // Set path highlight colors
        for(int i = 0; i < floors.length; i++) {
            if(highlighted[i] && i+1 != currentFloor){
                buttonList[i].setTextColor(Color.GREEN);
            }
        }
    }

    // Show floor 4
    public void clickFloor4(View view) {
        // Set button colors
        this.currentFloor = floors[3];
        Floor1.setTextColor(Color.BLACK);
        Floor2.setTextColor(Color.BLACK);
        Floor3.setTextColor(Color.BLACK);
        Floor4.setTextColor(Color.RED);

        // Draw current path if destination is searched
        if (dest != null && dest.size() != 0)
            drawPath(dest.toArray(new PlaceName[0]), currentFloor);

        // Show current floor plan
        showFloor(this.currentFloor);

        // Set path highlight colors
        for(int i = 0; i < floors.length; i++) {
            if(highlighted[i] && i+1 != currentFloor){
                buttonList[i].setTextColor(Color.GREEN);
            }
        }
    }

    // Return home
    public void goHome(View view) {
        Intent homeActivity = new Intent(MapsActivity.this, HomeActivity.class);
        startActivity(homeActivity);
    }
}