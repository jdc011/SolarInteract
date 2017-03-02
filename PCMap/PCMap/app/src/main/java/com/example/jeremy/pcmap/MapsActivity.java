package com.example.jeremy.pcmap;

        import android.os.Bundle;
        import android.support.v4.app.FragmentActivity;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.GroundOverlayOptions;
        import com.google.android.gms.maps.model.LatLngBounds;
        import android.view.View;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    // Google map API
    private GoogleMap mMap;

    @Override
    // Display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
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
    }

    // Show floor 1
    public void clickFloor1(View view) {
        // TODO: remove components from map not included in floor 1 if present

        // Create constants object
        Constants con = new Constants();

        // Form PC floor plan
        GroundOverlayOptions PCOverlay = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.pclvl1))
                .positionFromBounds(new LatLngBounds(new LatLng(con.X1_POS, con.Y1_POS), new LatLng(con.X2_POS, con.Y2_POS)));

        // Add PC floor plan to map
        mMap.addGroundOverlay(PCOverlay);
    }

    // Show floor 2
    public void clickFloor2(View view) {
        // TODO: remove components from map not included in floor 2 if present

        // Create constants object
        Constants con = new Constants();

        // Form PC floor plan
        GroundOverlayOptions PCOverlay = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.pclvl2))
                .positionFromBounds(new LatLngBounds(new LatLng(con.X1_POS, con.Y1_POS), new LatLng(con.X2_POS, con.Y2_POS)));

        // Add PC floor plan to map
        mMap.addGroundOverlay(PCOverlay);
    }

    // Show floor 3
    public void clickFloor3(View view) {
        // TODO: remove components from map not included in floor 3 if present

        // Create constants object
        Constants con = new Constants();

        // Form PC floor plan
        GroundOverlayOptions PCOverlay = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.pclvl3))
                .positionFromBounds(new LatLngBounds(new LatLng(con.X1_POS, con.Y1_POS), new LatLng(con.X2_POS, con.Y2_POS)));

        // Add PC floor plan to map
        mMap.addGroundOverlay(PCOverlay);
    }

    // Show floor 4
    public void clickFloor4(View view) {
        // TODO: remove components from map not included in floor 4 if present

        // Create constants object
        Constants con = new Constants();

        // Form PC floor plan
        GroundOverlayOptions PCOverlay = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.pclvl4))
                .positionFromBounds(new LatLngBounds(new LatLng(con.X1_POS, con.Y1_POS), new LatLng(con.X2_POS, con.Y2_POS)));

        // Add PC floor plan to map
        mMap.addGroundOverlay(PCOverlay);
    }
}