//Vadym Kharchenko
//September 8, 2024
//Project 1
//This class provides the lexical analyzer for project 1

import java.io.*;

class Lexer {

    private StreamTokenizer tokenizer;
    private String punctuation = ",;.()";
    private Token[] punctuationTokens = {
            Token.COMMA, Token.SEMICOLON, Token.PERIOD, Token.LEFTPAREN, Token.RIGHTPAREN
    };

    // Constructor that creates a lexical analyzer object given the source file
    public Lexer(File file) throws FileNotFoundException {
        tokenizer = new StreamTokenizer(new FileReader(file));
        tokenizer.ordinaryChar('.'); // Treat '.' as ordinary character
        tokenizer.quoteChar('"'); // Handle strings in double quotes
        tokenizer.wordChars('_', '_'); // Include underscore in words (for tokens like RIGHT_TRIANGLE)
    }

    // Returns the next token in the input stream
    public Token getNextToken() throws LexicalError, IOException {
        int token = tokenizer.nextToken();
        Token result;
        switch (token) {
            case StreamTokenizer.TT_NUMBER:
                result = Token.NUMBER;
                break;
            case StreamTokenizer.TT_WORD:
                String word = tokenizer.sval.toUpperCase().replace(" ", "_");
                result = Token.IDENTIFIER;
                for (Token aToken : Token.values()) {
                    if (aToken.name().equals(word)) {
                        result = aToken;
                        break;
                    }
                }
                break;
            case '"':
                result = Token.STRING;
                break;
            case StreamTokenizer.TT_EOF:
                result = Token.EOF;
                break;
            default:
                result = null;
                for (int i = 0; i < punctuation.length(); i++) {
                    if (token == punctuation.charAt(i)) {
                        result = punctuationTokens[i];
                        break;
                    }
                }
                if (result == null) {
                    throw new LexicalError(getLineNo(), "Unrecognized character: " + (char) token);
                }
                break;
        }

        // Add this debug line to print the token and lexeme
        System.out.println("Token: " + result + " | Lexeme: " + getLexeme());

        return result;
    }

    // Returns the lexeme associated with the current token
    public String getLexeme() {
        if (tokenizer.ttype == StreamTokenizer.TT_WORD || tokenizer.ttype == '"') {
            return tokenizer.sval;
        } else {
            return String.valueOf((char) tokenizer.ttype);
        }
    }

    // Returns the numeric value of the current token for numeric tokens
    public int getNumber() {
        return (int) tokenizer.nval;
    }

    // Returns the current line of the input file
    public int getLineNo() {
        return tokenizer.lineno();
    }
}