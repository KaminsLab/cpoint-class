package studlab.kaminski;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.lang.Math;
import java.util.*;
import java.util.List;

public class CPoint {
    private double x;
    private double y;

    public CPoint(double x, double y) {
        setX(x);
        setY(y);
    }

    private double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getLengthOfVector(){
        return Math.hypot(x,y);
    }

    public void move(int x, int y){
        setX(this.x + x);
        setY(this.y + y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }

        CPoint cPoint = (CPoint) o;
        return Double.compare(cPoint.x, x) == 0 && Double.compare(cPoint.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "CPoint{ " + x + ", " + y + '}';
    }
}
