package model.pieces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Board;
import model.Coordinates;
import model.Field;
import model.enums.Color;
import model.enums.PieceValue;
import utils.FindPossibleTakes;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piece implements FindPossibleTakes {

    private Coordinates currentPos;
    private Color color;
    private PieceValue pieceValue;
    private boolean isActive;

    @Override
    public List<Field> findPossibleTakes(Board board) {
        return new ArrayList<>();
    }
}
