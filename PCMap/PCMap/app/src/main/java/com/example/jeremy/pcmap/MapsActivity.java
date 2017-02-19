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

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Zoom buttons
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in PC and move the camera
        LatLng PC = new LatLng(32.879524, -117.236522);
        GroundOverlayOptions PCOverlay = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.pclevel1))
                .positionFromBounds(new LatLngBounds(new LatLng(32.879133, -117.237381), new LatLng(32.880180, -117.235593)));

        // Add PC floor plan to map
        mMap.addGroundOverlay(PCOverlay);

        // Add a marker in PC, UCSD, and move the camera.
        mMap.addMarker(new MarkerOptions().position(PC).title("Marker in PC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PC, 21.0f));
    }
}
