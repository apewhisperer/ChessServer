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

    public King(Coordinates currentPos, Color color, PieceValue value, boolean isActive) {
        super(currentPos, color, value, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        List<Field> possibleTakes = board.getBOARD_AS_LIST();
        return possibleTakes.stream().filter(field -> (StreamUtils.isInRange(field.getCoords(), getCurrentPos(), RANGE)
                        && (field.getPiece() == null || (field.getPiece().getColor() != this.getColor()))))
                .toList();
    }
}
