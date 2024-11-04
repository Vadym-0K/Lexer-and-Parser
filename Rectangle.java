// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// August 2021

import java.awt.*;

// Class that defines a hollow rectangle object

class Rectangle extends HollowPolygon {

    // Constructor that initializes the vertices of the rectangle

    public Rectangle(Color color, Point upperLeft, int height, int width) {
        super(color, 4);
        int[] x_points = {upperLeft.x, upperLeft.x + width, upperLeft.x + width, upperLeft.x};
        int[] y_points = {upperLeft.y, upperLeft.y, upperLeft.y + height, upperLeft.y + height};
        createPolygon(x_points, y_points);
    }
}
