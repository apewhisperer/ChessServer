package utils.factory;

import model.Board;
import model.Coordinates;
import model.enums.Color;
import model.enums.PieceValue;
import model.pieces.Piece;

import java.util.List;

public class BoardFactory {

    private BoardFactory() {
    }

    private static final int START_INDEX = 0;
    private static final int END_INDEX = 7;

    public static Board getBoard(String testPreset) {
        Board board = new Board(START_INDEX, END_INDEX);
        if ("emptyBoard".equals(testPreset)) {
            return board;
        }
        if ("KingTopLeftCorner".equals(testPreset)) {
            board.upsertPiece(Color.WHITE, new Coordinates(0, 7), PieceValue.KING);
            return board;
        }
        if ("KingBotRightCorner".equals(testPreset)) {
            board.upsertPiece(Color.WHITE, new Coordinates(7, 0), PieceValue.KING);
            return board;
        }
        if ("KingBotMiddle".equals(testPreset)) {
            board.upsertPiece(Color.WHITE, new Coordinates(4, 0), PieceValue.KING);
            return board;
        }
        board = generateBoard(testPreset);
        return board;
    }

    public static Board getBoard(List<Piece> piecesToPlace) {
        Board board = new Board(START_INDEX, END_INDEX);
        for (Piece piece : piecesToPlace){
            board.upsertPiece(piece);
        }
        return board;
    }

    private static Board generateBoard(String piecesToPlace) {
        Board board = new Board(START_INDEX, END_INDEX);
        piecesToPlace = piecesToPlace.toLowerCase();
        String[] piecesSplit = piecesToPlace.split(";");
        for (String pieceData : piecesSplit) {
            String[] data = pieceData.split(",");
            Coordinates coordinates = new Coordinates(Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            Piece piece = PieceFactory.getPiece(data[1], coordinates, data[0]);
            board.upsertPiece(piece);
        }
        return board;
    }

}
