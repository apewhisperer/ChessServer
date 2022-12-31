package utils;

import model.Board;

public class BoardFactory {

    private BoardFactory() {}

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 7;
    public static Board getBoard(String testPreset){
        Board board = new Board(START_INDEX, END_INDEX);
        if ("emptyBoard".equals(testPreset)){
            return board;
        }
        return null;
    }
}
