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

@Setter
@Getter
public class Bishop extends Piece {

    private static final PieceValue VALUE = PieceValue.BISHOP;

    public Bishop(Coordinates currentPos, Color color, boolean isActive) {
        super(currentPos, color, VALUE, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        //TODO: implement method body
        return new ArrayList<>();
    }
}
