package com.example.jeremy.pcmap;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;
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
    public final String[] LANDMARKS = new String[]{"Subway", "Santorini", "Sunshine Market", "Shogun",
                                                    "Starbucks", "SRC", "Rubios", "Price Theater",
                                                    "Panda Express", "Bombay Coast", "Burger King",
                                                    "Chase Bank", "Lemongrass", "Perks Coffee Shop",
                                                    "Outback Adventures Surf Shop", "The Loft",
                                                    "Zanzibar Cafe", "Postal Center", "Sun God Lounge",
                                                    "Cross Cultural Center"};

    // Map of coordinates for each place in PC
    public final HashMap<PlaceName, LatLng> LOCATIONS = new HashMap<PlaceName, LatLng>();

    {
        LOCATIONS.put(PlaceName.SRC, new LatLng(32.879899, -117.237257));
        LOCATIONS.put(PlaceName.Santorini, new LatLng(32.879766, -117.235767));
        LOCATIONS.put(PlaceName.SunshineMarket, new LatLng(32.879535, -117.236054));
        LOCATIONS.put(PlaceName.Subway, new LatLng(32.879926, -117.236527));
        LOCATIONS.put(PlaceName.Starbucks, new LatLng(32.880110, -117.236405));
        LOCATIONS.put(PlaceName.Rubios, new LatLng(32.879849, -117.236468));
        LOCATIONS.put(PlaceName.Shogun, new LatLng(32.880007, -117.236906));
        LOCATIONS.put(PlaceName.PandaExpress, new LatLng(32.879713, -117.236563));
        LOCATIONS.put(PlaceName.BombayCoast, new LatLng(32.879900, -117.236197));
        LOCATIONS.put(PlaceName.BurgerKing, new LatLng(32.879869, -117.235738));
        LOCATIONS.put(PlaceName.ChaseBank, new LatLng(32.879778, -117.235922));
        LOCATIONS.put(PlaceName.Lemongrass, new LatLng(32.879772, -117.236474));
        LOCATIONS.put(PlaceName.PriceTheater, new LatLng(32.879909, -117.237113));
        LOCATIONS.put(PlaceName.Outback, new LatLng(32.880071, -117.237384));
        LOCATIONS.put(PlaceName.SunGodLounge, new LatLng(32.880030, -117.237138));
        LOCATIONS.put(PlaceName.PerksCoffee, new LatLng(32.879344, -117.237294));
        LOCATIONS.put(PlaceName.PostalCenter, new LatLng(32.879992, -117.235701));
        LOCATIONS.put(PlaceName.TapiocaExpress, new LatLng(32.879637, -117.235689));
        LOCATIONS.put(PlaceName.TheLoft, new LatLng(32.879560, -117.235941));
        LOCATIONS.put(PlaceName.ZanzibarCafe, new LatLng(32.879560, -117.235941));
        LOCATIONS.put(PlaceName.CrossCulturalCenter, new LatLng(32.879679, -117.236018));
        LOCATIONS.put(PlaceName.Bookstore, new LatLng(32.879441, -117.236938));

        LOCATIONS.put(PlaceName.IntersectionEast, new LatLng(32.879765, -117.236298));
        LOCATIONS.put(PlaceName.IntersectionWest, new LatLng(32.879751, -117.236709));
    }

    // Map of places and previous places for purposes of making more intelligent paths
    public final HashMap<PlaceName, PlaceName> PREVIOUS = new HashMap<PlaceName, PlaceName>();
    {
        PREVIOUS.put(PlaceName.Santorini, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.SunshineMarket, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.Subway, PlaceName.IntersectionWest);
        PREVIOUS.put(PlaceName.Starbucks, PlaceName.IntersectionWest);
        PREVIOUS.put(PlaceName.Rubios, PlaceName.IntersectionWest);
        PREVIOUS.put(PlaceName.Shogun, PlaceName.IntersectionWest);
        PREVIOUS.put(PlaceName.PandaExpress, PlaceName.IntersectionWest);
        PREVIOUS.put(PlaceName.BombayCoast, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.BurgerKing, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.ChaseBank, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.Lemongrass, PlaceName.IntersectionWest);
        PREVIOUS.put(PlaceName.PriceTheater, PlaceName.SRC);
        PREVIOUS.put(PlaceName.Outback, PlaceName.SRC);
        PREVIOUS.put(PlaceName.SunGodLounge, PlaceName.SRC);
        PREVIOUS.put(PlaceName.PerksCoffee, PlaceName.SRC);
        PREVIOUS.put(PlaceName.PostalCenter, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.TapiocaExpress, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.TheLoft, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.ZanzibarCafe, PlaceName.IntersectionEast);
        PREVIOUS.put(PlaceName.CrossCulturalCenter, PlaceName.SRC);
        PREVIOUS.put(PlaceName.Bookstore, PlaceName.SRC);

        PREVIOUS.put(PlaceName.IntersectionEast, PlaceName.IntersectionWest);
        PREVIOUS.put(PlaceName.IntersectionWest, PlaceName.SRC);

        PREVIOUS.put(PlaceName.SRC, null);

    }

    // Map pd names for each place in PC
    //Edit by Connie: change strings to lowercase
    private final HashMap<String, PlaceName> enumHash = new HashMap<String, PlaceName>();
    {
        enumHash.put("santorini", PlaceName.Santorini);
        enumHash.put("SRC", PlaceName.SRC);
        enumHash.put("sunshine market", PlaceName.SunshineMarket);
        enumHash.put("subway", PlaceName.Subway);
        enumHash.put("starbucks", PlaceName.Starbucks);
        enumHash.put("rubios", PlaceName.Rubios);
        enumHash.put("lemongrass", PlaceName.Lemongrass);
        enumHash.put("bombay coast", PlaceName.BombayCoast);
        enumHash.put("the loft", PlaceName.TheLoft);
        enumHash.put("zanzibar cafe", PlaceName.ZanzibarCafe);
        enumHash.put("postal center", PlaceName.PostalCenter);
        enumHash.put("burger king", PlaceName.BurgerKing);
        enumHash.put("chase bank", PlaceName.ChaseBank);
        enumHash.put("cross cultural center", PlaceName.CrossCulturalCenter);
        enumHash.put("outback adventures surf shop", PlaceName.Outback);
        enumHash.put("panda express", PlaceName.PandaExpress);
        enumHash.put("perks coffee shop", PlaceName.PerksCoffee);
        enumHash.put("shogun", PlaceName.Shogun);
        enumHash.put("price theater", PlaceName.PriceTheater);
        enumHash.put("sun god lounge", PlaceName.SunGodLounge);
    }

    // Return enumerated result
    public PlaceName toEnum(String s) {
        return enumHash.get(s);
    }

    // get path from src to given place
    public ArrayList<PlaceName> getPath(PlaceName p) {
        ArrayList<PlaceName> a;
        if (PREVIOUS.get(p) == null) {
            a = new ArrayList<PlaceName>();
        }
        else {
            a = getPath(PREVIOUS.get(p));
        }
        a.add(p);
        return a;
    }
}