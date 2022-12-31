package utils;

import model.Board;

public class BoardFactory {

    private final static int START_INDEX = 0;
    private final static int END_INDEX = 7;
    public static Board getBoard(String testPreset){
        Board board = new Board(START_INDEX, END_INDEX);
        if (testPreset == "emptyBoard"){
            return board;
        }
        return null;
    }
}
