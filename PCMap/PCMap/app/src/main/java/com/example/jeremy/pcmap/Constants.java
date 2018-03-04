package com.example.jeremy.pcmap;

import com.google.android.gms.games.internal.constants.ParticipantLeaveReason;
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
    public final String[] LANDMARKS = new String[]{"Subway", "Santorini", "Sunshine Market", "Starbucks",
                                                    "SRC", "Rubios", "Price Theater",
                                                    "Panda Express", "Bombay Coast", "Burger King",
                                                    "Chase Bank", "Lemongrass", "Perks Coffee Shop",
                                                    "Jamba Juice", "The Zone", "Box Office",
                                                    "Round Table Pizza", "Commuter Kitchen", "UCSD Police",
                                                    "ACCB", "ACTA", "Lounge", "Study Rooms", "Computer Lab",
                                                    "Lockers", "Seed + Sprout",

                                                    "Shogun", "Arcade Room", "The Loft", "Roosevelt College Room",
                                                    "Zanzibar Cafe",  "Sun God Lounge", "Marshall College Room",
                                                    "Cross Cultural Center", "Revelle College Room",
                                                    "Muir College Room", "Inter-tribal Resource Center",
                                                    "Student Organization Offices Flr 2", "Green Room",
                                                    "Lactation Room", "Ballroom West A", "Ballroom West B",
                                                    "Ballroom East", "Game Room", "Dance Studio",
                                                    "S.P.A.C.E.", "Red Shoe Room", "Bear Room", "Kaplan Test Prep",
                                                    "Green Table Room", "Saloon 101", "Art Space",
                                                    "Communidad",

                                                    "Student Organization Offices Floor 3", "Warren College Room",
                                                    "University Centers Administration", "One Stop", "Sixth Room",
                                                    "A.S. Volunteer Connection", "A.S. Graphic Studio", "Alumni Affairs",
                                                    "Student Life Business Operations", "University Centers Event Services",
                                                    "Center for Communication and Leadership Development", "Center for Student Involvement",

                                                    "The Forum", "Student Leadership Chambers", "Associated Students",
                                                    "University Events Office", "Senate Chambers", "AVC Student Life",
                                                    "Graduate Student Association", "Governance Chambers"};

    // Map of coordinates for each place in PC
    public final HashMap<PlaceName, LatLng> LOCATIONS = new HashMap<PlaceName, LatLng>();

    {
        LOCATIONS.put(PlaceName.SRC, new LatLng(32.879899, -117.237257));
        LOCATIONS.put(PlaceName.Santorini, new LatLng(32.879766, -117.235767));
        LOCATIONS.put(PlaceName.SunshineMarket, new LatLng(32.879535, -117.236054));
        LOCATIONS.put(PlaceName.Subway, new LatLng(32.879926, -117.236527));
        LOCATIONS.put(PlaceName.Starbucks, new LatLng(32.880110, -117.236405));
        LOCATIONS.put(PlaceName.Rubios, new LatLng(32.879849, -117.236468));
        LOCATIONS.put(PlaceName.PandaExpress, new LatLng(32.879713, -117.236563));
        LOCATIONS.put(PlaceName.BombayCoast, new LatLng(32.879900, -117.236197));
        LOCATIONS.put(PlaceName.BurgerKing, new LatLng(32.879869, -117.235738));
        LOCATIONS.put(PlaceName.ChaseBank, new LatLng(32.879778, -117.235922));
        LOCATIONS.put(PlaceName.Lemongrass, new LatLng(32.879772, -117.236474));
        LOCATIONS.put(PlaceName.PriceTheater, new LatLng(32.879909, -117.237113));
        LOCATIONS.put(PlaceName.PerksCoffee, new LatLng(32.879344, -117.237294));
        LOCATIONS.put(PlaceName.TapiocaExpress, new LatLng(32.879637, -117.235689));
        LOCATIONS.put(PlaceName.Bookstore, new LatLng(32.879441, -117.236938));
        LOCATIONS.put(PlaceName.Jamba, new LatLng(32.87993, -117.23683));
        LOCATIONS.put(PlaceName.Zone, new LatLng(32.87993, -117.23689));
        LOCATIONS.put(PlaceName.BoxOffice, new LatLng(32.87993, -117.23696));
        LOCATIONS.put(PlaceName.RoundTablePizza, new LatLng(32.88, -117.23679));
        LOCATIONS.put(PlaceName.CommuterKitchen, new LatLng(32.88006, -117.23601));
        LOCATIONS.put(PlaceName.UCSDPolice, new LatLng(32.87998, -117.23599));
        LOCATIONS.put(PlaceName.ACCB, new LatLng(32.8801, -117.23602));
        LOCATIONS.put(PlaceName.ACTA, new LatLng(32.8801, -117.23602));
        LOCATIONS.put(PlaceName.Lounge, new LatLng(32.88011, -117.23607));
        LOCATIONS.put(PlaceName.StudyRooms, new LatLng(32.88005, -117.23612));
        LOCATIONS.put(PlaceName.ComputerLab, new LatLng(32.88005, -117.23612));
        LOCATIONS.put(PlaceName.Lockers, new LatLng(32.88007, -117.23617));
        LOCATIONS.put(PlaceName.SeedSprout, new LatLng(32.87964, -117.23587));

        LOCATIONS.put(PlaceName.SPACE, new LatLng(32.87998, -117.23645));
        LOCATIONS.put(PlaceName.Shogun, new LatLng(32.880007, -117.236906));
        LOCATIONS.put(PlaceName.Arcade, new LatLng(32.880071, -117.237384));
        LOCATIONS.put(PlaceName.SunGodLounge, new LatLng(32.880030, -117.237138));
        LOCATIONS.put(PlaceName.TheLoft, new LatLng(32.879560, -117.235941));
        LOCATIONS.put(PlaceName.ZanzibarCafe, new LatLng(32.879560, -117.235941));
        LOCATIONS.put(PlaceName.CrossCulturalCenter, new LatLng(32.879679, -117.236018));
        LOCATIONS.put(PlaceName.ERCRoom, new LatLng(32.879915, -117.236392));
        LOCATIONS.put(PlaceName.MarshalRoom, new LatLng(32.879857, -117.236389));
        LOCATIONS.put(PlaceName.RevelleRoom, new LatLng(32.879792, 117.23638));
        LOCATIONS.put(PlaceName.MuirRoom, new LatLng(32.879744, -117.236104));
        LOCATIONS.put(PlaceName.InterTribalRC, new LatLng(32.879843, -117.236486));
        LOCATIONS.put(PlaceName.StudOrg2, new LatLng(32.8798, -117.23651));
        LOCATIONS.put(PlaceName.GreenRoom, new LatLng(32.8794, -117.23678));
        LOCATIONS.put(PlaceName.LactationRoom, new LatLng(32.8794, -117.23678));
        LOCATIONS.put(PlaceName.BallroomWestA, new LatLng(32.87954, -117.23651));
        LOCATIONS.put(PlaceName.BallroomWestB, new LatLng(32.87939, -117.23649));
        LOCATIONS.put(PlaceName.BallroomEast, new LatLng(32.87986, -117.23597));
        LOCATIONS.put(PlaceName.RedShoeRoom, new LatLng(32.87993, -117.23722));
        LOCATIONS.put(PlaceName.IntersectionEast, new LatLng(32.879765, -117.236298));
        LOCATIONS.put(PlaceName.IntersectionWest, new LatLng(32.879751, -117.236709));
        LOCATIONS.put(PlaceName.BearRoom, new LatLng(32.88001, -117.23722));
        LOCATIONS.put(PlaceName.Kaplan, new LatLng(32.88, -117.2374));
        LOCATIONS.put(PlaceName.GreenTableRoom, new LatLng(32.88007, -117.23703));
        LOCATIONS.put(PlaceName.Saloon101, new LatLng(32.87956, -117.23615));
        LOCATIONS.put(PlaceName.ArtSpace, new LatLng(32.87977, -117.23564));
        LOCATIONS.put(PlaceName.Communidad, new LatLng(32.87997, -117.23571));
        LOCATIONS.put(PlaceName.DanceStudio, new LatLng(32.88007, -117.23599));
        LOCATIONS.put(PlaceName.GameRoom, new LatLng(32.88007, -117.23675));

        LOCATIONS.put(PlaceName.StudOrg3, new LatLng(32.87966, -117.23626));
        LOCATIONS.put(PlaceName.WarrenRoom, new LatLng(32.87989, -117.2364));
        LOCATIONS.put(PlaceName.UniCenAdmin, new LatLng(32.87986, -117.23651));
        LOCATIONS.put(PlaceName.OneStop, new LatLng(32.87983, -117.23576));
        LOCATIONS.put(PlaceName.SixthRoom, new LatLng(32.87966, -117.23578));
        LOCATIONS.put(PlaceName.ASVolCon, new LatLng(32.87966, -117.23584));
        LOCATIONS.put(PlaceName.ASGraphStudio, new LatLng(32.87992, -117.23576));
        LOCATIONS.put(PlaceName.AlumniAffairs, new LatLng(32.8795, -117.23582));
        LOCATIONS.put(PlaceName.StudLifeBusiOps, new LatLng(32.87961, -117.23558));
        LOCATIONS.put(PlaceName.UniCenEveSer, new LatLng(32.87976, -117.2356));
        LOCATIONS.put(PlaceName.CenCommLead, new LatLng(32.87995, -117.23563));
        LOCATIONS.put(PlaceName.CenStudInvol, new LatLng(32.88, -117.23566));

        LOCATIONS.put(PlaceName.Forum, new LatLng(32.8795, -117.23589));
        LOCATIONS.put(PlaceName.GovCham, new LatLng(32.87967, -117.2358));
        LOCATIONS.put(PlaceName.GradStudAssoc, new LatLng(32.87975, -117.23579));
        LOCATIONS.put(PlaceName.UniEveOff, new LatLng(32.87986, -117.23576));
        LOCATIONS.put(PlaceName.SenateCham, new LatLng(32.88002, -117.23572));
        LOCATIONS.put(PlaceName.AVCStudLife, new LatLng(32.88002, -117.23563));
        LOCATIONS.put(PlaceName.AssocStud, new LatLng(32.87978, -117.23561));
        LOCATIONS.put(PlaceName.StudLeadCham, new LatLng(32.87957, -117.23558));

        LOCATIONS.put(PlaceName.StairFlr1W, new LatLng(32.87976, -117.23716));
        LOCATIONS.put(PlaceName.StairFlr2W, new LatLng(32.87976, -117.23716));

        LOCATIONS.put(PlaceName.StairFlr1SE, new LatLng(32.87966, -117.23675));
        LOCATIONS.put(PlaceName.StairFlr2SE, new LatLng(32.87966, -117.23675));

        LOCATIONS.put(PlaceName.StairFlr1E, new LatLng(32.87989, -117.23668));
        LOCATIONS.put(PlaceName.StairFlr2E, new LatLng(32.87989, -117.23668));
        LOCATIONS.put(PlaceName.StairFlr3E, new LatLng(32.87989, -117.23668));

        LOCATIONS.put(PlaceName.OutElev1, new LatLng(32.87989, -117.23668));
        LOCATIONS.put(PlaceName.OutElev2, new LatLng(32.87989, -117.23668));
        LOCATIONS.put(PlaceName.OutElev3, new LatLng(32.87989, -117.23668));

        LOCATIONS.put(PlaceName.InElev1, new LatLng(32.87984, -117.23568));
        LOCATIONS.put(PlaceName.InElev2, new LatLng(32.87984, -117.23568));
        LOCATIONS.put(PlaceName.InElev3, new LatLng(32.87984, -117.23568));
        LOCATIONS.put(PlaceName.InElev4, new LatLng(32.87984, -117.23568));
    }

    // Map of floors for each place in PC
    public final HashMap<PlaceName, Integer> FLOORS = new HashMap<PlaceName, Integer>();
    {
        FLOORS.put(PlaceName.SRC, 1);
        FLOORS.put(PlaceName.Santorini, 1);
        FLOORS.put(PlaceName.SunshineMarket, 1);
        FLOORS.put(PlaceName.Subway, 1);
        FLOORS.put(PlaceName.Starbucks, 1);
        FLOORS.put(PlaceName.Rubios, 1);
        FLOORS.put(PlaceName.PandaExpress, 1);
        FLOORS.put(PlaceName.BombayCoast, 1);
        FLOORS.put(PlaceName.BurgerKing, 1);
        FLOORS.put(PlaceName.ChaseBank, 1);
        FLOORS.put(PlaceName.Lemongrass, 1);
        FLOORS.put(PlaceName.PriceTheater, 1);
        FLOORS.put(PlaceName.SunGodLounge, 1);
        FLOORS.put(PlaceName.PerksCoffee, 1);
        FLOORS.put(PlaceName.TapiocaExpress, 1);
        FLOORS.put(PlaceName.Bookstore, 1);

        FLOORS.put(PlaceName.Shogun, 2);
        FLOORS.put(PlaceName.Arcade, 2);
        FLOORS.put(PlaceName.TheLoft, 2);
        FLOORS.put(PlaceName.ZanzibarCafe, 2);
        FLOORS.put(PlaceName.CrossCulturalCenter, 2);

        FLOORS.put(PlaceName.IntersectionEast, 1);
        FLOORS.put(PlaceName.IntersectionWest, 1);
    }

    // Map of places and previous places for purposes of making more intelligent paths (Floor 1)
    public final HashMap<PlaceName, PlaceName> PREVIOUS1 = new HashMap<PlaceName, PlaceName>();
    {
        PREVIOUS1.put(PlaceName.Santorini, PlaceName.IntersectionEast);
        PREVIOUS1.put(PlaceName.SunshineMarket, PlaceName.IntersectionEast);
        PREVIOUS1.put(PlaceName.Subway, PlaceName.IntersectionWest);
        PREVIOUS1.put(PlaceName.Starbucks, PlaceName.IntersectionWest);
        PREVIOUS1.put(PlaceName.Rubios, PlaceName.IntersectionWest);
        PREVIOUS1.put(PlaceName.PandaExpress, PlaceName.IntersectionWest);
        PREVIOUS1.put(PlaceName.BombayCoast, PlaceName.IntersectionEast);
        PREVIOUS1.put(PlaceName.BurgerKing, PlaceName.IntersectionEast);
        PREVIOUS1.put(PlaceName.ChaseBank, PlaceName.IntersectionEast);
        PREVIOUS1.put(PlaceName.Lemongrass, PlaceName.IntersectionWest);
        PREVIOUS1.put(PlaceName.PriceTheater, PlaceName.SRC);
        PREVIOUS1.put(PlaceName.PerksCoffee, PlaceName.SRC);
        PREVIOUS1.put(PlaceName.TapiocaExpress, PlaceName.IntersectionEast);
        PREVIOUS1.put(PlaceName.Bookstore, PlaceName.SRC);

        PREVIOUS1.put(PlaceName.IntersectionEast, PlaceName.IntersectionWest);
        PREVIOUS1.put(PlaceName.IntersectionWest, PlaceName.SRC);

        PREVIOUS1.put(PlaceName.SRC, null);
    }

    // Map of places and previous places for purposes of making more intelligent paths (Floor 2)
    public final HashMap<PlaceName, PlaceName> PREVIOUS2 = new HashMap<PlaceName, PlaceName>();
    {
        PREVIOUS2.put(PlaceName.Arcade, PlaceName.SRC);
    }

    // Map of places and previous places for purposes of making more intelligent paths (Floor 3)
    public final HashMap<PlaceName, PlaceName> PREVIOUS3 = new HashMap<PlaceName, PlaceName>();
    {

    }

    // Map of places and previous places for purposes of making more intelligent paths (Floor 4)
    public final HashMap<PlaceName, PlaceName> PREVIOUS4 = new HashMap<PlaceName, PlaceName>();
    {

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
        enumHash.put("burger king", PlaceName.BurgerKing);
        enumHash.put("chase bank", PlaceName.ChaseBank);
        enumHash.put("bombay coast", PlaceName.BombayCoast);
        enumHash.put("panda express", PlaceName.PandaExpress);
        enumHash.put("perks coffee shop", PlaceName.PerksCoffee);
        enumHash.put("price theater", PlaceName.PriceTheater);
        enumHash.put("jamba juice", PlaceName.Jamba);
        enumHash.put("the zone", PlaceName.Zone);
        enumHash.put("box office", PlaceName.BoxOffice);
        enumHash.put("round table pizza", PlaceName.RoundTablePizza);
        enumHash.put("commuter kitchen", PlaceName.CommuterKitchen);
        enumHash.put("ucsd police", PlaceName.UCSDPolice);
        enumHash.put("accb", PlaceName.ACCB);
        enumHash.put("acta", PlaceName.ACTA);
        enumHash.put("lounge", PlaceName.Lounge);
        enumHash.put("study rooms", PlaceName.StudyRooms);
        enumHash.put("computer lab", PlaceName.ComputerLab);
        enumHash.put("lockers", PlaceName.Lockers);
        enumHash.put("seed + sprout", PlaceName.SeedSprout);

        enumHash.put("the loft", PlaceName.TheLoft);
        enumHash.put("zanzibar cafe", PlaceName.ZanzibarCafe);
        enumHash.put("cross cultural center", PlaceName.CrossCulturalCenter);
        enumHash.put("arcade room", PlaceName.Arcade);
        enumHash.put("shogun", PlaceName.Shogun);
        enumHash.put("sun god lounge", PlaceName.SunGodLounge);
        enumHash.put("roosevelt college room", PlaceName.ERCRoom);
        enumHash.put("marshall college room", PlaceName.MarshalRoom);
        enumHash.put("revelle college room", PlaceName.RevelleRoom);
        enumHash.put("muir College Room", PlaceName.MuirRoom);
        enumHash.put("inter-tribal resource center", PlaceName.InterTribalRC);
        enumHash.put("student organization offices flr 2", PlaceName.StudOrg2);
        enumHash.put("green room", PlaceName.GreenRoom);
        enumHash.put("lactation room", PlaceName.LactationRoom);
        enumHash.put("ballroom west a", PlaceName.BallroomWestA);
        enumHash.put("ballroom west b", PlaceName.BallroomWestB);
        enumHash.put("ballroom east", PlaceName.BallroomEast);
        enumHash.put("game room", PlaceName.GameRoom);
        enumHash.put("dance studio", PlaceName.DanceStudio);
        enumHash.put("s.p.a.c.e.", PlaceName.SPACE);
        enumHash.put("red shoe room", PlaceName.RedShoeRoom);
        enumHash.put("bear room", PlaceName.BearRoom);
        enumHash.put("kaplan test prep", PlaceName.Kaplan);
        enumHash.put("green table room", PlaceName.GreenTableRoom);
        enumHash.put("saloon 101", PlaceName.Saloon101);
        enumHash.put("art space", PlaceName.ArtSpace);
        enumHash.put("communidad", PlaceName.Communidad);

        enumHash.put("student organization offices floor 3", PlaceName.StudOrg3);
        enumHash.put("warren college room", PlaceName.WarrenRoom);
        enumHash.put("university centers administration", PlaceName.UniCenAdmin);
        enumHash.put("one stop", PlaceName.OneStop);
        enumHash.put("sixth room", PlaceName.SixthRoom);
        enumHash.put("a.s. volunteer connection", PlaceName.ASVolCon);
        enumHash.put("a.s. graphic studio", PlaceName.ASGraphStudio);
        enumHash.put("alumni affairs", PlaceName.AlumniAffairs);
        enumHash.put("student life business operations", PlaceName.StudLifeBusiOps);
        enumHash.put("university centers event services", PlaceName.UniCenEveSer);
        enumHash.put("center for communication and leadership development", PlaceName.CenCommLead);
        enumHash.put("center for student involvement", PlaceName.CenStudInvol);

        enumHash.put("the forum", PlaceName.Forum);
        enumHash.put("student leadership chambers", PlaceName.StudLeadCham);
        enumHash.put("associated students", PlaceName.AssocStud);
        enumHash.put("university events office", PlaceName.UniEveOff);
        enumHash.put("senate chambers", PlaceName.SenateCham);
        enumHash.put("avc student life", PlaceName.AVCStudLife);
        enumHash.put("graduate student association", PlaceName.GradStudAssoc);
        enumHash.put("governance chambers", PlaceName.GovCham);
    }

    // Return enumerated result
    public PlaceName toEnum(String s) {
        return enumHash.get(s);
    }

    // get path from src to given place
    public ArrayList<PlaceName> getPath(PlaceName p, int floor) {
        ArrayList<PlaceName> a;

        // Get path given floor
        switch (floor) {
            // Default to floor 1
            default: {
                if (PREVIOUS1.get(p) == null) {
                    a = new ArrayList<PlaceName>();
                } else {
                    a = getPath(PREVIOUS1.get(p), floor);
                }
                a.add(p);
                return a;
            }

            // Floor 2
            case 2: {
                if (PREVIOUS2.get(p) == null) {
                    a = new ArrayList<PlaceName>();
                } else {
                    a = getPath(PREVIOUS2.get(p), floor);
                }
                a.add(p);
                return a;
            }

            // Floor 3
            case 3: {
                if (PREVIOUS3.get(p) == null) {
                    a = new ArrayList<PlaceName>();
                } else {
                    a = getPath(PREVIOUS3.get(p), floor);
                }
                a.add(p);
                return a;
            }

            // Floor 4
            case 4: {
                if (PREVIOUS4.get(p) == null) {
                    a = new ArrayList<PlaceName>();
                } else {
                    a = getPath(PREVIOUS4.get(p), floor);
                }
                a.add(p);
                return a;
            }
        }
    }
}