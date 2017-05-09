package com.example.jeremy.pcmap;

import java.util.ArrayList;

/**
 * Created by jmich_000 on 3/7/2017.
 * Contains positional information on all Locations in PC
 * Manages coordinates: latitude and longitude
 * Stores all coordinates in an ArrayList of type Coordinate
 */

public class Coordinate {
    // Contains all coordinate information
    private static ArrayList<Coordinate> allCoordinates;
    // x,y describe the latitude and longitude of the Location
    private double x, y;

    /**Constructor
     *
     * @param x latitude
     * @param y longitude
     */
    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
        allCoordinates.add(this);
    }

    /**Retrieves all the coordinates ever created
     *
     * @return the ArrayList containing all coordinates
     */
    public static ArrayList<Coordinate> getAllCoordinates(){
        return allCoordinates;
    }

    /**Uses the <b>location name</b> to retrieve coordinate information
     *
     * @return a double array containing the LLC latitude, URC latitude, LLC longitude, and URC
     * longitude in that order
     */
    public double[] getCoordinates(String name){
        double[] coordinate = new double[2];

        // assigns arbitrary value (eg allCoordinates.get(0)) to
        coordinate[0] = allCoordinates.get(0).getX();
        coordinate[1] = allCoordinates.get(0).getY();

        return coordinate;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String toString(){
        return "x: " + getX() + "; y: " + getY();
    }

}
