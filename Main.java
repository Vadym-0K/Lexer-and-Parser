// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// August 2021

import java.io.*;
import java.util.*;
import javax.swing.*;

// Project 1 main class

class Main {

    // The main method of the whole program, allows the name of the scene definition
    // file to be input on the
    // command line or selected using the file chooser dialog window. It calls the
    // parser to parse the scene
    // definition file and add the graphic objects to the scene.

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String sceneFileName;
        File sceneFile;
        Scene scene;
        JFileChooser choice = new JFileChooser(new File("."));
        int option = choice.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION)
            sceneFile = choice.getSelectedFile();
        else {
            System.out.print("Enter scene file name or a single space to choose file from window: ");
            sceneFileName = stdin.nextLine();
            sceneFile = new File(sceneFileName);
        }
        try {
            Parser parser = new Parser(sceneFile);
            scene = parser.parseScene();
            scene.draw();
        } catch (SyntaxError error) {
            System.out.println(error.getMessage());
        } catch (LexicalError error) {
            System.out.println(error.getMessage());
        } catch (IOException error) {
            System.out.println("IO Error");
        }
        stdin.close();
    }
}
