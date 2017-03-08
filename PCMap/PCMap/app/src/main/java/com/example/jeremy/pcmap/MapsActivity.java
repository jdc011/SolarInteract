package com.example.jeremy.pcmap;

        import android.graphics.Bitmap;
        import android.os.Bundle;
        import android.support.v4.app.FragmentActivity;

        import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptor;
        import com.google.android.gms.maps.model.GroundOverlay;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.GroundOverlayOptions;
        import com.google.android.gms.maps.model.LatLngBounds;
        import com.google.android.gms.maps.model.Polyline;
        import com.google.android.gms.maps.model.PolylineOptions;

        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;

        import java.util.ArrayList;
        import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    // Google map API
    private GoogleMap mMap;
    private GroundOverlay theOverlay;
    private Polyline theLine;

    @Override
    // Display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);

        // Autocomplete feature in search bar
        Constants con = new Constants();
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, con.LANDMARKS);
        autoCompleteTextView.setAdapter(adapter);
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

        drawPath(new PlaceName[] {PlaceName.SRC, PlaceName.Santorini, PlaceName.SunshineMarket});
    }

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
    }

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
}