
//Vadym Kharchenko
//September 8, 2024
//Project 1
//Class that defines a filled parallelogram.
import java.awt.*;

public class Parallelogram extends SolidPolygon {
    // Constructor
    public Parallelogram(Color color, Point topLeft, Point botRight, int offset) {
        super(color, 4);
        int[] x_points = {
                topLeft.x,
                botRight.x,
                botRight.x + offset,
                topLeft.x + offset
        };
        int[] y_points = {
                topLeft.y,
                topLeft.y,
                botRight.y,
                botRight.y
        };
        createPolygon(x_points, y_points);
    }
}