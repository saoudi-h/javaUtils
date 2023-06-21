package com.saoudi.javaUtils;

import java.util.Objects;

public class Point implements Cloneable{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int n) {
        this.x = n;
        this.y = n;
    }

    @Override
    public String toString() {
        return "Point : {" +
                "x:" + x +
                ", y:" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Point clonedPoint = (Point) super.clone();
        clonedPoint.x = this.x;
        clonedPoint.y = this.y;
        return clonedPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
