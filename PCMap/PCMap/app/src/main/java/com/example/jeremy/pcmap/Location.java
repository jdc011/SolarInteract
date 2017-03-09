package com.example.jeremy.pcmap;

/**
 * Created by jmich_000 on 3/7/2017.
 */

// ================================
// TODO: move Location and Coordinate
// to other package (?)

// Probably will use a different variable and/or class to store the other location
// information (eg what kind of location it is, what level it's on, etc.
// ================================

public class Location {
    // Coordinate stores 4 double values:
    Coordinate coord;
    // lat,lon are the marker locations
    double lat, lng;
    // level ranges between 1 and 4
    int level;
    // name of the location
    String name;
    // opening and closing times
    String open, close;

    public Location(String locationName, String locationType,
                    double latitude, double longitude, int level, String open, String close){
        name = locationName;
        this.level = level;
        lat = latitude;
        lng = longitude;
        this.open = open;
        this.close = close;
    }

    public void addCoord(double x1, double x2, double y1, double y2){
        coord = new Coordinate(x1, x2, y1, y2);
    }

    // TODO: work on the following methods and add more similar methods
    // TODO: also add icons related to each of the below methods

    public boolean hasTrashCan(){
        return false;
    }

    public boolean hasBottleFiller(){
        return false;
    }

    public boolean hasChargingStation(){
        return true;
    }

    public boolean hasATM(){
        return false;
    }

    public boolean hasComputer(){
        return false;
    }

    public boolean isBathroom(){
        return false;
    }

    public boolean isSittingArea(){
        return true;
    }

    public boolean isElevator(){
        return false;
    }

    public boolean isStairs(){
        return false;
    }

}
