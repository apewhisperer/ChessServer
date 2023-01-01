package utils;

import model.Coordinates;
import model.enums.Color;
import model.pieces.King;
import model.pieces.Piece;

public class PieceFactory {

    //TODO: add missing models

    public static Piece getPiece(Color color, Coordinates coords){
        return new King(coords,color,true);
    }
}
