package com.example.jeremy.pcmap;

import java.util.ArrayList;

/**
 * Created by jmich_000 on 3/7/2017.
 * Contains positional information on all Locations in PC
 * Manages coordinates
 * Stores all coordinates in an ArrayList of type Coordinate
 */

public class Coordinate {
    // Contains all coordinate information
    private static ArrayList<Coordinate> allCoordinates;
    // x1,y1 describe lower left hand corner lat/lng
    // x2,y2 describe upper right hand corner lat/lng
    private double x1, x2, y1, y2;

    /**Constructor
     *
     * @param x1 lower left hand corner latitude
     * @param x2 upper right hand corner latitude
     * @param y1 lower left hand corner longitude
     * @param y2 upper right hand corner longitude
     */
    public Coordinate(double x1, double x2, double y1, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
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
        double[] coordinate = new double[4];

        // assigns arbitrary value (eg allCoordinates.get(0)) to
        coordinate[0] = allCoordinates.get(0).getX1();
        coordinate[1] = allCoordinates.get(0).getX2();
        coordinate[2] = allCoordinates.get(0).getY1();
        coordinate[3] = allCoordinates.get(0).getY2();

        return coordinate;
    }

    public double getX1(){
        return x1;
    }

    public double getX2(){
        return x2;
    }

    public double getY1(){
        return y1;
    }

    public double getY2(){
        return y2;
    }

}
