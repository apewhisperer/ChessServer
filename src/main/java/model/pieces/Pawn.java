package model.pieces;

import lombok.Getter;
import lombok.Setter;
import model.Board;
import model.Field;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pawn extends Piece {

    //TODO: add Promote() method
    private boolean haveIMoved = false;

    @Override
    public List<Field> findPossibleTakes(Board board) {
        //TODO: implement method body
        return new ArrayList<>();
    }

}
