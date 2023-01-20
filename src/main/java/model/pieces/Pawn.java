package model.pieces;

import lombok.Getter;
import lombok.Setter;
import model.Board;
import model.Coordinates;
import model.Field;
import model.enums.Color;
import model.enums.PieceValue;

import java.util.List;

@Getter
@Setter
public class Pawn extends Piece {

    private static final PieceValue VALUE = PieceValue.PAWN;
    //TODO: add Promote() method
    private boolean haveIMoved = false;

    public Pawn(Coordinates currentPos, Color color, boolean isActive) {
        super(currentPos, color, VALUE, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        //TODO: implement method body
        return board.getBOARD_AS_LIST();
    }
}
