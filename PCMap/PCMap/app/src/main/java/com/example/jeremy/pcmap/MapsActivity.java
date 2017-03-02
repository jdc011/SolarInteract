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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    // google map API
    private GoogleMap mMap;

    @Override
    // display the app page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    // display components in map
    public void onMapReady(GoogleMap googleMap) {

        // initialize google map API
        mMap = googleMap;

        Constants con = new Constants();

        // Zoom buttons
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in PC and move the camera
        LatLng SRC = new LatLng(con.X_SRC, con.Y_SRC);
        GroundOverlayOptions PCOverlay = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.pclvl1))
                .positionFromBounds(new LatLngBounds(new LatLng(con.X1_POS, con.Y1_POS), new LatLng(con.X2_POS, con.Y2_POS)));

        // Add PC floor plan to map
        mMap.addGroundOverlay(PCOverlay);

        // Add a marker in PC, UCSD, and move the camera.
        mMap.addMarker(new MarkerOptions().position(SRC).title("You are here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SRC, con.DEF_ZOOM));
    }
}