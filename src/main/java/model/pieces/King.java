package model.pieces;

import lombok.AllArgsConstructor;
import model.*;
import model.enums.Color;
import model.enums.PieceValue;
import utils.StreamUtils;

import java.util.List;

@AllArgsConstructor
public class King extends Piece {

    private final int RANGE = 1;

    public King(Coordinates currentPos, Color color, PieceValue value, boolean isActive) {
        super(currentPos, color, value, isActive);
    }

    @Override
    public List<Field> findPossibleTakes(Board board) {
        List<Field> possibleTakes = board.getBoardAsList();
        return possibleTakes.stream().filter(field -> (StreamUtils.isInRange(field.getCoords(), getCurrentPos(), this.RANGE)
                        && field.getPiece() == null))
                .toList();
    }
}
