package utils;

import model.Board;
import model.Coordinates;
import model.enums.Color;
import model.enums.PieceValue;

public class BoardFactory {

    private BoardFactory() {}

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 7;
    public static Board getBoard(String testPreset){
        Board board = new Board(START_INDEX, END_INDEX);
        if ("emptyBoard".equals(testPreset)){
            return board;
        }
        if("KingAtTopLeftCorner".equals(testPreset)){
            board.upsertPiece(Color.WHITE, new Coordinates(0, 7), PieceValue.KING);
            return board;
        }
        return null;
    }
}
