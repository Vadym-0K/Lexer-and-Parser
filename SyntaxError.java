// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// August 2021

// Class that defines a syntax error

class SyntaxError extends Exception
{
    // Constructor that creates a syntax error object given the line number and error

    public SyntaxError(int line, String description) {
        super("Syntax Error on Line: " + line + " " + description);
    }
}