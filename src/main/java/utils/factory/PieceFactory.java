package utils.factory;

import model.Coordinates;
import model.enums.*;
import model.pieces.*;

public class PieceFactory {

    public static Piece getPiece(Color color, Coordinates coords, PieceValue value){
        return switch (value) {
            case KING -> new King(coords, color, true);
            case QUEEN -> new Queen(coords, color, true);
            case PAWN -> new Pawn(coords, color, true);
            case KNIGHT -> new Knight(coords, color, true);
            case BISHOP -> new Bishop(coords, color, true);
            case ROOK -> new Rook(coords, color, true);
        };
    }

    public static Piece getPiece(String color, Coordinates coords, String piece){
        Color pieceColor = Color.WHITE;
        if (color.equals("b")) {
            pieceColor = Color.BLACK;
        }
        return switch (piece) {
            case "king" -> new King(coords, pieceColor, true);
            case "queen" -> new Queen(coords, pieceColor, true);
            case "pawn" -> new Pawn(coords, pieceColor, true);
            case "knight" -> new Knight(coords, pieceColor, true);
            case "bishop" -> new Bishop(coords, pieceColor, true);
            case "rook" -> new Rook(coords, pieceColor, true);
            default -> null;
        };
    }
}
