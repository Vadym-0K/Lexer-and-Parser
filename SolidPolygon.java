//Vadym Kharchenko
//September 8, 2024
//Project 1
//Class that defines a hollow rectangle object

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SolidPolygon extends Polygon_ {

    public SolidPolygon(Color color, int vertexCount) {
        super(color, vertexCount);
    }

    @Override
    public void drawPolygon(Graphics g, Polygon polygon) {
        g.drawPolygon(polygon);
        g.fillPolygon(polygon);
    }
}