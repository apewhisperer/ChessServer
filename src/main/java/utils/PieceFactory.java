package utils;

import model.*;
import model.enums.Color;
import model.enums.PieceValue;
import model.pieces.King;
import model.pieces.Piece;

public class PieceFactory {

    //TODO: add missing models

    public static Piece getPiece(PieceValue pieceValue, Color color, Coordinates coords){
        switch (pieceValue){
            case KING:
                return new King(coords,color, pieceValue,true);
            default:
                return null;

        }
    }
}
