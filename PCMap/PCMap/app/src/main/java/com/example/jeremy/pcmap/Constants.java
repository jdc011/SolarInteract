package com.example.jeremy.pcmap;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.HashMap;

/**
 * Created by jeremy on 3/2/17.
 * Contains all constant values.
 */

public class Constants {
    public final double X_SRC = 32.879832;      //SRC x coordinate
    public final double Y_SRC = -117.23723;     // SRC y coordinate
    // Keep the SRC coordinates below for testing purposes
    public final double X1_POS = 32.878933;     // SRC x lower corner
    public final double X2_POS = 32.880461;     // SRC y lower corner
    public final double Y1_POS = -117.237631;   // SRC x upper corner
    public final double Y2_POS = -117.235343;   // SRC Y upper corner

    // Actual floor plan coordinates
    public final LatLngBounds XY_POS = new LatLngBounds(new LatLng(X1_POS, Y1_POS), new LatLng(X2_POS, Y2_POS));
    public final int[] floorplans = {0, R.drawable.pclvl1, R.drawable.pclvl2, R.drawable.pclvl3, R.drawable.pclvl4};

    public final float DEF_ZOOM = 21f;          // Start zoom

    // Text items for autocomplete
    //public final String[] LANDMARKS = new String[]{"Subway", "Santorini", "Sunshine Market", "Shogun", "Starbucks", "SRC"};
    //Edit by Connie: change strings to lowercase
    public final String[] LANDMARKS = new String[]{"subway", "santorini", "sunshine market", "shogun",
                                                    "starbucks", "SRC"};

    // Map of coordinates for each place in PC
    public final HashMap<PlaceName, LatLng> LOCATIONS = new HashMap<PlaceName, LatLng>();

    {
        LOCATIONS.put(PlaceName.SRC, new LatLng(32.879899, -117.237257));
        LOCATIONS.put(PlaceName.Santorini, new LatLng(32.879766, -117.235767));
        LOCATIONS.put(PlaceName.SunshineMarket, new LatLng(32.879535, -117.236054));
    }

    // Map pd names for each place in PC
    private final HashMap<String, PlaceName> enumHash = new HashMap<String, PlaceName>();
    {
        enumHash.put("Santorini", PlaceName.Santorini);
        enumHash.put("SRC", PlaceName.SRC);
        enumHash.put("Sunshine Market", PlaceName.SunshineMarket);
    //Edit by Connie: change strings to lowercase
    private final HashMap<String, PlaceName> enumHash = new HashMap<String, PlaceName>();
    {
        enumHash.put("santorini", PlaceName.Santorini);
        enumHash.put("SRC", PlaceName.SRC);
        enumHash.put("sunshine market", PlaceName.SunshineMarket);
    }

    // Return enumumerated result
    public PlaceName toEnum(String s) {
        return enumHash.get(s);
    }
}

