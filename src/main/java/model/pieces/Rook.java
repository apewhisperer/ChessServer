package model.pieces;

import lombok.Getter;
import lombok.Setter;
import model.Board;
import model.Coordinates;
import model.Field;
import model.enums.Color;
import model.enums.PieceValue;
import utils.MoveUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Rook extends Piece {

    private static final PieceValue VALUE = PieceValue.ROOK;

    public Rook(Coordinates currentPos, Color color, boolean isActive) {
        super(currentPos, color, VALUE, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        List<Field> availableFields = new ArrayList<>();
        MoveUtils.findHorizontallyAvailableFields(board, this.getCurrentPos(), availableFields);
        MoveUtils.findVerticallyAvailableFields(board, this.getCurrentPos(), availableFields);
        return availableFields;
    }
}
