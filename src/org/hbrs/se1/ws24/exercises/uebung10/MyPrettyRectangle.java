package org.hbrs.se1.ws24.exercises.uebung10;

import org.hbrs.se1.ws24.exercises.uebung10.test.MyPoint;

public class MyPrettyRectangle {

    public MyPoint bottomLeft;
    public MyPoint topRight;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.bottomLeft = new MyPoint(Math.min(x1, x2), Math.min(y1, y2));
        this.topRight = new MyPoint(Math.max(x1, x2), Math.max(y1, y2));
    }

    public MyPrettyRectangle(MyPoint bottomLeft, MyPoint topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }


    public boolean contains(MyPrettyRectangle a) {
        return this.bottomLeft.getX() <= a.bottomLeft.getX() &&
                this.bottomLeft.getY() <= a.bottomLeft.getY() &&
                this.topRight.getX() >= a.topRight.getX() &&
                this.topRight.getY() >= a.topRight.getY();
    }

    public MyPoint getCenter() {
        double centerX = (bottomLeft.getX() + topRight.getX()) / 2.0;
        double centerY = (bottomLeft.getY() + topRight.getY()) / 2.0;
        return new MyPoint(centerX, centerY);
    }

    public double getArea() {
        double width = topRight.getX() - bottomLeft.getX();
        double height = topRight.getY() - bottomLeft.getY();
        return width * height;
    }

    public double getPerimeter() {
        double width = topRight.getX() - bottomLeft.getX();
        double height = topRight.getY() - bottomLeft.getY();
        return 2 * (width + height);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyPrettyRectangle other = (MyPrettyRectangle) obj;
        return bottomLeft.equals(other.bottomLeft) && topRight.equals(other.topRight);
    }
}

