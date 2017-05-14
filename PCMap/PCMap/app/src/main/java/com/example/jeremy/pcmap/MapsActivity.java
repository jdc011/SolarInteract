package com.example.jeremy.pcmap;

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
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Scanner;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    // Google map API
    private GoogleMap mMap;
    private GroundOverlay theOverlay;
    private Polyline theLine;

    // Button that changes layout
    private Button emergency;

    // Get ready for other layout on click
    public void init() {
        // Initialize button
        emergency = (Button) findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickEmergency(view); // Click listener event
            }
        });

        // TESTING LOCATION AND COORDINATE CLASS:
        // --------------------------------------

        // Note: Has multiple problems, causes program to crash without running

        /*
        Scanner LOCs = new Scanner("map_locations.txt");
        String LOCstr = LOCs.nextLine();
        while(LOCs.hasNext() || !LOCstr.equals("End")){
            Location loc = new Location(LOCstr);
            LOCstr = LOCs.nextLine();
        }

        ArrayList<Coordinate> LOCarr = Coordinate.getAllCoordinates();
        System.out.println(LOCarr.get(2) + "; should expect \"x: 32.879901; y: -117.236197\"");

        LOCs.close();
        */

        // --------------------------------------

    }

    @Override
    // Display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        // Call to init
        this.init();
    }

    public void onMapSearch(View view) {
        // Autocomplete feature in search bar
        Constants con = new Constants();
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, con.LANDMARKS);
        autoCompleteTextView.setAdapter(adapter);

        // have done button exit keyboard full screen
        autoCompleteTextView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        //get string from search bar
        String place = autoCompleteTextView.getText().toString().toLowerCase();

        if(con.toEnum(place) != null) {
            //turn string into enum to be used
            PlaceName thePlace = con.toEnum(place);
            //need pop up message if user input place that does not exists
            drawPath(new PlaceName[]{PlaceName.SRC, thePlace});
        }

        // error case
        else
        {
            // didn't search
            if(place.equals("")) {
                Toast.makeText(getApplicationContext(), "Enter a place to search.", Toast.LENGTH_SHORT).show();
            }

            // not found
            else {
                Toast.makeText(getApplicationContext(), autoCompleteTextView.getText().toString() + " is not found.", Toast.LENGTH_SHORT).show();
            }
        }
        /* need to differentiate places by floor and message to point user to
           press the right floor button*/
        //use drawPath(src ,string typed by user)
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
    public void drawPath(PlaceName[] landmarks) {
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
    }

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
        }
        else {
            theOverlay.setImage(theBitmap);
        }
    }

    // Show floor 1
    public void clickFloor1(View view) {
        showFloor(1);
    }

    // Show floor 2
    public void clickFloor2(View view) {
        showFloor(2);
    }

    // Show floor 3
    public void clickFloor3(View view) {
        showFloor(3);
    }

    // Show floor 4
    public void clickFloor4(View view) {
        showFloor(4);
    }

    // Load emergency layout
    public void clickEmergency(View view) {
        Intent emergencyActivity = new Intent(MapsActivity.this, EmergencyActivity.class);
        startActivity(emergencyActivity);
    }
}