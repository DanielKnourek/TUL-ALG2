package cz.tul.knourekdaniel.ALG2;

public class Point {
    private double X = 0;
    private double Y = 0;

    public Point(double X, double Y){
        this.X = X;
        this.Y = Y;
    }
//    public Point(int X, int Y){
//        this( (double)X,Y);
//    }
    public double getX() {
        return X;
    }    
    public double getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }

    public static double dist(double x1, double y1, double x2, double y2){
        return Math.sqrt( Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2));
    }
    public static double dist(Point a, Point b){
        return dist(a.X, a.Y, b.X, b.Y);
    }
    public double distTo(Point other){
        return dist(this, other);
    }
    public double distTo(double X, double Y){
        return dist(this.X, this.Y, X, Y);
    }
}
