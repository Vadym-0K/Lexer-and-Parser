//Vadym Kharchenko
//September 8, 2024
//Project 1
//Class that defines a filled isosceles trinagle.

import java.awt.*;

public class IsoscelesTriangle extends SolidPolygon {
    // Constructor
    public IsoscelesTriangle(Color color, Point vertex, int height, int width) {
        super(color, 3);
        int[] x_pts = {
                vertex.x - width / 2,
                vertex.x + width / 2,
                vertex.x
        };
        int[] y_pts = {
                vertex.y + height,
                vertex.y + height,
                vertex.y
        };
        createPolygon(x_pts, y_pts);
    }
}
