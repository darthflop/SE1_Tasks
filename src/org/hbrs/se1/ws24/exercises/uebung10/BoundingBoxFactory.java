package org.hbrs.se1.ws24.exercises.uebung10;

public class BoundingBoxFactory {

    public static MyPrettyRectangle getBoundingBox(MyPrettyRectangle[] rectangles) {
        if (rectangles == null) {
            // Rückgabe von null bei null-Array
            return null;
        }

        if (rectangles.length == 0) {
            // Rückgabe eines Null-Rechtecks bei leerem Array
            return new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0);
        }

        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;

        for (MyPrettyRectangle rect : rectangles) {
            if (rect == null) continue;
            minX = Math.min(minX, rect.bottomLeft.getX());
            minY = Math.min(minY, rect.bottomLeft.getY());
            maxX = Math.max(maxX, rect.topRight.getX());
            maxY = Math.max(maxY, rect.topRight.getY());
        }

        return new MyPrettyRectangle(minX, minY, maxX, maxY);
    }
}

