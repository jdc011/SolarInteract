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
    // OLD: lat,lon are the marker locations
    // double lat, lng;
    // level ranges between 1 and 4
    int level;
    // name of the location
    String name;
    // opening and closing times
    String open, close;

    // fix the parses, they may be causing the program to crash
    public Location(String rawString){
        String[] splitInfo = rawString.split(",");
        if(splitInfo.length == 7)
            makeLocation(splitInfo[0], splitInfo[1], Double.parseDouble(splitInfo[2]), Double
                        .parseDouble(splitInfo[3]), Integer.parseInt(splitInfo[4]),
                splitInfo[5], splitInfo[6]);
        else
            makeLocation("Null island", "LANDMARK", 0.0, 0.0, 1, "no hours", "no hours");
    }

    public void makeLocation(String locationName, String locationType,
                    double latitude, double longitude, int level, String open, String close){
        name = locationName;
        this.level = level;
        coord = addCoord(latitude, longitude);
        this.open = open;
        this.close = close;
    }

    private Coordinate addCoord(double x, double y){
        return new Coordinate(x, y);
    }

    public Coordinate getCoord(){
        return coord;
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

    public String toString(){
        return "Name of location: " + name + '\n'
                + "Coordinates of location: " + coord + ", at level " + level + '\n'
                + "Times of operation: open " + open + "; closed " + close;
    }
}
