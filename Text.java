
//Vadym Kharchenko
//September 8, 2024
//Project 1
//Class that defines a text that goes straight to the image.
import java.awt.*;

public class Text extends Image {
    private Point location;
    private String word;

    // Constructor
    public Text(Color color, Point location, String word) {
        super(color);
        this.location = location;
        this.word = word;
    }

    @Override
    public void draw(Graphics graphics) {
        colorDrawing(graphics);
        graphics.drawString(word, location.x, location.y);
    }
}