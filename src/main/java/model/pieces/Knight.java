package model.pieces;

import lombok.Getter;
import lombok.Setter;
import model.Board;
import model.Coordinates;
import model.Field;
import model.enums.Color;
import model.enums.PieceValue;
import utils.MoveUtils;
import utils.StreamUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Knight extends Piece {

    private static final PieceValue VALUE = PieceValue.KNIGHT;

    public Knight(Coordinates currentPos, Color color, boolean isActive) {
        super(currentPos, color, VALUE, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        List<Field> possibleTakes = board.getBOARD_AS_LIST();
        return possibleTakes.stream()
                .filter(field -> (MoveUtils.isFieldInKnightRange(field.getCoords(), getCurrentPos())
                        && (field.getPiece() == null || (field.getPiece().getColor() != this.getColor()))))
                .toList();
    }
}
