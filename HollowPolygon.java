// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// August 2021

import java.awt.*;

// Class that defines all hollow polygons

class HollowPolygon extends Polygon_ {

    // Constructor that calls super constructor

    public HollowPolygon(Color color, int vertexCount) {
        super(color, vertexCount);
    }

    // Draws hollow polygon

    @Override
    public void drawPolygon(Graphics graphics, Polygon polygon) {
        graphics.drawPolygon(polygon);
    }
}
