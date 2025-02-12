package de.jplag;

public class ParserToken extends antlr.Token {
    /**
     * This variable holds the line number of the current token.
     */
    private int _line = -1;

    /**
     * This variable holds the column of the current token in its line.
     */
    private int _column = -1;

    /**
     * This variable holds the label of the current token.
     */
    private String _text = null;

    /**
     * This variable holds the identifier of the current token.
     */

    private int _id = -1;

    public ParserToken() {
        super();
    }

    public ParserToken(int type) {
        super(type);
    }

    public ParserToken(int type, String text) {
        super(type, text);
        setText(text);
    }

    @Override
    public void setLine(int line) {
        _line = line;
    }

    @Override
    public void setColumn(int column) {
        _column = column;
    }

    public void setID(int id) {
        _id = id;
    }

    @Override
    public void setText(String text) {
        _text = (text != null ? text.intern() : null);
    }

    @Override
    public int getColumn() {
        return _column;
    }

    @Override
    public int getLine() {
        return _line;
    }

    @Override
    public String getText() {
        return _text;
    }

    public int getID() {
        return _id;
    }

    public int getLength() {
        return _text.length();
    }

    @Override
    public String toString() {
        return "{\"" + getText() + "\", <" + getType() + ">, " + getLine() + " " + getColumn() + "}";
    }
}
