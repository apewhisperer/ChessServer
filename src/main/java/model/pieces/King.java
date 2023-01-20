package model.pieces;

import lombok.Getter;
import lombok.Setter;
import model.Board;
import model.Coordinates;
import model.Field;
import model.enums.Color;
import model.enums.PieceValue;
import utils.StreamUtils;

import java.util.List;

@Getter
@Setter
public class King extends Piece {

    private static final int RANGE = 1;
    private boolean hasAlreadyCastled = false;
    private static final PieceValue VALUE = PieceValue.KING;

    public King(Coordinates currentPos, Color color, boolean isActive) {
        super(currentPos, color, VALUE, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        List<Field> possibleTakes = board.getBOARD_AS_LIST();
        return possibleTakes.stream()
                .filter(field -> (StreamUtils.isInRange(field.getCoords(), getCurrentPos(), RANGE)
                        && (field.getPiece() == null || (field.getPiece().getColor() != this.getColor()))))
                .toList();
    }
}
