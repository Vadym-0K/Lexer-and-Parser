//Vadym Kharchenko
//September 8, 2024
//Project 1
//This class provides the parser for the expanded grammar

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

class Parser {
    private JFrame window;
    private Token token;
    private Lexer lexer;

    // Constructor to create new lexical analyzer from input file
    public Parser(File file) throws IOException {
        lexer = new Lexer(file);
    }

    // Parses the production
    // scene -> SCENE IDENTIFIER number_list images END '.'
    public Scene parseScene() throws LexicalError, SyntaxError, IOException {
        verifyNextToken(Token.SCENE);
        verifyNextToken(Token.IDENTIFIER);
        String windowName = lexer.getLexeme();
        int[] dimensions = getNumberList(2);
        Scene scene = new Scene(windowName, dimensions[0], dimensions[1]);
        token = lexer.getNextToken();
        parseImages(scene);
        verifyCurrentToken(Token.END);
        verifyNextToken(Token.PERIOD);
        return scene;
    }

    // Parses the images
    private void parseImages(Scene scene) throws LexicalError, SyntaxError, IOException {
        while (token != Token.END) {
            switch (token) {
                case RIGHTTRIANGLE:
                    parseRightTriangle(scene);
                    break;
                case RECTANGLE:
                    parseRectangle(scene);
                    break;
                case PARALLELOGRAM:
                    parseParallelogram(scene);
                    break;
                case REGULARPOLYGON:
                    parseRegularPolygon(scene);
                    break;
                case ISOSCELES:
                    parseIsosceles(scene);
                    break;
                case TEXT:
                    parseText(scene);
                    break;
                default:
                    throw new SyntaxError(lexer.getLineNo(), "Unexpected image type: " + token);
            }
            token = lexer.getNextToken();
        }
    }

    // Parse RightTriangle
    private void parseRightTriangle(Scene scene) throws LexicalError, SyntaxError, IOException {
        Color color = parseColor();
        Point point = parsePoint();
        verifyNextToken(Token.HEIGHT);
        verifyNextToken(Token.NUMBER);
        int height = lexer.getNumber();
        verifyNextToken(Token.WIDTH);
        verifyNextToken(Token.NUMBER);
        int width = lexer.getNumber();
        verifyNextToken(Token.SEMICOLON);

        RightTriangle triangle = new RightTriangle(color, point, height, width);
        scene.addImage(triangle);
    }

    // Parse Rectangle
    private void parseRectangle(Scene scene) throws LexicalError, SyntaxError, IOException {
        Color color = parseColor();
        Point point = parsePoint();
        verifyNextToken(Token.HEIGHT);
        verifyNextToken(Token.NUMBER);
        int height = lexer.getNumber();
        verifyNextToken(Token.WIDTH);
        verifyNextToken(Token.NUMBER);
        int width = lexer.getNumber();
        verifyNextToken(Token.SEMICOLON);

        Rectangle rectangle = new Rectangle(color, point, height, width);
        scene.addImage(rectangle);
    }

    // Parse Parallelogram
    private void parseParallelogram(Scene scene) throws LexicalError, SyntaxError, IOException {
        Color color = parseColor();
        // Parse first point
        Point point1 = parsePoint();
        // Parse second point
        Point point2 = parsePoint();
        verifyNextToken(Token.OFFSET);
        verifyNextToken(Token.NUMBER);
        int offset = lexer.getNumber();
        verifyNextToken(Token.SEMICOLON);

        Parallelogram parallelogram = new Parallelogram(color, point1, point2, offset);
        scene.addImage(parallelogram);
    }

    // Parse RegularPolygon
    private void parseRegularPolygon(Scene scene) throws LexicalError, SyntaxError, IOException {
        Color color = parseColor();
        Point center = parsePoint();
        verifyNextToken(Token.SIDES);
        verifyNextToken(Token.NUMBER);
        int sides = lexer.getNumber();
        verifyNextToken(Token.RADIUS);
        verifyNextToken(Token.NUMBER);
        int radius = lexer.getNumber();
        verifyNextToken(Token.SEMICOLON);

        RegularPolygon polygon = new RegularPolygon(color, center, sides, radius);
        scene.addImage(polygon);
    }

    // Parse Isosceles Triangle
    private void parseIsosceles(Scene scene) throws LexicalError, SyntaxError, IOException {
        Color color = parseColor();
        Point point = parsePoint();
        verifyNextToken(Token.HEIGHT);
        verifyNextToken(Token.NUMBER);
        int height = lexer.getNumber();
        verifyNextToken(Token.WIDTH);
        verifyNextToken(Token.NUMBER);
        int width = lexer.getNumber();
        verifyNextToken(Token.SEMICOLON);

        IsoscelesTriangle triangle = new IsoscelesTriangle(color, point, height, width);
        scene.addImage(triangle);
    }

    // Parse Text
    private void parseText(Scene scene) throws LexicalError, SyntaxError, IOException {
        Color color = parseColor();
        Point point = parsePoint();
        verifyNextToken(Token.STRING);
        String textContent = lexer.getLexeme();
        verifyNextToken(Token.SEMICOLON);

        Text text = new Text(color, point, textContent);
        scene.addImage(text);
    }

    // Helper method to parse Color
    private Color parseColor() throws LexicalError, SyntaxError, IOException {
        verifyNextToken(Token.COLOR);
        int[] rgb = getNumberList(3);
        return new Color(rgb[0], rgb[1], rgb[2]);
    }

    // Helper method to parse Point
    private Point parsePoint() throws LexicalError, SyntaxError, IOException {
        verifyNextToken(Token.AT);
        int[] coordinates = getNumberList(2);
        return new Point(coordinates[0], coordinates[1]);
    }

    // Parses the number list
    private int[] getNumberList(int count) throws LexicalError, SyntaxError, IOException {
        int[] list = new int[count];
        verifyNextToken(Token.LEFTPAREN);
        for (int i = 0; i < count; i++) {
            verifyNextToken(Token.NUMBER);
            list[i] = lexer.getNumber();
            token = lexer.getNextToken();
            if (i < count - 1) {
                verifyCurrentToken(Token.COMMA);
            }
        }
        verifyCurrentToken(Token.RIGHTPAREN);
        return list;
    }

    // Verifies that the next token is the expected token
    private void verifyNextToken(Token expectedToken) throws LexicalError, SyntaxError, IOException {
        token = lexer.getNextToken();
        verifyCurrentToken(expectedToken);
    }

    // Verifies that the current token is the expected token
    private void verifyCurrentToken(Token expectedToken) throws SyntaxError {
        if (token != expectedToken) {
            throw new SyntaxError(lexer.getLineNo(), "Expecting token " + expectedToken + ", found " + token);
        }
    }
}