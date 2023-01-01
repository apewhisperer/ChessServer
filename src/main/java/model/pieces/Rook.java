package model.pieces;

import lombok.Getter;
import lombok.Setter;
import model.Board;
import model.Coordinates;
import model.Field;
import model.enums.Color;
import model.enums.PieceValue;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Rook extends Piece {

    public Rook(Coordinates currentPos, Color color, PieceValue pieceValue, boolean isActive) {
        super(currentPos, color, pieceValue, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        //TODO: implement method body
        return new ArrayList<>();
    }
}
