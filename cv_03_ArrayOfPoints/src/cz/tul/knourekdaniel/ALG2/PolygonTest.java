package cz.tul.knourekdaniel.ALG2;

public class PolygonTest {

    public static void main(String[] args) {
        Point bodA = new Point(0,0);
        Point bodB = new Point(1,0);
        Point bodC = new Point(0,1);
//        System.out.println(bodA.toString());
//        System.out.println(bodB.toString());
//        System.out.println(Point.dist(bodA, bodB));
//        System.out.println(Point.dist(bodC, bodB));
        Polygon p1 = new Polygon(bodA, bodB, bodC);
        System.out.println(p1.toString());
        System.out.println(p1.circumference());
    }
}
