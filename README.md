<p align="center">
<img alt="image" src="project-1.png"/>
</p>

# Lexer and Parser

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [Contact](#contact)

## Overview
**Lexer and Parser** is a Java Swing application designed to provide a graphical user interface (GUI) for evaluating mathematical expressions. This project demonstrates my skills in object-oriented programming, with a focus on building interactive desktop applications using Java Swing. Additionally, it integrates custom parsers and lexers to handle expression inputs, enabling the program to process and evaluate both simple and complex mathematical expressions. The GUI allows users to input expressions, visualize the results, and receive feedback on any syntax errors.

As part of my learning experience, I developed this project for CMSC 330 Advanced Programming Languages to demonstrate skills in managing complex grammar structures, file parsing, and expression evaluation in C++. 

This project serves as a showcase of my ability to:
- Apply object-oriented principles to design a flexible and scalable solution.
- Implement parsers and lexers to break down and evaluate structured input.
- Handle multiple types of expressions and manage program flow efficiently.

## Features
- Object-oriented design for maintainable and extendable code.
- Support for unary, binary, ternary, and quaternary mathematical expressions.
- Grammar and syntax rules for variable assignments and literal evaluations.
- Parser and lexer modules for structured file input handling.
- Customizable input through external files for ease of testing.
- Robust error handling and informative debugging output.

## Installation
1. Clone this repository:
    ```bash
    git clone https://github.com/Vadym-0K/CMSC330.git
    ```
2. Navigate to the project directory:
    ```bash
    cd KharchenkoProject1
    ```
3. Compile the C++ files.

4. Run the program through the scene file
    ```
     input.txt
    ```

## Usage
To use this project:
1. Create a text file containing mathematical expressions following the supported syntax, such as:
    ```
    Scene Polygons (500, 500)
     RightTriangle Color (255, 0, 0) at (50, 30) Height 100 Width 300;
     Rectangle Color (0, 128, 255) at (100, 100) Height 200 Width 100;
     Isosceles Color (255, 0, 0) at (120, 120) Height 100 Width 200;
     Parallelogram Color (0, 0, 255) at (340, 50) (440, 120) Offset 30;
     RegularPolygon Color(255, 0, 255) at (300, 300) Sides 6 Radius 80;
     Text Color(0, 0, 0) at (400, 200) "Hello World";
    End.
    ```

The program will output the scene of graphical images based on the input file provided.

## Project Structure

```
KharchenkoProject1/<br>
│<br>
├── src/                                  # Source code files<br>
│   ├── Project1                          # Main file for parsing and evaluating<br>
│   ├── Parser                            # Parser implementation<br>
│         ├── Lexer                       # Lexer implementation<br>
│         └── SyntaxError                 # Class that defines a syntax error
├── Scene                                 # Class that defines a scene
└──  Image                                # Abstract base class that defines all image objects
        ├── Text                          # Class that defines a text that goes straight to the image.
        └──  Polygon_                     # Abstract base class for all polygon classes
            ├── HollowPolygon             # Class that defines all hollow polygons
                    ├── Right Triangle    # Class that defines a hollow right triangle
                    └── Rectangle         # Class that defines a hollow rectangle object
            └── SolidPolygon              # Class that defines a hollow rectangle object
                    ├── IsoscelesTriangle # Class that defines a filled isosceles trinagle.
                    ├── Parallelogram     # Class that defines a filled parallelogram.
                    └── RegularPolygon    # Class that defines a filled regular polygon.
      
```

## Contributing
Contributions are welcome! Feel free to fork this repository, make your changes, and submit a pull request.


## Contact
If you have any questions or suggestions, feel free to contact me at:  
**Vadym Kharchenko**  
Email: vadym.kharchenko@yahoo.com
