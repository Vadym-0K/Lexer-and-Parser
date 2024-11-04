
//Vadym Kharchenko
//September 8, 2024
//Project 1
//Class that defines a filled regular polygon.
import java.awt.*;

public class RegularPolygon extends SolidPolygon {
    // Constructor
    public RegularPolygon(Color color, Point center, int sides, int rad) {
        super(color, sides);
        int[] x_points = new int[sides];
        int[] y_points = new int[sides];
        for (int i = 0; i < sides; i++) {
            x_points[i] = center.x + (int) (rad * Math.cos(2 * Math.PI * i / sides));
            y_points[i] = center.y + (int) (rad * Math.sin(2 * Math.PI * i / sides));
        }
        createPolygon(x_points, y_points);
    }
}