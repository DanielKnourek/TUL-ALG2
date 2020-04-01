package cz.tul.knourekdaniel.ALG2;

import java.awt.*;
import java.util.Arrays;

public class Polygon {
    Point[] corners;
    
    Polygon(Point... corners){
        this.corners = corners;
    }

    @Override
    public String toString() {
        String output = "Polygon{" + "corners: ";
        for (int i = 0; i < this.corners.length; i++) {
            output += i + ": [" + corners[i].getX() + ";" + corners[i].getY() + "] ";
        }
        output +='}';
        return output;
    }

    public static double circumference(Polygon p){
        double l = 0;
        for (int i = 0; i < p.corners.length; i++) {
            l += p.corners[i].distTo( p.corners[ (i+1) % p.corners.length] );
        }
        return l;
    }
    public double circumference(){
        return circumference(this);
    }
    public static double area(Polygon p){
        double s = 0;
        for (int i = 0; i < p.corners.length; i++) {
            s += p.corners[i].getX() * p.corners[(i+1) % p.corners.length].getY() - p.corners[(i+1) % p.corners.length].getX() * p.corners[i].getY() ;
        }
        return (Math.abs(s)/2);
    }
    public double area(){
        return area(this);
    }
}
