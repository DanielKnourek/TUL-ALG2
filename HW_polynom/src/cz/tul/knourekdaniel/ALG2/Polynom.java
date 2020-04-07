package cz.tul.knourekdaniel.ALG2;

import java.util.Arrays;

public class Polynom {

    private final double[] coef;

    private Polynom(double[] coef){
        double[] coefTmp = new double[coef.length];
        System.arraycopy(coef, 0, coefTmp, 0, coef.length);
        this.coef = coefTmp;
    }

    //Factory method
    public static Polynom getInstanceAscending(double... coef){
        return new Polynom(coef);
    }
    public static Polynom getInstanceDescending(double...coef){
        double[] coefTmp = new double[coef.length];
        for (int i = coef.length - 1; i >= 0; i--) {
            coefTmp[coef.length -1 -i] = coef[i];
        }
        return new Polynom(coefTmp);
    }

    //Methods
    public int getDegree(){
        return (this.coef.length -1);
    }

    public double getCoefAt(int exponent){
        return this.coef[exponent];
    }

    public double[] getAllCoef(){
        return Arrays.copyOf(this.coef, this.coef.length);
    }

    public Polynom derivate(){
        double[] derCoef = new double[this.coef.length - 1];
        for (int i = 0; i < derCoef.length; i++) {
            derCoef[i] = this.coef[i+1]*(i + 1);
        }
        return new Polynom(derCoef);
    }

    //TODO integrate
    public double integrate(double a, double b){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        StringBuilder polynom = new StringBuilder("Polynom{");
        for (int i = this.coef.length - 1; i >= 0; i--) {

                if (this.coef[i] == 0){
                    continue;
                }
                polynom.append((this.coef[i] > 0) ? " +" : " -");

                polynom.append(Math.abs(this.coef[i])).append("x^").append(i +1);
        }
        return polynom.append("}").toString();
    }
}
